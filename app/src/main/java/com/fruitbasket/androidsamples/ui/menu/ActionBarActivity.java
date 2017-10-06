package com.fruitbasket.androidsamples.ui.menu;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fruitbasket.androidsamples.ui.others.AlertDialogActivity;

/**
 * Author: FruitBasket
 * Time: 2017/9/19
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class ActionBarActivity extends Activity {
    private static final String TAG="ActionBarActivity";

    private Button showB;
    private Button cancelB;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View contentView=createContentView();
        setContentView(contentView);

        final ActionBar actionBar=getActionBar();

        if(actionBar!=null){
            showB.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    actionBar.show();
                }
            });

            cancelB.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    actionBar.hide();
                }
            });
        }
        else{
            Log.w(TAG,"actionBar==null");
        }
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

        showB=new Button(this);
        showB.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        showB.setText("show ActionBar");
        linearLayout.addView(showB);

        cancelB=new Button(this);
        cancelB.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        cancelB.setText("cancel");
        linearLayout.addView(cancelB);

        return linearLayout;
    }
}
