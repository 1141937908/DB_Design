package com.view;

import com.dao.Daodbc;
import com.model.Give;
import com.model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringJoiner;
import java.util.Vector;

/**
 * Created by llc_1 on 2016/1/18.
 */
public class ModifyGiveInfo  extends JDialog implements ActionListener{
    /**
     * 常用组件定义
     */
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
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
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JComboBox jComboBox3;
    private JComboBox jComboBox4;

    public ModifyGiveInfo(Frame owner, String title, boolean modal, Give give, int rowNums) {
        super(owner, title, modal);
        addOrderInfoGUI();
        jComboBox1.setSelectedItem(give.getValueAt(rowNums,0));
        jComboBox1.setEditable(false);
        jComboBox2.setSelectedItem(give.getValueAt(rowNums,1));
        jComboBox2.setEditable(false);
        jComboBox3.setSelectedIndex(Integer.toString(give.getValueAt(rowNums,2)));
        jComboBox3.setEditable(false);
        jComboBox4.setSelectedItem(give.getValueAt(rowNums,3));
        jComboBox4.setEditable(false);
        jTextField1.setText((String)give.getValueAt(rowNums,4));
    }

    private void addOrderInfoGUI() {
//    private JComboBox jComboBox;
        /*常用组件实例化*/
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();

        jButton1 = new JButton("提交");
        jButton1.addActionListener(this);   //监听1
        jButton2 = new JButton("退出");
        jButton2.addActionListener(this);   //监听2

        jTextField1 = new JTextField(20);
        jTextField2 = new JTextField(20);
        jTextField3 = new JTextField(20);
        jTextField3 = new JTextField(20);
        jTextField4 = new JTextField(20);
        jTextField5 = new JTextField(20);
        jLabel1 = new JLabel("班 级 号");
        jLabel2 = new JLabel("教 师 号");
        jLabel3 = new JLabel("课 程 号");
        jLabel4 = new JLabel("教 材 号");
        jLabel5 = new JLabel("发放情况");
        jLabel6 = new JLabel("发放日期");

        /*连接数据库查找相关信息*/
        Daodbc dbc = new Daodbc();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection connection = dbc.getConnection();

        String sql1 = "SELECT Cno FROM Classes";
        String sql2 = "SELECT Tno FROM Teacher";
        String sql3 = "SELECT Lno FROM Lesson";
        String sql4 = "SELECT Bno FROM Book";

        Vector vector1 = new Vector();
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        Vector vector4 = new Vector();

        try {
            preparedStatement = connection.prepareStatement(sql1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vector1.add(resultSet.getString("Cno"));
            }

            preparedStatement = connection.prepareStatement(sql2);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vector2.add(resultSet.getString("Tno"));
            }

            preparedStatement = connection.prepareStatement(sql3);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vector3.add(resultSet.getString("Bno"));
            }

            preparedStatement = connection.prepareStatement(sql4);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vector4.add(resultSet.getString("Bno"));
            }

            jComboBox1 = new JComboBox(vector1);
            jComboBox2 = new JComboBox(vector2);
            jComboBox3 = new JComboBox(vector3);
            jComboBox4 = new JComboBox(vector4);
            // jComboBox1.setSize();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }

        jPanel1.add(jLabel1);
        jPanel1.add(jComboBox1);
        jPanel2.add(jLabel2);
        jPanel2.add(jComboBox2);
        jPanel3.add(jLabel3);
        jPanel3.add(jComboBox3);
        jPanel4.add(jLabel4);
        jPanel4.add(jComboBox4);
        jPanel5.add(jLabel5);
        jPanel5.add(jTextField5);
        jPanel6.add(jLabel6);
        jPanel6.add(jTextField6);
        jPanel7.add(jButton1);
        jPanel7.add(jButton2);

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);
        this.add(jPanel5);
        this.add(jPanel6);
        this.add(jPanel7);

        /*窗体基本设置*/
        this.setLayout(new GridLayout(7, 1));
        this.setTitle("");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(300, 200);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            /*如果监听到了jButton1按钮*/
        if(e.getSource()==jButton1){
            String sql = "USE DB_Design;UPDATE Order SET Gs=?,Gdata=? WHERE Cno=? AND Tno=? AND Lno=? AND Bno=?";
            String[] paras={jTextField1.getText(),jTextField2.getText(),jComboBox1.getSelectedItem().toString(),jComboBox2.getSelectedItem().toString(),jComboBox3.getSelectedItem().toString(),jComboBox4.getSelectedItem().toString()};
            Give give = new Give();
            try {
                give.addGive(sql,paras);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            this.dispose();
        }
        else if (e.getSource()==jButton2){
            try{
                this.dispose();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
