package com.dao;

/**
 * Created by llc_1 on 2016/1/16.
 */

import com.model.*;


public class DaoFactory {

    public static Book getBookInstance(){
        return new Book();
    }

    public static Classes getClassesInstance(){
        return new Classes();
    }

    public static Give getGiveInstance(){
        return new Give();
    }

    public static Lesson getLessonInstance(){
        return new Lesson();
    }

    public static Order getOrderInstance(){
        return new Order();
    }

    public static Teacher getTeacherInstance(){
        return new Teacher();
    }

    public static Users getUsersInstance(){
        return new Users();
    }
}
