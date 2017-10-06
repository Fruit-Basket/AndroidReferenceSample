package com.fruitbasket.androidsamples.fragment.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import com.fruitbasket.androidsamples.R;
import com.fruitbasket.androidsamples.fragment.activity.model.BookContent;

/**
 * Author: FruitBasket
 * Time: 2017/10/2
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class FragmentContainer extends Activity
        implements MyListFragment.Callbacks {

    private static final String TAG="...FragmentContainer";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate(Bundle)");

        setContentView(R.layout.activity_book_twopane);
    }

    /**
     *
     * @param index 对应{@link com.fruitbasket.androidsamples.fragment.activity.model.BookContent#books}的下标
     */
    @Override
    public void onItemSelected(int index) {
        Log.i(TAG,"onItemSelected(int)");
        /*
        在Activity中中创建Bundle，并调用Fragment的setArguments(Bundle)方法即可将Bundle传给Fragment
         */

        DetailFragment detailFragment=new DetailFragment();

        Bundle arguments=new Bundle();
        arguments.putInt(BookContent.BOOK_INDEX,index);
        detailFragment.setArguments(arguments);

        /*
        Fragment事务代表了Activity对Fragment执行的多个改变操作
         */
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(
                R.id.book_detail_f,
                detailFragment
        );
        fragmentTransaction.commit();
    }
}
