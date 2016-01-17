package com.model;

import com.dao.Daodbc;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by secret on 16-1-14.
 */
public class Lesson extends AbstractTableModel{

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
    public boolean addLesson(String sql, String[] paras) throws Exception {
        Daodbc dbc = new Daodbc();
        return dbc.updateDataBase(sql,paras);
    }

    /**
     * 查询课程
     * @param sql
     * @param paras
     */
    public void searchLesson(String sql,String[] paras){
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
/*

    private String lessonId;
    private String lessonName;

    public Lesson(){
        super();
    }

    public  Lesson(String lessonId , String lessonName){
        super();
        this.lessonId = lessonId;
        this.lessonName = lessonName;
    }

    public String getLessonId(){
        return lessonId;
    }

    public String getLessonName(){
        return lessonName;
    }

    public void setLessonId(String lessonId){
        this.lessonId = lessonId;
    }

    public void setLessonName(String lessonName){
        this.lessonName = lessonName;
    }


*/

}
