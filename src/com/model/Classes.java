package com.model;

import java.sql.Connection;

/**
 * Created by secret on 16-1-14.
 */
public class Classes {

    private String classesId;
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
    }
}
