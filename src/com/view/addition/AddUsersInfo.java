package com.view.addition;


import com.model.Book;
import com.model.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by llc_1 on 2016/1/17.
 */
public class AddUsersInfo extends JDialog implements ActionListener{
    /**
     * 常用组件定义
     */
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JPasswordField jPasswordField;

    public AddUsersInfo(Frame owner, String title, boolean modal, Users users,int rowNums){
        super(owner,title,modal);
        addUsersInfoGUI();
    }

    private void addUsersInfoGUI(){
        /*常用组件实例化*/
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        /*监听按钮*/
        jButton1 = new JButton("提交");
        jButton1.addActionListener(this);   //监听1
        jButton2 = new JButton("退出");
        jButton2.addActionListener(this);   //监听2

        jLabel1 = new JLabel("账号");
        jTextField1 = new JTextField(20);
        jLabel2 = new JLabel("密码");
        jPasswordField = new JPasswordField(20);
        jLabel3 = new JLabel("姓名");
        jTextField2 = new JTextField(20);

        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jPasswordField);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField2);
        jPanel4.add(jButton1);
        jPanel4.add(jButton2);

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);

        /*窗体基本设置*/
        this.setLayout(new GridLayout(5,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(300,200);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         /*如果监听到“提交”按钮*/
        if (e.getSource()==jButton1){
            Users users = new Users();
            String sql = "USE DB_Design;INSERT INTO Users VALUES(?,?,?)";
            String paras[]={jTextField1.getText(),jPasswordField.getPassword().toString(), jTextField2.getText()};
            try {
                if (!users.addUsers(sql,paras)){
                    JOptionPane.showConfirmDialog(this, "添加失败！");
                    return;
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            //关闭对话框
            this.dispose();
        }
        /*如果监听到“取消”按钮*/
        else if (e.getSource()==jButton2){
            try{
                this.dispose();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
