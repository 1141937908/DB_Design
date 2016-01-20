package com.model;

import com.dao.Daodbc;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by llc_1 on 2016/1/19.
 */
public class Book extends AbstractTableModel{
    Vector rowData,columnNames;
    Daodbc dbc;

    public void queryBook(String sql,String[] paras){
        columnNames=new Vector();
        rowData=new Vector();
        columnNames.add("教材编号");
        columnNames.add("教材名称");
        columnNames.add("出版社");
        columnNames.add("作者");
        columnNames.add("价格");
        columnNames.add("库存量");
        try{
            dbc=new Daodbc();
            ResultSet resultSet=dbc.searchDataBase(sql,paras);
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
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.close();
        }
    }

    public boolean updateBook(String sql,String paras[]) throws Exception {
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