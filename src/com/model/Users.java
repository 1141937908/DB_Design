package com.model;

import com.dao.Daodbc;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by llc_1 on 2016/1/19.
 */
public class Users extends AbstractTableModel{
    Vector rowData,columnNames;
    Daodbc dbc;

    public void queryUsers(String sql,String[] paras){
        columnNames=new Vector();
        rowData=new Vector();
        columnNames.add("账号");
        columnNames.add("密码");
        columnNames.add("姓名");
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

    public boolean updateUsers(String sql,String paras[]) throws Exception {
        dbc=new Daodbc();
        boolean flag= dbc.updateDataBase(sql,paras);
        return flag;
    }

    public boolean checkUsers(String loginuser,String loginpasswd) throws Exception {
        boolean flag = false;
        String sql = "USE DB_Design;SELECT * FROM Users WHERE Uno=? AND Upasswd=?";
        String[] paras={loginuser,loginpasswd};
        dbc=new Daodbc();
        ResultSet resultSet =dbc.searchDataBase(sql,paras);
        boolean rs=resultSet.next();
        try{
            if (rs){
                 flag = true;
            }else{
                flag= false;
            }
        }catch (Exception e){
            flag = false;
            e.printStackTrace();
        }
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