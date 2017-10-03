package com.fruitbasket.androidsamples.activity.exchangedata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * 展示在Activity之间如何传递数据
 * Author: FruitBasket
 * Time: 2017/9/27
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class OriginActivity extends Activity {
    private static final String TAG="..OriginActivity";

    private EditText nameET;
    private RadioGroup sexRG;

    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(createContentView());
    }

    private View createContentView(){
        LinearLayout contentView=new LinearLayout(this);
        contentView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
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

        TextView nameTV=new TextView(this);
        nameTV.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        nameTV.setText("Name : ");
        linearLayout1.addView(nameTV);

        nameET=new EditText(this);
        nameET.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        linearLayout1.addView(nameET);

        contentView.addView(linearLayout1);

        LinearLayout linearLayout2=new LinearLayout(this);
        linearLayout2.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);

        TextView sexTV=new TextView(this);
        sexTV.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        sexTV.setText("Sex : ");
        linearLayout2.addView(sexTV);
        sexRG=new RadioGroup(this);
        sexRG.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        sexRG.setOrientation(RadioGroup.HORIZONTAL);

        RadioButton maleRB=new RadioButton(this);
        maleRB.setLayoutParams(
                new RadioGroup.LayoutParams(
                        RadioGroup.LayoutParams.WRAP_CONTENT,
                        RadioGroup.LayoutParams.WRAP_CONTENT
                )
        );
        maleRB.setText("male");
        maleRB.setChecked(true);
        sexRG.addView(maleRB);

        RadioButton femaleRB=new RadioButton(this);
        femaleRB.setLayoutParams(
                new RadioGroup.LayoutParams(
                        RadioGroup.LayoutParams.WRAP_CONTENT,
                        RadioGroup.LayoutParams.WRAP_CONTENT
                )
        );
        femaleRB.setText("female");
        sexRG.addView(femaleRB);

        linearLayout2.addView(sexRG);
        contentView.addView(linearLayout2);

        Button button=new Button(this);
        button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        button.setText("start TargetActivity");
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Log.i(TAG,"onClick(View)");
                Intent intent=new Intent(OriginActivity.this,TargetActivity.class);

                Bundle bundle=new Bundle();
                bundle.putString("NAME",nameET.getText().toString().trim());

                String sex="no sex";
                RadioButton button;
                for(int i=0;i<sexRG.getChildCount();++i){
                    button=((RadioButton)sexRG.getChildAt(i));
                    if(button.isChecked()){
                        sex=button.getText().toString();
                    }
                }
                bundle.putString("SEX",sex);

                intent.putExtras(bundle);

                startActivity(intent);//启动目的Activity并传递数据
            }
        });
        contentView.addView(button);

        return contentView;
    }
}
