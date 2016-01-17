package com.model;

/**
 * Created by secret on 16-1-14.
 */
public class Users {

    private String id;
    private String password;
    private String userName;

    public Users(){
        super();
    }

    public Users(String id , String password){
        super();
        this.id = id;
        this.password = password;
    }

    public Users(String id , String password , String userName){
        super();
        this.id = id;
        this.password = password;
        this.userName = userName;
    }

    public String  getId(){
        return id;
    }

    public String  getPassword(){
        return password;
    }

    public String  getUserName(){
        return userName;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
}
