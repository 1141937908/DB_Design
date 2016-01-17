package com.model;

import com.dao.Daodbc;

import javax.swing.table.AbstractTableModel;
import javax.xml.stream.StreamFilter;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by secret on 16-1-14.
 */
public class Teacher extends AbstractTableModel{

    /**
     * 添加基本数据，rowData用来存储行数据,columnNames存放列名
     */
    Vector rowData , columnNames;

    /**
     * 添加教师
     * @param sql
     * @param paras
     * @return
     */
    public boolean addTeacher(String sql, String[] paras) throws Exception {
        Daodbc dbc = new Daodbc();
        return dbc.updateDataBase(sql,paras);
    }

    /**
     * 查询教师
     * @param sql
     * @param paras
     */
    public void searchTeacher(String sql,String[] paras){
        Daodbc dbc = new Daodbc();
        columnNames = new Vector();
        columnNames.add("教师号");
        columnNames.add("姓名");
        columnNames.add("性别");

        /*从数据库中取出数据*/
        rowData = new Vector();
        try{
            dbc = new Daodbc();
            ResultSet resultSet = dbc.searchDataBase(sql,paras);
            while (resultSet.next()){
                Vector hang = new Vector();
                hang.add(resultSet.getString("Tno"));
                hang.add(resultSet.getString("Tname"));
                hang.add(resultSet.getString("Tsex"));
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
    private String teaId;
    private String teaName;
    private String teaSex;

    public Teacher(){
        super();
    }

    public Teacher(String teaId , String teaName , String teaSex){
        super();
        this.teaId =teaId;
        this.teaName = teaName;
        this.teaSex = teaSex;
    }

    public String getTeaId(){
        return teaId;
    }

    public String getTeaName(){
        return teaName;
    }

    public String getTeaSex(){
        return teaSex;
    }

    public void setTeaId(String s){
        this.teaId = teaId;
    }

    public void setTeaName(String text){
        this.teaName = teaName;
    }

    public void setTeaSex(String s){
        this.teaSex = teaSex;
    }


    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return (String)this.getColumnName(int column);
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        *//**
         * arg0表示行 arg1 表示列
         *//*
        return ((Vector)this.rowData.get(arg0)).get(arg1);
        return null;
    }*/
}
