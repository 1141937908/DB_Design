package com.view;

import com.model.Users;
import com.view.table.BookTable;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    /**
     * 常用组件定义
     */
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton jButton1;
    private JButton jButton2;
    private JTextField jTextField;
    private JPasswordField jPasswordField;
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection conn=null;
    private Statement statement;
    private ResultSet resultSet;
    public Login() throws Exception {
        logInGUI();
    }
    public static void main (String[] args) throws Exception{
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible",false);
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch(Exception e){
            e.printStackTrace();
        }
        Login login = new Login();

    }

    private void logInGUI() throws Exception{

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jLabel1 = new JLabel("用户名");
        jLabel2 = new JLabel("密 码");
        jButton1 = new JButton("登 陆");
        jButton1.addActionListener(this);
        jButton2 = new JButton("取 消");
        jButton2.addActionListener(this);
        jTextField = new JTextField(20);
        jTextField.addActionListener(this);
        jPasswordField = new JPasswordField(20);
        jPasswordField.addActionListener(this);

        jPanel2.setSize(5,2);
        jPanel3.setSize(5,2);
        jPanel2.add(jLabel1);
        jPanel2.add(jTextField);
        jPanel3.add(jLabel2);
        jPanel3.add(jPasswordField);
        jPanel4.add(jButton1);
        jPanel4.add(jButton2);

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);

        this.setLayout(new GridLayout(4,1));
        this.setTitle("");
        this.setResizable(false);
        this.setSize(400,300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButton2){
            this.dispose();
        }else if (e.getSource()==jButton1){
            Users users = new Users();
            String loginuser=this.jTextField.getText().toString();
            String loginpasswd = new String(this.jPasswordField.getPassword());
            try {
                if(users.checkUsers(loginuser,loginpasswd)) {
                    BookTable bookTable = new BookTable();
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"Password Failed");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
