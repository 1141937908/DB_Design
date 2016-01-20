package com.view.modify;

import com.model.Lesson;
import com.view.table.LessonTable;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by llc_1 on 2016/1/18.
 */
public class ModifyLessonInfo extends JDialog implements ActionListener{
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

    public ModifyLessonInfo(LessonTable lessonTable, String title, boolean modal, Lesson lesson, int rowNums){
        super(lessonTable,title,modal);
 
        /*常用组件实例化*/
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();

        jButton1 = new JButton("修改");
        jButton1.addActionListener(this);   //监听1
        jButton2 = new JButton("退出");
        jButton2.addActionListener(this);   //监听2

        jTextField1 = new JTextField(20);
		jTextField1.setText((String) lesson.getValueAt(rowNums, 0));
		jTextField1.setEditable(false);
		jTextField2 = new JTextField(20);
		jTextField2.setText((String) lesson.getValueAt(rowNums, 1));

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
        /*如果监听到了jButton1按钮*/
        if(e.getSource()==jButton1){
            String sql = "USE DB_Design;UPDATE Lesson SET Lname=? WHERE Tno=?";
            String[] paras={jTextField2.getText(),jTextField1.getText()};
            Lesson lesson = new Lesson();
            try {
                lesson.updateLesson(sql,paras);
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
