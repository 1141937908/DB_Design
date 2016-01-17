package com.dao;

/**
 * Created by llc_1 on 2016/1/16.
 */

import java.sql.*;

public class Daodbc {

    /**
     * 数据库基本信息
     */
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/DB_Design";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "";
    private Connection conn;

    /**
     * 连接数据库
     * @throws Exception
     */
    public void getCon() throws Exception{
        try{
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        } catch (ClassNotFoundException e){
            System.out.println("数据库连接失败！无法找到指定的类异常！" +
                    "请尝试寻找以下可能的原因：1.所需要的支持类库放错了地方 2.使用类名错误或使用重复类库 3.没有导入JDBC驱动包");
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("数据库连接失败！执行SQL操作失败！");
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     */
    public Connection getConnection() {
        return this.conn;
    }

    /**
     * 断开数据库连接
     */
    public void getClose(Connection connection,Statement statement,ResultSet resultSet){
            try{
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e){
                System.out.println("数据库断开失败！执行SQL操作失败！");
                e.printStackTrace();
            }

    }

}
