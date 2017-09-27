package com.fruitbasket.androidsamples.event;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 演示利用Handler实现进程间通信
 * Author: FruitBasket
 * Time: 2017/9/25
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class HandlerActivity extends Activity {
    private static final String TAG=".event.HandlerActivity";

    private TextView textView;
    private Task task;

    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        Log.i(TAG,"onCreate(Bundle)");
        setContentView(createContentView());

        task=new Task();
        (new Thread(task)).start();
    }

    private View createContentView(){
        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
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
        button.setText("test1");
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                test1();
            }
        });
        linearLayout.addView(button);

        textView=new TextView(this);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity= Gravity.CENTER_HORIZONTAL;//对应android:layout_gravity属性
        textView.setLayoutParams(
                layoutParams
        );
        linearLayout.addView(textView);
        return linearLayout;
    }

    /**
     * 进程间通信
     * 本示例中，在UI线程中调用本方法，将消息发送对Task线程中
     */
    private void test1(){
        Log.i(TAG,"test1()");
        Message message=new Message();
        message.what=Task.SHOW_TEXT;
        Bundle bundle=new Bundle();
        bundle.putString("TEXT","Hello, Fruit Basket");
        message.setData(bundle);

        task.handler.sendMessage(message);
    }


    private class Task implements Runnable{

        private Handler handler;

        public static final int SHOW_TEXT=0x1;

        @Override
        public void run(){
            Looper.prepare();
            handler=new Handler(){

                @Override
                public void handleMessage(Message message){
                    switch(message.what){
                        case SHOW_TEXT:
                            //不能在这里操作视图组件，因为这里不是UI线程
                            //textView.setText(message.getData().getString("TEXT"));
                            Toast.makeText(HandlerActivity.this,message.getData().getString("TEXT"),Toast.LENGTH_SHORT).show();
                            break;

                        default:

                    }
                }

            };

            Looper.loop();
        }

        public void sendMessage(Message message){
            handler.sendMessage(message);
        }
    }
}
