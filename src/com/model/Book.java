package com.model;

/**
 * Created by secret on 16-1-14.
 */
public class Book {

    private String bookId;
    private String bookName;
    private String bookPublish;
    private String bookWriter;
    private double bookPrice;
    private int bookNumber;

    public Book(){
        super();
    }

    public Book(String bookId , String bookName , String bookPublish , String bookWriter , double bookPrice , int bookNumber){
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPublish = bookPublish;
        this.bookWriter = bookWriter;
        this.bookPrice = bookPrice;
        this.bookNumber = bookNumber;
    }

    public String getBookId(){
        return bookId;
    }

    public String getBookName(){
        return bookName;
    }

    public String getBookPublish(){
        return bookPublish;
    }

    public String getBookWriter(){
        return bookWriter;
    }

    public double getBookPrice(){
        return bookPrice;
    }

    public int getBookNumber(){
        return bookNumber;
    }

    public void setBookId(String bookId){
        this.bookId = bookId;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public void setBookPublish(String bookPublish){
        this.bookPublish = bookPublish;
    }

    public void setBookWriter(String bookWriter){
        this.bookWriter = bookWriter;
    }

    public void setBookPrice(double bookPrice){
        this.bookPrice = bookPrice;
    }

    public void setBookNumber(int bookNumber){
        this.bookNumber = bookNumber;
    }
}
