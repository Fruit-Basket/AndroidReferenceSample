package com.fruitbasket.androidsamples.activity.exchangedata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Author: FruitBasket
 * Time: 2017/9/27
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class TargetActivity extends Activity {
    private static final String TAG="..TargetActivity";

    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        Log.i(TAG,"onCreate(Bundle)");
        setContentView(createContentView());
    }

    private View createContentView(){
        Bundle bundle=getIntent().getExtras();//获取启动本Activity的Intent中的Bundle

        LinearLayout contentView=new LinearLayout(this);
        contentView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        contentView.setOrientation(LinearLayout.VERTICAL);

        LinearLayout linearLayout1=new LinearLayout(this);
        linearLayout1.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);

        TextView nameHint=new TextView(this);
        nameHint.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        nameHint.setText("Name : ");
        linearLayout1.addView(nameHint);

        TextView nameTV=new TextView(this);
        nameTV.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        nameTV.setText(bundle.getString("NAME"));
        linearLayout1.addView(nameTV);

        contentView.addView(linearLayout1);

        LinearLayout linearLayout2=new LinearLayout(this);
        linearLayout2.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);

        TextView sexHint=new TextView(this);
        sexHint.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        sexHint.setText("Sex : ");
        linearLayout2.addView(sexHint);

        TextView sexTV=new TextView(this);
        sexTV.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        sexTV.setText(bundle.getString("SEX"));
        linearLayout2.addView(sexTV);
        contentView.addView(linearLayout2);

        return contentView;
    }
}
