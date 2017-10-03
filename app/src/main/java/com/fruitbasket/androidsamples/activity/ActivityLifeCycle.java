package com.fruitbasket.androidsamples.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Author: FruitBasket
 * Time: 2017/9/29
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class ActivityLifeCycle extends Activity {
    private static final String TAG=".ActivityLifeCycle";

    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        Log.i(TAG,"onCreate(Bundle): 创建Activity时被回调，本方法只会被调用一次");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart(): 重新启动Activity时被回调");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG,"onStart(): 启动Activity时被回调");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG,"onResume(): 恢复Activity时被回调");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG,"onPause(): 暂停Activity是被回调");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"onStop(): 停止Activity时被回调");
    }

    @Override
    protected void onDestroy(){
        Log.i(TAG,"onDestroy(): 销毁Activity时被回调，本方法只会被回调一次");
        super.onDestroy();
    }


}
