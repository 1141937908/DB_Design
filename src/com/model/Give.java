package com.model;

import com.dao.Daodbc;

import javax.swing.table.AbstractTableModel;

import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by llc_1 on 2016/1/19.
 */
public class Give extends AbstractTableModel{
    Vector rowData,columnNames;
    Daodbc dbc;
    public void queryGive(String sql,String[] paras){
        columnNames=new Vector();
        rowData=new Vector();
        columnNames.add("班级号");
        columnNames.add("教师号");
        columnNames.add("课程号");
        columnNames.add("教材号");
        columnNames.add("是否发放");
        columnNames.add("发放日期");
        try{
            dbc=new Daodbc();
            ResultSet resultSet=dbc.searchDataBase(sql,paras);
            while (resultSet.next()){
                Vector hang = new Vector();
                hang.add(resultSet.getString(1));
                hang.add(resultSet.getString(2));
                hang.add(resultSet.getString(3));
                hang.add(resultSet.getString(4));
                hang.add(resultSet.getString(5));
                hang.add(resultSet.getString(6));
                rowData.add(hang);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.close();
        }
    }

    public boolean updateGive(String sql,String paras[]) throws Exception {
        dbc=new Daodbc();
        boolean flag= dbc.updateDataBase(sql,paras);
        return flag;
    }


    @Override
    public int getRowCount() {
        return this.rowData.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
    }

    public String getColumnName(int column){
        return (String)this.columnNames.get(column);
    }
}