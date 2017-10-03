package com.fruitbasket.androidsamples;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fruitbasket.androidsamples.activity.ActivityLifeCycle;
import com.fruitbasket.androidsamples.activity.exchangedata.OriginActivity;
import com.fruitbasket.androidsamples.activity.launch.FirstActivity;
import com.fruitbasket.androidsamples.event.AsyncTaskActivity;
import com.fruitbasket.androidsamples.event.CallBackActivity;
import com.fruitbasket.androidsamples.event.ConfigurationActivity;
import com.fruitbasket.androidsamples.event.HandlerActivity;
import com.fruitbasket.androidsamples.ui.adapterview.ExpandableListViewActivity;
import com.fruitbasket.androidsamples.ui.adapterview.ListViewActivity;
import com.fruitbasket.androidsamples.ui.layout.LinearLayoutActivity;
import com.fruitbasket.androidsamples.ui.menu.ActionBarActivity;
import com.fruitbasket.androidsamples.ui.others.AlertDialogActivity;
import com.fruitbasket.androidsamples.ui.others.NotificationActivity;

public class MainActivity extends AppCompatActivity {

    private final String[] packages={
            "UI",
            "Event",
            "Activity"
    };
    private final Class[][] classes={
            {
                    ExpandableListViewActivity.class,
                    ListViewActivity.class,
                    LinearLayoutActivity.class,
                    ActionBarActivity.class,
                    AlertDialogActivity.class,
                    NotificationActivity.class
            },
            {
                    CallBackActivity.class,
                    ConfigurationActivity.class,
                    HandlerActivity.class,
                    AsyncTaskActivity.class
            },
            {
                    FirstActivity.class,
                    OriginActivity.class,
                    ActivityLifeCycle.class
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListAdapter adapter=new BaseExpandableListAdapter(){

            @Override
            public int getGroupCount() {
                return packages.length;//返回包含组列表的数量
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return classes[groupPosition].length;//返回特定组所包含的子列表项的数量
            }

            @Override
            public Object getGroup(int groupPosition) {
                return packages[groupPosition];//返回指定组位置处的组数据
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return classes[groupPosition][childPosition];//返回指定组位置、指定子列表项处的子列表项数据
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;//指示是否相同的ID总是代表相同的对象
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout linearLayout=new LinearLayout(MainActivity.this);
                linearLayout.setLayoutParams(
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                );
                TextView textView=new TextView(MainActivity.this);
                LinearLayout.LayoutParams textViewLayoutParams=new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                textView.setLayoutParams(
                        textViewLayoutParams
                );
                textView.setPadding(0,30,0,30);
                textView.setText(getGroup(groupPosition).toString());
                linearLayout.addView(textView);
                return linearLayout;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                LinearLayout linearLayout=new LinearLayout(MainActivity.this);
                linearLayout.setLayoutParams(
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                );
                TextView textView=new TextView(MainActivity.this);
                LinearLayout.LayoutParams textViewLayoutParams=new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                textView.setLayoutParams(
                        textViewLayoutParams
                );
                textView.setPadding(40,30,0,30);
                String text=getChild(groupPosition,childPosition).toString();
                textView.setText(
                        text.substring(
                                text.lastIndexOf(".")+1
                        )
                );
                linearLayout.addView(textView);
                return linearLayout;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };

        ExpandableListView expandableListView=(ExpandableListView)findViewById(R.id.test_elv);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent=new Intent();
                intent.setComponent(
                        new ComponentName(
                                MainActivity.this,
                                classes[groupPosition][childPosition]
                        )
                );
                MainActivity.this.startActivity(intent);
                return true;
            }
        });


        //test

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
