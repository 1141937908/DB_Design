package com.model;

/**
 * Created by llc_1 on 2016/1/16.
 */
public class Order {
    private String Cno;
    private String  Tno;
    private String  Lno;
    private String Bno;
    private int orderNumber;

    public Order(){
        super();
    }

    public Order(String Cno,String Tno,String Lno,String Bno,int orderNumber){
        super();
        this.Cno = Cno;
        this.Tno = Tno;
        this.Lno = Lno;
        this.Bno = Bno;
        this.orderNumber = orderNumber;
    }

    public String getCno(){
        return Cno;
    }

    public String getTno(){
        return Tno;
    }

    public String getLno(){
        return Lno;
    }

    public String getBno(){
        return Bno;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    public void setCno(String Cno){
        this.Cno = Cno;
    }

    public void setTno(String Tno){
        this.Tno = Tno;
    }

    public void setLno(String Lno){
        this.Lno = Lno;
    }

    public void setBno(String Bno){
        this.Bno = Bno;
    }

    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }
}
