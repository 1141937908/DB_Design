package com.view;

import com.dao.DBRevisable;
import com.dao.Daodbc;
import com.dao.Revisable;
import com.model.Book;
import com.model.Lesson;
import com.model.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by llc_1 on 2016/1/17.
 */
public class AddLessonInfo extends JFrame{
    public AddLessonInfo(){
        addLessonInfoGUI();
    }

    private void addLessonInfoGUI(){
        /*常用组件实例化*/
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jPanel7 = new JPanel();
        jPanel8 = new JPanel();
        jButton1 = new JButton("提交");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==jButton1){
                    Daodbc dbc = new Daodbc();
                    try{
                        dbc.getCon();
                        Lesson lesson = new Lesson();
                        lesson.setLessonId(jTextField1.getText());
                        lesson.setLessonName(jTextField2.getText());
                        Revisable revisable = new DBRevisable(dbc.getConnection());
                        revisable.addLessonInfo(lesson);
                    }catch (SQLException e1){
                        e1.printStackTrace();
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }finally {
                        dbc.getClose(dbc.getConnection(),null,null);
                        System.exit(0);
                    }
                }
            }
        });
        jButton2 = new JButton("退出");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==jButton2){
                    System.exit(0);
                }
            }
        });
        jTextField1 = new JTextField(20);
        jTextField2 = new JTextField(20);
        jTextField3 = new JTextField(20);
        jTextField3 = new JTextField(20);
        jTextField4 = new JTextField(20);
        jTextField5 = new JTextField(20);
        jLabel1 = new JLabel("课程号");
        jLabel2 = new JLabel("课程名");
//        jLabel3 = new JLabel("出  版  社");
//        jLabel4 = new JLabel("作       者");
//        jLabel5 = new JLabel("价       格");
//        JLabel6 = new JLabel("库 存 量");

//        jPanel1.setLayout(new GridLayout(1,2));
//        jPanel2.setLayout(new GridLayout(1,2));
//        jPanel3.setLayout(new GridLayout(1,2));
//        jPanel4.setLayout(new GridLayout(1,2));
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField2);
//        jPanel3.add(jLabel3);
//        jPanel3.add(jTextField3);
//        jPanel4.add(jLabel4);
//        jPanel4.add(jTextField4);
//        jPanel5.add(jLabel5);
//        jPanel5.add(jTextField5);
//        jPanel6.add(jButton1);
//        jPanel6.add(jButton2);
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);
        this.add(jPanel4);
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
//        this.add(jPanel4);
//        this.add(jPanel5);
//        this.add(jPanel6);

        /*窗体基本设置*/
        this.setLayout(new GridLayout(4,1));
        this.setTitle("");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(300,200);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args){
        AddLessonInfo addLessonInfo = new AddLessonInfo();
    }

    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;

}
