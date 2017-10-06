package com.fruitbasket.androidsamples.fragment.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.fruitbasket.androidsamples.fragment.activity.model.BookContent;

/**
 * Author: FruitBasket
 * Time: 2017/10/4
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class MyListFragment extends Fragment {

    private static final String TAG="..MyListFragment";

    private Callbacks callbacks;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.i(TAG,"onAttach(Context)");

        if((context instanceof Callbacks)==false){
            throw new IllegalStateException("MyListFragment所在的Activity必须实现Callbacks接口！");
        }
        else{
            callbacks=(Callbacks)context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate(Bundle)");
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        Log.i(TAG,"onCreateView(LayoutInflater,ViewGroup,Bundle)");

        ListView listView=new ListView(this.getActivity());
        listView.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );
        listView.setAdapter(
                new BaseAdapter(){

                    @Override
                    public int getCount() {
                        return BookContent.books.length;//指定这个BaseAdapter包含多少个列表项
                    }

                    @Override
                    public Object getItem(int position) {
                        return null;
                    }

                    @Override
                    public long getItemId(int position) {
                        return position;//返回值决定地position处的列表项的ID
                    }

                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {
                        LinearLayout linearLayout=new LinearLayout(MyListFragment.this.getActivity());
                        linearLayout.setLayoutParams(
                                new LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.MATCH_PARENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                )
                        );
                        linearLayout.setOrientation(LinearLayout.VERTICAL);

                        TextView textView=new TextView(MyListFragment.this.getActivity());
                        textView.setLayoutParams(
                                new LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.MATCH_PARENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                )
                        );
                        textView.setText(BookContent.books[position].title);
                        linearLayout.addView(textView);
                        return linearLayout;//返回值决定第position处的列表项组件
                    }
                }
        );
        listView.setOnItemClickListener(
                new ListView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Log.i(TAG,"onItemClick(AdapterView<?>,View,int,long)");

                       if(callbacks!=null){
                           callbacks.onItemSelected(position);
                    }
                       else{
                           Log.w(TAG,"callbacks==null");
                       }
                    }
                }
        );

        if(savedInstanceState!=null){

        }

        if(container!=null){
            Log.d(TAG,"container!=null");
            container.addView(listView);
            return container;
        }
        else{
            Log.d(TAG,"container==null");
            return listView;
        }

    }

    /**
     * 定义一个回调接口，本Fragment所在的的Activity需要实现该接口
     * 本Fragment将通过这个接口与它所在的Activity交互
     */
    public interface Callbacks{

        /**
         *
         * @param index 对应{@link com.fruitbasket.androidsamples.fragment.activity.model.BookContent#books}的下标
         */
        public abstract void onItemSelected(int index);
    }
}
