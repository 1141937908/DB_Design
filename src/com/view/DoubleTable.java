package com.view;

import com.dao.Daodbc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractSequentialList;

/**
 * Created by llc_1 on 2016/1/18.
 */
public class DoubleTable extends JDialog implements ActionListener{
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
//    private JLabel jLabel1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JButton jButton;

    public DoubleTable(){
        jLabel1= new JLabel("班级号");
        jLabel2= new JLabel("教师号");
        jLabel3= new JLabel("课程号");
        jLabel4= new JLabel("ISBN编号");
//        jLabel5= new JLabel("班级号");
//        jLabel1= new JLabel("班级号");
//        jLabel1= new JLabel("班级号");
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField2);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField3);
        jPanel4.add(jLabel4);
        jPanel4.add(jTextField4);
        jPanel5.add(jPanel1);
        jPanel5.add(jPanel2);
        jPanel5.add(jPanel3);
        jPanel5.add(jPanel4);
        jButton = new JButton("查找");
        jButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButton){
            String sql = "USE DB_Design;SELETC * FROME Classes,Teacher,Lesson,Book,Subscription,Give,Relation ";
        }
    }
}
