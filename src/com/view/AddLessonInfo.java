package com.view;

import com.dao.DBRevisable;
import com.dao.Daodbc;
import com.dao.Revisable;
import com.model.Book;
import com.model.Classes;
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
public class AddLessonInfo extends JDialog implements ActionListener{

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

    private JTextField jTextField1;
    private JTextField jTextField2;

    public AddLessonInfo(Frame woner,String title,boolean modal,Lesson lesson,int rowNums){
        super(woner,title,modal);
        addLessonInfoGUI();
    }

    private void addLessonInfoGUI(){
        /*常用组件实例化*/
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();

        jButton1 = new JButton("提交");
        jButton1.addActionListener(this);   //监听1
        jButton2 = new JButton("退出");
        jButton2.addActionListener(this);   //监听2

        jTextField1 = new JTextField(20);
        jTextField2 = new JTextField(20);
        jLabel1 = new JLabel("课程号");
        jLabel2 = new JLabel("课程名");

        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField2);
        jPanel3.add(jButton1);
        jPanel3.add(jButton2);

        this.add(jPanel4);
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);

        /*窗体基本设置*/
        this.setLayout(new GridLayout(4,1));
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
            Lesson lesson = new Lesson();
            String sql = "USE DB_Design;INSERT INTO Lesson VALUES(?,?)";
            String paras[]={jTextField1.getText(),jTextField2.getText()};
            try {
                if (lesson.addLesson(sql,paras)){
                    JOptionPane.showConfirmDialog(this,"添加失败！");
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
