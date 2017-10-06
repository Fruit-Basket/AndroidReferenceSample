package com.fruitbasket.androidsamples.event;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 响应系统设置的事件
 *
 * Author: FruitBasket
 * Time: 2017/9/22
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class ConfigurationActivity extends Activity {

    private static final String TAG=".event.CActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate(Bundle)");
        setContentView(createContentView());
    }

    /**
     * 本程序的<uses-sdk.../>元素的android:targetSdkVersion 属性最高只能设置成12，如果该属性设置得过高，那么本方法将不会被调用
     * ///但是，即使这样，此方法仍没有被调用
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        Log.i(TAG,"onConfigurationChanged(Configuration)");
        String orientation=newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE?"landscape":"vertical";
        Toast.makeText(this,orientation,Toast.LENGTH_SHORT).show();
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

        final TextView textView=new TextView(this);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity=Gravity.CENTER_HORIZONTAL;//对应android:layout_gravity属性
        textView.setLayoutParams(
                layoutParams
        );
        textView.setPadding(0,30,0,30);
        linearLayout.addView(textView);

        Button button=new Button(this);
        button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        button.setText("get configuration");
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Configuration configuration=ConfigurationActivity.this.getResources().getConfiguration();
                String orientation=configuration.orientation==Configuration.ORIENTATION_LANDSCAPE?"landscape":"vertical";
                textView.setText("screen orientation: "+orientation);
            }
        });
        linearLayout.addView(button);

        Button button2=new Button(this);
        button2.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        button2.setText("change orientation");
        button2.setOnClickListener(new View. OnClickListener(){

            @Override
            public void onClick(View view){
                ///有一个奇怪的现状，当调用完这段代码后，屏幕就不会根据手机方向而自动旋转了！
                Configuration configuration=ConfigurationActivity.this.getResources().getConfiguration();

                if(configuration.orientation==Configuration.ORIENTATION_LANDSCAPE){//如果当前是横屏
                    ConfigurationActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                else if(configuration.orientation==Configuration.ORIENTATION_PORTRAIT){//如果当前是竖屏
                    ConfigurationActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        });
        linearLayout.addView(button2);

        return linearLayout;
    }
}
