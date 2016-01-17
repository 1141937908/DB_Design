package com.view;

import com.dao.DBRevisable;
import com.dao.Daodbc;
import com.dao.Revisable;
import com.model.Give;
import com.model.Order;
import com.model.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by llc_1 on 2016/1/17.
 */
public class AddOrderInfo extends JFrame{
    public AddOrderInfo(){
        addOrderInfoGUI();
    }

    private void addOrderInfoGUI(){
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
                        Order order = new Order();
                        order.setCno(jComboBox1.getSelectedItem().toString());
                        order.setBno(jComboBox2.getSelectedItem().toString());
                        order.setLno(jComboBox3.getSelectedItem().toString());
                        order.setBno(jComboBox4.getSelectedItem().toString());
                        order.setOrderNumber(Integer.parseInt(jTextField1.getText()));
                        Revisable revisable = new DBRevisable(dbc.getConnection());
                        revisable.addOrderInfo(order);
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
        passwordField = new JPasswordField(20);
        jLabel1 = new JLabel("班 级 号");
        jLabel2 = new JLabel("教 师 号");
        jLabel3 = new JLabel("课 程 号");
        jLabel4 = new JLabel("教 材 号");
        jLabel5 = new JLabel("订购数量");
        jComboBox1 = new JComboBox();
        jComboBox2 = new JComboBox();
        jComboBox3 = new JComboBox();
        jComboBox4 = new JComboBox();
        /*连接数据库查找相关信息*/
        Daodbc dbc = new Daodbc();
        try {
            dbc.getCon();

        } catch (Exception e) {
            e.printStackTrace();
        }

//        jComboBox5 = new JComboBox();

//        JLabel6 = new JLabel("库 存 量");
//        jPanel1.setLayout(new GridLayout(1,2));
//        jPanel2.setLayout(new GridLayout(1,2));
//        jPanel3.setLayout(new GridLayout(1,2));
//        jPanel4.setLayout(new GridLayout(1,2));
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(passwordField);
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
        AddUsersInfo addUsersInfo = new AddUsersInfo();
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
    private JPasswordField passwordField;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JComboBox jComboBox3;
    private JComboBox jComboBox4;
    private JComboBox jComboBox5;
}
