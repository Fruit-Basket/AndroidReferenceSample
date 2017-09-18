package com.fruitbasket.androidsamples.ui.adapterview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.fruitbasket.androidsamples.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 展示ListView使用方法
 * Adapter负责提供每个”列表项“组件，AdapterView则负责采用合适的方式显示这些列表项
 * Author: FruitBasket
 * Time: 2017/9/15
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class ListViewActivity extends Activity {
    private static final String TAG="ui.adapterview.ListViewActivity";

    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.adapter_view_list);

        /**
         * 使用ArrayAdapter
         */
        ListView listView2=(ListView)findViewById(R.id.test2_lv);
        String[] names={"Monkey.D.Luffy","Zoro","Nami"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(
                this,
                R.layout.adapter_view_list_item,//指定ArrayAdapter的列表项组件
                names
        );
        listView2.setAdapter(arrayAdapter);

        /**
         * 使用SampleAdapter
         */
        ListView listView3=(ListView)findViewById(R.id.test3_lv);
        String[] descs=new String[]{
                "one piece",
                "swordsman",
                "seawoman"
        };
        List<Map<String,Object>> listItems=new ArrayList<>();
        for(int i=0;i<names.length;++i){
            Map<String,Object> listItem=new HashMap<>();
            listItem.put("name",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(
                this,
                listItems,//指定一个集合，该集合中的Map<String,?>对象将被用于生成列表项
                R.layout.adapter_view_list_item2,//指定一个界面布局ID
                new String[]{"name","desc"},//指定提取Map<String,?>对象中哪些key对应的value来生成列表项
                new int[]{R.id.name,R.id.desc}//指定填充哪些组件
        );
        listView3.setAdapter(simpleAdapter);

        /**
         * 使用BaseAdapter
         */
        ListView listView4=(ListView)findViewById(R.id.test4_lv);
        BaseAdapter baseAdapter=new BaseAdapter(){

            @Override
            public int getCount() {
                return 3;//指定这个BaseAdapter包含多少个列表项
            }

            @Override
            public Object getItem(int position) {
                return null;///返回值决定第position处的列表项的内容？
            }

            @Override
            public long getItemId(int position) {
                return position;//返回值决定地position处的列表项的ID
            }

            @Override
            public View getView(int position,
                                View convertView,
                                ViewGroup parent) {
                LinearLayout linearLayout=new LinearLayout(ListViewActivity.this);
                linearLayout.setLayoutParams(
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                );
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                TextView textView=new TextView(ListViewActivity.this);
                textView.setLayoutParams(
                       new LinearLayout.LayoutParams(
                               LinearLayout.LayoutParams.MATCH_PARENT,
                               LinearLayout.LayoutParams.MATCH_PARENT
                       )
                );
                textView.setText("position: "+position);
                linearLayout.addView(textView);
                return linearLayout;//返回值决定第position处的列表项组件
            }
        };
        listView4.setAdapter(baseAdapter);
    }
}
