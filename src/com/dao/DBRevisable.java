package com.dao;

/**
 * Created by llc_1 on 2016/1/16.
 */
import com.model.*;

import java.beans.VetoableChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class DBRevisable implements Revisable{

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet;

    public DBRevisable(Connection connection){
        this.connection = connection;
    }

    //TODO flag
    @Override
    public void addBookInfo(Book book) {
        boolean flag = false;
        String sql="INSERT INTO Book (Bno,Bname,Bpublish,Bwriter,Bprice,Bnum) VALUES (?,?,?,?,?,?)";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,book.getBookId());
            this.preparedStatement.setString(2,book.getBookName());
            this.preparedStatement.setString(3,book.getBookPublish());
            this.preparedStatement.setString(4,book.getBookWriter());
            this.preparedStatement.setDouble(5,book.getBookPrice());
            this.preparedStatement.setInt(6,book.getBookNumber());
            /*如果存在更新*/
            if (this.preparedStatement.executeUpdate() > 0 ) {
                flag = true;
            }
            /*断开连接*/
            this.preparedStatement.close();
        }catch (SQLException e){
            System.out.println("Book表信息添加失败！SQL错误！");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("添加Book表信息失败！");
            e.printStackTrace();
        }
//        return flag;
    }

    @Override
    public void addClassInfo(Classes classes) {
        boolean flag = false;
        String sql="INSERT INTO Classes(Cno,Cname,Cnum) VALUES (?,?,?)";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,classes.getClassesId());
            this.preparedStatement.setString(2,classes.getClassesName());
            this.preparedStatement.setInt(3,classes.getClassesNumber());
            /*如果存在更新*/
            if (this.preparedStatement.executeUpdate() > 0 ) {
                flag = true;
            }
            /*断开连接*/
            this.preparedStatement.close();
        }catch (SQLException e){
            System.out.println("Classes表信息添加失败！SQL错误！");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("添加Classes表信息失败！");
            e.printStackTrace();
        }
//        return flag;
    }

    @Override
    public void addLessonInfo(Lesson lesson) {
        boolean flag = false;
        String sql="INSERT INTO Lesson(Lno,Lname) VALUES (?,?)";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,lesson.getLessonId());
            this.preparedStatement.setString(2,lesson.getLessonName());
            /*如果存在更新*/
            if (this.preparedStatement.executeUpdate() > 0 ) {
                flag = true;
            }
            /*断开连接*/
            this.preparedStatement.close();
        }catch (SQLException e){
            System.out.println("Lesson表信息添加失败！SQL错误！");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("添加Lesson表信息失败！");
            e.printStackTrace();
        }
//        return flag;
    }

    @Override
    public void addTeacherInfo(Teacher teacher) {
        boolean flag = false;
        String sql="INSERT INTO Teacher(Tno,Tname,Tsex) VALUES (?,?,?)";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,teacher.getTeaId());
            this.preparedStatement.setString(2,teacher.getTeaName());
            this.preparedStatement.setString(3,teacher.getTeaSex());
            //*如果存在更新*/
            if (this.preparedStatement.executeUpdate() > 0 ) {
                flag = true;
            }
            /*断开连接*/
            this.preparedStatement.close();
        }catch (SQLException e){
            System.out.println("Book表信息添加失败！SQL错误！");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("添加Book表信息失败！");
            e.printStackTrace();
        }
//        return flag;
    }

    @Override
    public void addUsersInfo(Users users) {
        boolean flag = false;
        String sql="INSERT INTO Users(Uno,Upassword,Uname) VALUES (?,?,?)";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,users.getId());
            this.preparedStatement.setString(2,users.getPassword());
            this.preparedStatement.setString(3,users.getUserName());
            /*如果存在更新*/
            if (this.preparedStatement.executeUpdate() > 0 ) {
                flag = true;
            }
            /*断开连接*/
            this.preparedStatement.close();
        }catch (SQLException e){
            System.out.println("Book表信息添加失败！SQL错误！");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("添加Book表信息失败！");
            e.printStackTrace();
        }
//        return flag;
    }

    @Override
    public void addOrderInfo(Order order) {
        boolean flag = false;
        String sql="INSERT INTO Order(Cno,Tno,Lno,Bno,Onum) VALUES (?,?,?,?,?)";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,order.getCno());
            this.preparedStatement.setString(2,order.getTno());
            this.preparedStatement.setString(3,order.getLno());
            this.preparedStatement.setString(4,order.getBno());
            this.preparedStatement.setInt(5,order.getOrderNumber());
            /*如果存在更新*/
            if (this.preparedStatement.executeUpdate() > 0 ) {
                flag = true;
            }
            /*断开连接*/
            this.preparedStatement.close();
        }catch (SQLException e){
            System.out.println("Order表信息添加失败！SQL错误！");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("添加Order表信息失败！");
            e.printStackTrace();
        }
//        return flag;
    }

    @Override
    public void addGiveInfo(Give give) {
        boolean flag = false;
        String sql="INSERT INTO Give(Cno,Tno,Lno,Bno,Gs,Gdata) VALUES (?,?,?,?,?,?)";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,give.getCno());
            this.preparedStatement.setString(2,give.getTno());
            this.preparedStatement.setString(3,give.getLno());
            this.preparedStatement.setString(4,give.getBno());
            this.preparedStatement.setBoolean(5,give.getGiveState());
            this.preparedStatement.setString(6,give.getGiveDatatime());
            /*如果存在更新*/
            if (this.preparedStatement.executeUpdate() > 0 ) {
                flag = true;
            }
            /*断开连接*/
            this.preparedStatement.close();
        }catch (SQLException e){
            System.out.println("Give表信息添加失败！SQL错误！");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("添加Give表信息失败！");
            e.printStackTrace();
        }
