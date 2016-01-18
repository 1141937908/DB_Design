package com.model;

import com.dao.Daodbc;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by secret on 16-1-14.
 */
public class Book extends AbstractTableModel{
    /**
     * 添加基本数据，rowData用来存储行数据,columnNames存放列名
     */
    Vector rowData , columnNames;

    /**
     * 添加教材
     * @param sql
     * @param paras
     * @return
     */
    public boolean addBook(String sql, String[] paras) throws Exception {
        Daodbc dbc = new Daodbc();
        return dbc.updateDataBase(sql,paras);
    }

    /**
     * 查询教材
     * @param sql
     * @param paras
     */
    public void searchBook(String sql,String[] paras){
        Daodbc dbc = new Daodbc();
        columnNames = new Vector();
        columnNames.add("教材编号");
        columnNames.add("教材名称");
        columnNames.add("出版社");
        columnNames.add("作者");
        columnNames.add("价格");
        columnNames.add("库存量");

        /*从数据库中取出数据*/
        rowData = new Vector();
        try{
            dbc = new Daodbc();
            ResultSet resultSet = dbc.searchDataBase(sql,paras);
            while (resultSet.next()){
                Vector hang = new Vector();
                hang.add(resultSet.getString("Bno"));
                hang.add(resultSet.getString("Bname"));
                hang.add(resultSet.getString("Bpublish"));
                hang.add(resultSet.getString("Bwriter"));
                hang.add(resultSet.getString("Bprice"));
                hang.add(resultSet.getString("Bnum"));
                rowData.add(hang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbc.close();
        }
    }

    /**
     * 得到行数
     * @return
     */

    public int getRowCount() {
        return  this.rowData.size();
//        return 0;
    }

    /**
     * 得到列数
     * @return
     */

    public int getColumnCount() {
        return this.columnNames.size();
//        return 0;
    }

    /**
     * 得到某行某列数据
     * @param rowIndex
     * @param columnIndex
     * @return
     */

    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
//        return null;
    }

    /**
     * 重载方法 getColumnName
     */
    public String getColumnName(int column){
        return (String)this.columnNames.get(column);
    }
/*
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
    }*/
}
