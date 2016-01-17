package com.view;

import com.dao.DBRevisable;
import com.dao.Daodbc;
import com.dao.Revisable;
import com.model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by llc_1 on 2016/1/17.
 */
public class AddTeacherInfo extends JFrame implements ActionListener{

    public AddTeacherInfo(){
        addTeacherInfoGUI();
    }

    private void addTeacherInfoGUI(){
        /*常用组件实例化*/
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jPanel7 = new JPanel();
        jPanel8 = new JPanel();
        jComboBox = new JComboBox();
        jButton1 = new JButton("提交");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==jButton1){
                    Daodbc dbc = new Daodbc();
                    try{

                        dbc.getCon();
                        Revisable revisable = new DBRevisable(dbc.getConnection());
                        Teacher teacher = new Teacher();
                        teacher.setTeaId(jTextField1.getText().toString());
                        teacher.setTeaName(jTextField2.getText());
                        teacher.setTeaSex(jComboBox.getSelectedItem().toString());
                        revisable.addTeacherInfo(teacher);
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
        jLabel1 = new JLabel("教师号");
        jLabel2 = new JLabel("姓   名");
        jLabel3 = new JLabel("性   别");
        jComboBox.addItem("男");
        jComboBox.addItem("女");


//        jPanel1.setLayout(new GridLayout(1,2));
//        jPanel2.setLayout(new GridLayout(1,2));
//        jPanel3.setLayout(new GridLayout(1,2));
//        jPanel4.setLayout(new GridLayout(1,2));
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField2);
        jPanel3.add(jLabel3);
        jPanel3.add(jComboBox);
        jPanel4.add(jButton1);
        jPanel4.add(jButton2);

        this.add(jPanel5);
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);

        /*窗体基本设置*/
        this.setLayout(new GridLayout(5,1));
        this.setTitle("");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(300,200);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args){
        AddTeacherInfo addTeacherInfo = new AddTeacherInfo();
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
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JComboBox jComboBox;

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