//        return flag;
    }
/*

    @Override
    public void delBookInfo(String name) {
        boolean flag = false;
        String sql = "DELETE FROM Book WHERE Bno=?";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,name);
            *//*
*/
/*如果存在更新*//*
*/
/*
            if (this.preparedStatement.executeUpdate() > 0){
                flag = true;
            }
            *//*
*/
/*断开连接*//*
*/
/*
            this.preparedStatement.close();;
        }catch (SQLException e){
            System.out.println("");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("");
            e.printStackTrace();
        }
//        return;flag;
    }

    @Override
    public void delClassInfo(String name) {
        boolean flag = false;
        String sql = "DELETE FROM Classes WHERE Cno=?";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,name);
            *//*
*/
/*如果存在更新*//*
*/
/*
            if (this.preparedStatement.executeUpdate() > 0){
                flag = true;
            }
            *//*
*/
/*断开连接*//*
*/
/*
            this.preparedStatement.close();;
        }catch (SQLException e){
            System.out.println("");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("");
            e.printStackTrace();
        }
//        return;flag;
    }

    @Override
    public void delLessonInfo(String name) {
        boolean flag = false;
        String sql = "DELETE FROM Lesson WHERE Lno=?";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,name);
            *//*
*/
/*如果存在更新*//*
*/
/*
            if (this.preparedStatement.executeUpdate() > 0){
                flag = true;
            }
            *//*
*/
/*断开连接*//*
*/
/*
            this.preparedStatement.close();;
        }catch (SQLException e){
            System.out.println("");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("");
            e.printStackTrace();
        }
//        return;flag;
    }

    @Override
    public void delTeacherInfo(String name) {
        boolean flag = false;
        String sql = "DELETE FROM Teacher WHERE Tno=?";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,name);
            *//*
*/
/*如果存在更新*//*
*/
/*
            if (this.preparedStatement.executeUpdate() > 0){
                flag = true;
            }
            *//*
*/
/*断开连接*//*
*/
/*
            this.preparedStatement.close();;
        }catch (SQLException e){
            System.out.println("");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("");
            e.printStackTrace();
        }
//        return;flag;
    }

    @Override
    public void delUsersInfo(String name) {
        boolean flag = false;
        String sql = "DELETE FROM Users WHERE Uno=?";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,name);
            *//*
*/
/*如果存在更新*//*
*/
/*
            if (this.preparedStatement.executeUpdate() > 0){
                flag = true;
            }
            *//*
*/
/*断开连接*//*
*/
/*
            this.preparedStatement.close();;
        }catch (SQLException e){
            System.out.println("");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("");
            e.printStackTrace();
        }
//        return;flag;
    }

    @Override
    public void delOrderInfo(String name) {

    }

    @Override
    public void delGiveInfo(String name) {

    }
*/

    public void delInfo(String name,String table,String primaryKey){
        boolean flag = false;
        String sql = "DELETE FROM Book WHERE ? = ?";

        try{
            this.preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,name);
            this.preparedStatement.setString(2,table);
            //this.preparedStatement.setString(3,primaryKey);
            /*如果存在则更新*/
            if(this.preparedStatement.executeUpdate() > 0){
                flag = true;
            }
            /*断开连接*/
            this.preparedStatement.close();
        }catch (SQLException e){
            System.out.println("删除行数据失败！SQL错误！");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("删除行数据失败！");
            e.printStackTrace();
        }
//        return;flag;
    }

    @Override
    public void ModifyBookInfo(String name, Book book) {

    }

    @Override
    public void ModifyClassesInfo(String name, Classes classes) {

    }

    @Override
    public void ModifyLessonInfo(String name, Lesson lesson) {

    }

    @Override
    public void ModifyTeacherInfo(String name, Teacher teacher) {

    }

    @Override
    public void ModifyUsersInfo(String name, Users users) {

    }

    @Override
    public void ModifyOrderInfo(String name, Order order) {

    }

    @Override
    public void ModifyGiveInfo(String name, Give give) {

    }

    @Override
    public Vector searchBookInfo(String name) {
        return null;
    }

    @Override
    public Vector searchClassesInfo(String name) {
        boolean flag = false;
        String sql1 = "SELECT * FROM Classes WHERE Cno=?";
        String sql2 = "SELECT * FROM Classes";
        Classes classes = new Classes();
        Vector hang = new Vector();
        Vector row = new Vector();
        try{

            if (name=="*"){
                this.preparedStatement = this.connection.prepareStatement(sql2);
            }else {
                this.preparedStatement = this.connection.prepareStatement(sql1);
                this.preparedStatement.setString(1,name);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                classes.setClassesId(resultSet.getString("Cno"));
                classes.setClassesName(resultSet.getString("Cname"));
                classes.setClassesNumber(resultSet.getInt("Cnum"));
                row.add(hang);
            }
        }catch (SQLException e){
            System.out.println("数据库操作失败！SQL错误！");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("操作错误！");
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Lesson searchLessonInfo(String name) {
        return null;
    }

    @Override
    public Teacher searchTeacherInfo(String name) {
        return null;
    }

    @Override
    public Users searchUsersInfo(String name) {
        return null;
    }

    @Override
    public Order searchOrderInfo(String name) {
        return null;
    }

    @Override
    public Give searchGiveInfo(String name) {
        return null;
    }
}
