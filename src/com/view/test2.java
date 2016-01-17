package com.view;

/**
 * Created by llc_1 on 2016/1/16.
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class test2 extends JFrame{

    public test2(){
        init();
    }

    private void init(){
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jMenuBar = new JMenuBar();
        jMenu1 = new JMenu("用户管理模块");
        jMenu2 = new JMenu("教材征订模块");
        jMenu3 = new JMenu("综合管理模块");
        jMenu4 = new JMenu("教材发放模块");
        jMenu5 = new JMenu("关于");
        jMenuItem1 = new JMenuItem("用户信息添加");
        jMenuItem2 = new JMenuItem("用户信息修改");
        jMenuItem3 = new JMenuItem("用户信息删除");
        jMenuItem4 = new JMenuItem("退出");
        jMenuItem5 = new JMenuItem("教材录入");
        jMenuItem6 = new JMenuItem("教材查询");
        /*jMenuItem7 = new JMenuItem("教材修改");
        jMenuItem8 = new JMenuItem("教材删除")；
        jMenuItem9 = new JMenuItem("教师添加");
        jMenuItem10 = new JMenuItem("教师删除");
        jMenuItem11 = new JMenuItem("教师修改");
        jMenuItem12 = new JMenuItem("班级添加");
        jMenuItem13 = new JMenuItem("班级删除");
        jMenuItem14 = new JMenuItem("班级修改");*/

        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem3);
        jMenu1.add(jMenuItem4);
        jMenu2.add(jMenuItem5);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);
        jMenuBar.add(jMenu4);
        jMenuBar.add(jMenu5);

        this.setTitle("教材征订与发放管理系统");
        this.add(jMenuBar,"North");
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args){
        test2 test = new test2();
    }

    private JPanel jPanel1;
    private JPanel jPanel2;
    private JMenuBar jMenuBar;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenu jMenu5;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;


}
