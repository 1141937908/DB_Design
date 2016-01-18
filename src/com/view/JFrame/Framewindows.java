package com.view.jframe;

import com.dao.Daodbc;
import com.model.Book;
import com.model.Classes;
import com.model.Lesson;
import com.model.Teacher;
import com.view.table.*;
import org.apache.tools.ant.taskdefs.SQLExec;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by llc_1 on 2016/1/18.
 */
public class Framewindows extends JFrame implements ActionListener{

    /**
     * 常用组件定义
     */
    private JPanel jPanel;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JTextField jTextField;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JMenuBar jMenuBar;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenuItem jMenuItem1_1;
    private JMenuItem jMenuItem1_2;
    private JMenuItem jMenuItem1_3;
    private JMenuItem jMenuItem1_4;
    private JMenuItem jMenuItem1_5;
    private JMenuItem jMenuItem1_6;
    private JMenuItem jMenuItem1_7;
    private JMenuItem jMenuItem1_8;
    private JMenuItem jMenuItem1_9;
    private JMenuItem jMenuItem2_1;
    private JMenuItem jMenuItem2_2;

    public Framewindows(JTable jTable,JPanel jPanel){
        /*菜单栏*/
        jMenuBar = new JMenuBar();
        jMenu1 = new JMenu("数据表");
        jMenu2 = new JMenu("编辑");
        jMenuItem1_1 = new JMenuItem("用户表");
        jMenuItem1_1.addActionListener(this);
        jMenuItem1_2 = new JMenuItem("班级表");
        jMenuItem1_2.addActionListener(this);
        jMenuItem1_3 = new JMenuItem("教师表");
        jMenuItem1_3.addActionListener(this);
        jMenuItem1_4 = new JMenuItem("课程表");
        jMenuItem1_4.addActionListener(this);
        jMenuItem1_5 = new JMenuItem("教材表");
        jMenuItem1_5.addActionListener(this);
        jMenuItem1_6 = new JMenuItem("征订表");
        jMenuItem1_6.addActionListener(this);
        jMenuItem1_7 = new JMenuItem("发放表");
        jMenuItem1_7.addActionListener(this);
        jMenuItem1_8 = new JMenuItem("关系表");
        jMenuItem1_8.addActionListener(this);
        jMenuItem1_9 = new JMenuItem("退出");
        jMenuItem1_9.addActionListener(this);
        jMenuItem2_1 = new JMenuItem("多表连接查询");
        jMenuItem2_1.addActionListener(this);
        jMenuItem2_2 = new JMenuItem("导入sql文件");
        jMenuItem2_2.addActionListener(this);
        jMenu1.add(jMenuItem1_1);
        jMenu1.add(jMenuItem1_2);
        jMenu1.add(jMenuItem1_3);
        jMenu1.add(jMenuItem1_4);
        jMenu1.add(jMenuItem1_5);
        jMenu1.add(jMenuItem1_6);
        jMenu1.add(jMenuItem1_7);
        jMenu1.add(jMenuItem1_8);
        jMenu1.add(jMenuItem1_9);
        jMenu2.add(jMenuItem2_1);
        jMenu2.add(jMenuItem2_2);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);

        jScrollPane = new JScrollPane(jTable);

        this.add(jMenuBar,"North");
        this.add(jScrollPane,"Center");
        this.add(jPanel,"South");
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(650,500);
        this.setTitle("教材征订与收发管理系统");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jMenuItem1_1){
            UsersTable usersTable = new UsersTable();
            this.dispose();
        }
        else if (e.getSource()==jMenuItem1_2){
            ClassesTable classesTable = new ClassesTable();
            this.dispose();
        }else if (e.getSource()==jMenuItem1_3){
            TeacherTable teacherTable = new TeacherTable();
            this.dispose();
        }else if (e.getSource()==jMenuItem1_4){
            Lesson lesson = new Lesson();
            this.dispose();
        }else if (e.getSource()==jMenuItem1_5){
            Book book = new Book();
            this.dispose();
        }else if (e.getSource()==jMenuItem1_6){
            SubscriptionTable subscriptionTable = new SubscriptionTable();
            this.dispose();
        }else if (e.getSource()==jMenuItem1_7){
            GiveTable giveTable = new GiveTable();
            this.dispose();
        }else if (e.getSource()==jMenuItem1_8){
            RelationshipTable relationshipTable = new RelationshipTable();
            this.dispose();
        }else if (e.getSource()==jMenuItem1_9){
            this.dispose();
        }else if (e.getSource()==jMenuItem2_1){

        }else if (e.getSource()==jMenuItem2_2){
            Daodbc dbc = new Daodbc();
            try {
                dbc.DaoSQL("src/DateBaseSQL.sql");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
