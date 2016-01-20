package com.model;

import com.dao.Daodbc;

import javax.swing.table.AbstractTableModel;

import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by llc_1 on 2016/1/19.
 */
public class Classes extends AbstractTableModel{
    Vector rowData,columnNames;
    Daodbc dbc;
    public void queryClasses(String sql,String[] paras){
        columnNames=new Vector();
        rowData=new Vector();
        columnNames.add("班级号");
        columnNames.add("班级名");
        columnNames.add("人    数");
        try{
            dbc=new Daodbc();
            ResultSet resultSet=dbc.searchDataBase(sql,paras);
            while (resultSet.next()){
                Vector hang = new Vector();
                hang.add(resultSet.getString(1));
                hang.add(resultSet.getString(2));
                hang.add(resultSet.getString(3));
                rowData.add(hang);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.close();
        }
    }

    public boolean updateClasses(String sql,String paras[]) throws Exception {
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