package com.fruitbasket.androidsamples.event;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 基于回调的事件处理模型
 * ///不知为何，不起作用
 *
 * 当该组件上发生某个按键被按下的事件时，Android系统最先出发的是
 * 1.该按键上绑定的事件监听器；
 * 2.该组件提供的事件回调方法；
 * 3.传播到该组件所在的Activity。
 * 但是如果我们让任何一个事件处理方法返回了true，那么改事件将不会继续向外传播
 * Author: FruitBasket
 * Time: 2017/9/22
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class CallBackActivity extends Activity {
    private static final String TAG=
            CallBackActivity.class.toString().substring(CallBackActivity.class.toString().lastIndexOf(".")+1);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate(Bundle)");
        setContentView(createContentView());
    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        super.onKeyDown(keyCode,event);
        Log.i(TAG,"onKeyDown(int,KeyEvent)");
        return false;//表明事件并未处理完成，这个事件会继续传递
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

        MyButton button=new MyButton(this);
        button.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        button.setText("click");
        button.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i(TAG,"onKeyDown(View,int,KeyEvent)");
                if(event.getAction()==KeyEvent.ACTION_DOWN){//只处理按下键的事件
                    Log.d(TAG,"action down");
                }
                return false;//表明事件并未处理完成，这个事件会继续传递
            }
        });
        linearLayout.addView(button);
        return linearLayout;
    }

    public class MyButton extends Button {
        private final String TAG=
                MyButton.class.toString().substring(MyButton.class.toString().lastIndexOf(".")+1);

        public MyButton(Context context) {
            super(context);
        }

        @Override
        public boolean onKeyDown(int keyCode,KeyEvent event){
            super.onKeyDown(keyCode,event);
            Log.i(TAG,"onKeyDown(int,KeyEvent): keyCode="+keyCode+", KeyEvent="+event);
            return false;//表明事件并未处理完成，这个事件会继续传递
        }
    }
}
