package com.model;

/**
 * Created by secret on 16-1-14.
 */
public class Teacher {

    private String teaId;
    private String teaName;
    private String teaSex;

    public Teacher(){
        super();
    }

    public Teacher(String teaId , String teaName , String teaSex){
        super();
        this.teaId =teaId;
        this.teaName = teaName;
        this.teaSex = teaSex;
    }

    public String getTeaId(){
        return teaId;
    }

    public String getTeaName(){
        return teaName;
    }

    public String getTeaSex(){
        return teaSex;
    }

    public void setTeaId(){
        this.teaId = teaId;
    }

    public void setTeaName(){
        this.teaName = teaName;
    }

    public void setTeaSex(){
        this.teaSex = teaSex;
    }


}
