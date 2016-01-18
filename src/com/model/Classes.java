package com.model;

import com.dao.Daodbc;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by secret on 16-1-14.
 */
public class Classes extends AbstractTableModel {

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
    public boolean addClasses(String sql, String[] paras) throws Exception {
        Daodbc dbc = new Daodbc();
        return dbc.updateDataBase(sql,paras);
    }

    /**
     * 查询课程
     * @param sql
     * @param paras
     */
    public void searchClasses(String sql,String[] paras){
        Daodbc dbc = new Daodbc();
        columnNames = new Vector();
        columnNames.add("课程号");
        columnNames.add("课程名");

        /*从数据库中取出数据*/
        rowData = new Vector();
        try{
            dbc = new Daodbc();
            ResultSet resultSet = dbc.searchDataBase(sql,paras);
            while (resultSet.next()){
                Vector hang = new Vector();
                hang.add(resultSet.getString("Lno"));
                hang.add(resultSet.getString("Lname"));
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

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    /**
     * 重载方法 getColumnName
     */
    public String getColumnName(int column){
        return (String)this.columnNames.get(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

   /* private String classesId;
    private String classesName;
    private int classesNumber;

    public Classes(){
        super();
    }

    public Classes(String classesId , String classesName , int classesNumber){
        super();
        this.classesId = classesId;
        this.classesName = classesName;
        this.classesNumber = classesNumber;
    }



    public String getClassesId(){
        return classesId;
    }

    public String getClassesName(){
        return classesName;
    }

    public int getClassesNumber(){
        return classesNumber;
    }

    public void setClassesId(String classesId){
        this.classesId = classesId;
    }

    public void setClassesName(String classesName){
        this.classesName = classesName;
    }

    public void setClassesNumber(int classesNumber){
        this.classesNumber = classesNumber;
    }*/
}
