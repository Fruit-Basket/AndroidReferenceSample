package com.fruitbasket.androidsamples.activity.launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 展示开启和关闭Activity
 * Author: FruitBasket
 * Time: 2017/9/27
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
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

        Button button=new Button(this);
        button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        button.setText("start SecondActivity");
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
                FirstActivity.this.finish();//关闭本Activity
            }
        });
        linearLayout.addView(button);

        return linearLayout;
    }
}
