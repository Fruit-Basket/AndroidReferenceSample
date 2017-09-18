package com.fruitbasket.androidsamples.ui.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fruitbasket.androidsamples.R;

/**
 * 展示LinearLayout的j基本使用方法
 *
 * Author: FruitBasket
 * Time: 2017/9/15
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class LinearLayoutActivity extends Activity {
    private static final String TAG=".ui.Layout.LinearLayout";

    private static final boolean USE_XML=true;

    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);

        if(USE_XML){
            //使用xml创建UI界面
            Log.d(TAG,"use xml");
            setContentView(R.layout.layout_linear);
        }
        else{
            //使用代码创建UI界面
            Log.d(TAG,"use code create ui");

            LinearLayout linearLayout=new LinearLayout(this);
            linearLayout.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT
                    )
            );
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setGravity(android.view.Gravity.CENTER);

            TextView textView=new TextView(this);
            textView.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    )
            );
            textView.setText("Linear Layout (use code)");

            linearLayout.addView(textView);
            setContentView(linearLayout);
        }
    }
}
