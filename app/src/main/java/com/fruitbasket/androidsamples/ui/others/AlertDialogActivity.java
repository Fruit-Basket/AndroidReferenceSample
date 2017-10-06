package com.fruitbasket.androidsamples.ui.others;

import android.app.Activity;
import android.app.AlertDialog;
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
public class AlertDialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    private View createContentView() {
        LinearLayout linearLayout = new LinearLayout(this);
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
        button.setText("alert dialog");
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(AlertDialogActivity.this);
                ///建造对话框
            }
        });



        return linearLayout;
    }
}
