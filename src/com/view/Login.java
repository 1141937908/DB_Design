package com.view;

import com.dao.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    /**
     * 基本组件定义
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
        Login login = new Login();

    }

    private void logInGUI() throws Exception{

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jLabel1 = new JLabel("用户名");
        jLabel2 = new JLabel("密    码");
        jButton1 = new JButton("登录");
        jButton1.addActionListener(this);
        jButton2 = new JButton("退出");
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
        this.setLocationRelativeTo(null);
        this.setSize(320,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    class CustomActionListener extends Component implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(jTextField.getText().equals("")&&jPasswordField.getPassword().equals(""))
                JOptionPane.showMessageDialog(this,"输入不能为空");
            else if(actionEvent.getSource() == jButton1){
                //判断触发源是否为提交按钮
                //连接数据库
                Daodbc dbc = new Daodbc();
                try {
                    dbc.getConnection();
                    conn = dbc.getConnection();
                    statement = conn.createStatement();

                    sql = "SELECT * FROM stu WHERE stuId=? AND stuName=?";
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, jTextField.getText());
                    preparedStatement.setString(2, String.valueOf(jPasswordField.getPassword()));
                    resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        jLabel1.setText("yes");
                    }
                    else {
                        jLabel1.setText("no");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                    try {
                        dbc.close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }

            if (actionEvent.getSource() == jButton2){

            }
        }
    }
}
