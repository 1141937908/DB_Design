package com.view;

/**
 * Created by llc_1 on 2016/1/15.
 */

//import com.sun.org.apache.xpath.internal.operations.String;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import java.sql.*;
import java.util.*;



public class test extends JFrame {

    public test(){
        init();
    }

    private void init(){
        try {
            rowData = new Vector();
            columnNames = new Vector();
            Vector hang = new Vector();

            columnNames.add("姓名");
            columnNames.add("性别");
            columnNames.add("年龄");
            columnNames.add("籍贯");
            columnNames.add("系别");
            columnNames.add("备注");

            Class.forName(DBurl);
            conn=DriverManager.getConnection(url,user,password);
            sql = "SELECT * FROM stu";
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                hang.add(resultSet.getString(1));
                hang.add(resultSet.getString(2));
                hang.add(resultSet.getString(3));
                hang.add(resultSet.getString(4));
                hang.add(resultSet.getString(5));
                hang.add(resultSet.getString(6));

                rowData.add(hang);
//                System.out.println(rowData);
            }
            jTable = new JTable(rowData,columnNames);
            jScrollPane = new JScrollPane(jTable);
        }catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }finally {
            try{
                if (resultSet!=null)    resultSet.close();
                if (preparedStatement!=null)    preparedStatement.close();
                if (conn!=null) conn.close();
            }catch (Exception e){
                System.out.println("error2");
                e.printStackTrace();
            }
        }

        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(jScrollPane);
    }

    public static void  main(String[] args){
        try{
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        test t= new test();
    }

    private JTable jTable;
    private JScrollPane jScrollPane;
    private Vector rowData,columnNames;
    private String url="jdbc:mysql://localhost:3306/student";
    private String user="root";
    private String password="";
    private String DBurl="com.mysql.jdbc.Driver";
    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String sql;
}
