package com.dao;

/**
 * Created by llc_1 on 2016/1/16.
 */

import com.model.*;

import java.util.Vector;

public interface Revisable {
    /**
     * 增
     * @param book
     */
    public void addBookInfo(Book book);
    public void addClassInfo(Classes classes);
    public void addLessonInfo(Lesson lesson);
    public void addTeacherInfo(Teacher teacher);
    public void addUsersInfo(Users users);
    public void addOrderInfo(Order order);
    public void addGiveInfo(Give give);

    /**
     * 删
     * @param name
     */
//    public void delBookInfo(String name);
//    public void delClassInfo(String name);
//    public void delLessonInfo(String name);
//    public void delTeacherInfo(String name);
//    public void delUsersInfo(String name);
//    public void delOrderInfo(String name);
//    public void delGiveInfo(String name);
    public void delInfo(String name,String table,String primaryKey);

    /**
     * 改
     * @param name
     * @param book
     */
    public void ModifyBookInfo(String name , Book book);
    public void ModifyClassesInfo(String name,Classes classes);
    public void ModifyLessonInfo(String name, Lesson lesson);
    public void ModifyTeacherInfo(String name,Teacher teacher);
    public void ModifyUsersInfo(String name,Users users);
    public void ModifyOrderInfo(String name,Order order);
    public void ModifyGiveInfo(String name,Give give);

    /**
     * 查
     * @param name
     * @return
     */
    public Vector searchBookInfo(String name);
    public Vector searchClassesInfo(String name);
    public Lesson searchLessonInfo(String name);
    public Teacher searchTeacherInfo(String name);
    public Users searchUsersInfo(String name);
    public Order searchOrderInfo(String name);
    public Give searchGiveInfo(String name);

}
