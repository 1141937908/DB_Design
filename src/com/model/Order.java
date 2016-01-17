package com.model;

import com.dao.Daodbc;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by llc_1 on 2016/1/16.
 */
public class Order extends AbstractTableModel{

    /**
     * 添加基本数据，rowData用来存储行数据,columnNames存放列名
     */
    Vector rowData , columnNames;

    /**
     * 添加课程
     * @param sql
     * @param paras
     * @return
     */
    public boolean addOrder(String sql, String[] paras) throws Exception {
        Daodbc dbc = new Daodbc();
        return dbc.updateDataBase(sql,paras);
    }

    /**
     * 查询课程
     * @param sql
     * @param paras
     */
    public void searchOrder(String sql,String[] paras){
        Daodbc dbc = new Daodbc();
        columnNames = new Vector();
        columnNames.add("班级号");
        columnNames.add("教师号");
        columnNames.add("课程号");
        columnNames.add("教材号");
        columnNames.add("订购数量");
        /*从数据库中取出数据*/
        rowData = new Vector();
        try{
            dbc = new Daodbc();
            ResultSet resultSet = dbc.searchDataBase(sql,paras);
            while (resultSet.next()){
                Vector hang = new Vector();
                hang.add(resultSet.getString("Cno"));
                hang.add(resultSet.getString("Tno"));
                hang.add(resultSet.getString("Lno"));
                hang.add(resultSet.getString("Bno"));
                hang.add(resultSet.getString("Onum"));

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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    /**
     * 得到某行某列数据
     * @param rowIndex
     * @param columnIndex
     * @return
     */
/*    private String Cno;
    private String  Tno;
    private String  Lno;
    private String Bno;
    private int orderNumber;

    public Order(){
        super();
    }

    public Order(String Cno,String Tno,String Lno,String Bno,int orderNumber){
        super();
        this.Cno = Cno;
        this.Tno = Tno;
        this.Lno = Lno;
        this.Bno = Bno;
        this.orderNumber = orderNumber;
    }

    public String getCno(){
        return Cno;
    }

    public String getTno(){
        return Tno;
    }

    public String getLno(){
        return Lno;
    }

    public String getBno(){
        return Bno;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public void setCno(String Cno){
        this.Cno = Cno;
    }

    public void setTno(String Tno){
        this.Tno = Tno;
    }

    public void setLno(String Lno){
        this.Lno = Lno;
    }

    public void setBno(String Bno){
        this.Bno = Bno;
    }

    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }*/
}
