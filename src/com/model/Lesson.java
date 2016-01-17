package com.model;

/**
 * Created by secret on 16-1-14.
 */
public class Lesson {

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



}
