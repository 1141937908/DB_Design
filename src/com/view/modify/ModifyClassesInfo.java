package com.view.modify;

import com.model.Classes;
import com.view.table.ClassesTable;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by llc_1 on 2016/1/18.
 */
public class ModifyClassesInfo extends JDialog implements ActionListener{
    /**
     * 基本控件定义
     */
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;

    public ModifyClassesInfo(ClassesTable classesTable, String title, boolean modal, Classes classes, int rowNums){
        super(classesTable,title,modal);
  
        /*常用组件实例化*/
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();

        jButton1 = new JButton("提交");
        jButton1.addActionListener(this);   //监听1
        jButton2 = new JButton("取消");
        jButton2.addActionListener(this);   //监听2

        jTextField1 = new JTextField(20);
		jTextField1.setText((String) classes.getValueAt(rowNums, 0));
		jTextField1.setEditable(false);
		jTextField2 = new JTextField(20);
		jTextField2.setText((String) classes.getValueAt(rowNums, 1));
		jTextField3 = new JTextField(20);
		jTextField3.setText((String) classes.getValueAt(rowNums, 2));

        jLabel1 = new JLabel("班级号");
        jLabel2 = new JLabel("班级名");
        jLabel3 = new JLabel("人   数");

        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField2);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField3);
        jPanel4.add(jButton1);
        jPanel4.add(jButton2);

        this.add(jPanel5);
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
        /*如果监听到了jButton1按钮*/
        if(e.getSource()==jButton1){
            String sql = "USE DB_Design;UPDATE Classes SET Cname=?,Cnum=? WHERE Cno=?";
            String[] paras={jTextField2.getText(),jTextField3.getText(),jTextField1.getText()};
            Classes classes = new Classes();
            try {
                classes.updateClasses(sql,paras);
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
