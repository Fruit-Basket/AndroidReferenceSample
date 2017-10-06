package com.fruitbasket.androidsamples.fragment.activity.model;

import android.util.Log;

/**
 * Author: FruitBasket
 * Time: 2017/10/4
 * Email: FruitBasket@qq.com
 * Source code: github.com/DevelopersAssociation
 */
public class BookContent {

    private static final BookContent instance=new BookContent();

    public static final String BOOK_INDEX="book_index";

    public static final Book[] books={
            new Book("C Programming","This book introduces how to develop programs using C."),
            new Book("The 7 Habits of Highly Effective People","The book introduces seven life habits and tell us that how this habits inprove our life."),
            new Book("Data Struture","The author is Weimin Yan, Dongmei Li and Weiming Wu.")
    };

    private BookContent(){}

    public BookContent getInstance(){
        return instance;
    }

    public static Book getBook(int index){
        if(index>=0&&index<books.length){
            return books[index];
        }
        else{
            Log.w("BookContent","getBook(int): index out of range");
            return null;
        }
    }

    public static class Book{

        public String title;
        public String description;

        public Book(String title,String description){
            this.title=title;
            this.description=description;
        }
    }
}
