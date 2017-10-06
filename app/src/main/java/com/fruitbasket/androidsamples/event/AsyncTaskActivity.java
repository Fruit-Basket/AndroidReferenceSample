package com.fruitbasket.androidsamples.event;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.URL;

/**
 * 展示AsyncTask的使用方法
 * Author: FruitBasket
 * Time: 2017/9/26
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class AsyncTaskActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(createContentView());
    }

    private View createContentView() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        textView=new TextView(this);
        textView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        textView.setText("see AsyncTaskActivity");
        linearLayout.addView(textView);

        return linearLayout;
    }


    private class Task extends AsyncTask<URL,Integer,String>{

        @Override
        protected String doInBackground(URL... params) {
            return null;
        }

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected void onPostExecute(String result){

        }

        @Override
        protected void onProgressUpdate(Integer...values){

        }

    }
}
