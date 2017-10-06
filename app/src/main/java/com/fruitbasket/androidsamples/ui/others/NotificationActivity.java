package com.fruitbasket.androidsamples.ui.others;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Author: FruitBasket
 * Time: 2017/9/19
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class NotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(createContentView());
    }

    private View createContentView(){
        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                )
        );
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Button send=new Button(this);
        send.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        send.setText("send");
        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                ///发送通知
            }
        });

        Button cancel=new Button(this);
        send.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        cancel.setText("cancel");
        cancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                ///取消通知
            }
        });

        return linearLayout;
    }
}
