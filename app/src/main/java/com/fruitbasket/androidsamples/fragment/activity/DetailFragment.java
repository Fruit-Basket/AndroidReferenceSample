package com.fruitbasket.androidsamples.fragment.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fruitbasket.androidsamples.R;
import com.fruitbasket.androidsamples.fragment.activity.model.BookContent;

/**
 * Author: FruitBasket
 * Time: 2017/10/5
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class DetailFragment extends Fragment {

    private static final String TAG="...DetailFragment";

    private BookContent.Book book;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate(Bundle)");

        //接收传递过来的数据
        Bundle arguments=getArguments();
        if(arguments.containsKey(BookContent.BOOK_INDEX)){
            book=BookContent.getBook(
                    arguments.getInt(BookContent.BOOK_INDEX)
            );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.i(TAG,"onCreateView(LayoutInflater,ViewGroup,Bundle)");

        if(container!=null){
            Log.i(TAG,container.toString());
            /*
            Log输出如下：
            DetailFragment: android.widget.FrameLayout{bf1e54d V.E...... ........ 856,0-2560,1344 #7f0c0058 app:id/book_detail_f}
             */
        }

        View view=inflater.inflate(R.layout.fragment_book_detail,container,false);
        if(book!=null){
            ((TextView)view.findViewById(R.id.book_detail_tv)).setText(
                    book.title+"\n"
                    +book.description
            );
        }

        return view;
    }

}
