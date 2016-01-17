package com.model;

import com.dao.Daodbc;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.util.Vector;
/**
 * Created by secret on 16-1-14.
 */
public class Users extends AbstractTableModel{

    /**
     * 添加基本数据，rowData用来存储行数据,columnNames存放列名
     */
    Vector rowData , columnNames;

    /**
     * 添加用户
     * @param sql
     * @param paras
     * @return
     */
    public boolean addUsers(String sql, String[] paras) throws Exception {
        Daodbc dbc = new Daodbc();
        return dbc.updateDataBase(sql,paras);
    }

    /**
     * 查询用户
     * @param sql
     * @param paras
     */
    public void searchUsers(String sql,String[] paras){
        Daodbc dbc = new Daodbc();
        columnNames = new Vector();
        columnNames.add("账号");
        columnNames.add("密码");
        columnNames.add("姓名");

        /*从数据库中取出数据*/
        rowData = new Vector();
        try{
            dbc = new Daodbc();
            ResultSet resultSet = dbc.searchDataBase(sql,paras);
            while (resultSet.next()){
                Vector hang = new Vector();
                hang.add(resultSet.getString("Uno"));
                hang.add(resultSet.getString("Upasswd"));
                hang.add(resultSet.getString("Uname"));
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
    @Override
    public int getRowCount() {
        return  this.rowData.size();
//        return 0;
    }

    /**
     * 得到列数
     * @return
     */
    @Override
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
    @Override
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
    /*private String id;
    private String password;
    private String userName;

    public Users(){
        super();
    }

    public Users(String id , String password){
        super();
        this.id = id;
        this.password = password;
    }

    public Users(String id , String password , String userName){
        super();
        this.id = id;
        this.password = password;
        this.userName = userName;
    }

    public String  getId(){
        return id;
    }

    public String  getPassword(){
        return password;
    }

    public String  getUserName(){
        return userName;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }*/

}
