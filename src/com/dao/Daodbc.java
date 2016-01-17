package com.dao;

/**
 * Created by llc_1 on 2016/1/16.
 */

import java.rmi.server.ExportException;
import java.sql.*;

public class Daodbc {

    /**
     * 数据库基本信息
     */
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBL = "jdbc:mysql://localhost:3306/DB_Design";
    private static final String DAUBER = "root";
    private static final String DAGWOOD = "";
    /**
     * 数据库基本操作定义
     */
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    /**
     * 连接数据库
     * @throws Exception
     */
    public ResultSet connection(String sql) throws Exception{
        try{
            //加载驱动
            Class.forName(DRIVER);
            //得到连接
            this.connection = DriverManager.getConnection(DBL, DAUBER, DAGWOOD);
            //创建preparedstatement
            preparedStatement = connection.prepareStatement(sql);
            //得到当前数据库结果
            resultSet = preparedStatement.executeQuery();
        } catch (ClassNotFoundException e){
            System.out.println("数据库连接失败！无法找到指定的类异常！" +
                    "请尝试寻找以下可能的原因：1.所需要的支持类库放错了地方 2.使用类名错误或使用重复类库 3.没有导入JDBC驱动包");
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("数据库连接失败！执行SQL操作失败！");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //TODO 关闭资源
        }
        return resultSet;
    }

    /**
     * 断开数据库连接
     */
    public void close(){
            try{
                if (connection != null) connection.close();
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e){
                System.out.println("数据库断开失败！执行SQL操作失败！");
                e.printStackTrace();
            }
    }

    /**
     * 查询数据库
     */
    public ResultSet searchDataBase(String sql , String[] paras) throws Exception{
        try{
            //连接数据库
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DBL,DAUBER,DAGWOOD);
            preparedStatement = connection.prepareStatement(sql);

            for (int i=0 ; i<paras.length;i++){
                preparedStatement.setString(i+1,paras[i]);
            }
            resultSet = preparedStatement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //TODO 关闭资源
        }
        return resultSet;
    }

    /**
     * 操作数据库（增删改）
     */
    public boolean updateDataBase(String sql,String[] paras)throws Exception {
        boolean flag = true;
        try{
            //连接数据库
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DBL,DAUBER,DAGWOOD);
            preparedStatement = connection.prepareStatement(sql);
            for (int i=0;i<paras.length;i++){
                preparedStatement.setString(i+1,paras[i]);
            }
            //不能出现preparedStatement.excuteUpdate()，否则会报违反主键约束
            if (preparedStatement.executeUpdate()!=1){
                flag = false;
            }
        }catch (Exception e){
            flag = false;
            e.printStackTrace();
        }finally {
            //TODO 关闭资源
            this.close();
        }
        return flag;
    }

    /**
     * 获取连接
     * @return
     */
    public Connection getConnection() {
        return this.connection;
    }
}
