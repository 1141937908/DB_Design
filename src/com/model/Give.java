package com.model;

import java.util.Date;

/**
 * Created by llc_1 on 2016/1/16.
 */
public class Give {
    private String Cno;
    private String Tno;
    private String Lno;
    private String Bno;
    private boolean giveState;
    private String giveDatatime;

    public Give(){
        super();
    }

    public Give(String Cno,String Tno,String Lno,String Bno,boolean giveState, String giveDatatime){
        this.Cno = Cno;
        this.Tno = Tno;
        this.Lno = Lno;
        this.Bno = Bno;
        this.giveState = giveState;
        this.giveDatatime = giveDatatime;
    }

    public String getCno() {
        return Cno;
    }

    public String getTno() {
        return Tno;
    }

    public String getLno() {
        return Lno;
    }

    public String getBno() {
        return Bno;
    }

    public String getGiveDatatime() {
        return giveDatatime;
    }

    public boolean getGiveState() {
        return giveState;
    }
    public void setCno(String cno) {
        Cno = cno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public void setLno(String lno) {
        Lno = lno;
    }

    public void setBno(String bno) {
        Bno = bno;
    }

    public void setGiveState(boolean giveState) {
        this.giveState = giveState;
    }

    public void setGiveDatatime(String giveDatatime) {
        this.giveDatatime = giveDatatime;
    }
}
