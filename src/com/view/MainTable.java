/*
package com.view;

*/
/**
 * Created by llc_1 on 2016/1/15.
 *//*


import com.dao.*;
import com.model.Classes;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.beans.VetoableChangeListener;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class MainTable extends JFrame{

    private CardLayout cardLayout;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel_left;
    private JPanel jPanel_right;
    private JPanel cardJPanel;

    private JSplitPane jSplitPane;

    private JList jList;

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton12;

    private JMenuBar jMenuBar;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenu jMenu5;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;

    private JTable jTable1;
    private JTable jTable2;
    private JTable jTable3;
    private JTable jTable4;
    private JTable jTable5;
    private JTable jTable6;
    private JTable jTable7;
    private JTable jTable8;

    private JScrollPane jScrollPane;
    private Vector rowData;
    private Vector rowData1;
    private Vector rowData2;
    private Vector rowData3;
    private Vector rowData4;
    private Vector rowData5;
    private Vector rowData6;
    private Vector rowData7;
    private Vector rowData8;
    private Vector columnNames;
    private Vector columnNames1;
    private Vector columnNames2;
    private Vector columnNames3;
    private Vector columnNames4;
    private Vector columnNames5;
    private Vector columnNames6;
    private Vector columnNames7;
    private Vector columnNames8;
    private Vector hang;
    private Vector hang1;
    private Vector hang2;
    private Vector hang3;
    private Vector hang4;
    private Vector hang5;
    private Vector hang6;
    private Vector hang7;
    private Vector hang8;

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection conn;
    public MainTable(){
        init();
    }

    private void init(){

        */
/*上方菜单栏*//*

        jMenuBar = new JMenuBar();
        jMenu1 = new JMenu("用户管理模块");
        jMenu2 = new JMenu("教材征订模块");
        jMenu3 = new JMenu("综合管理模块");
        jMenu4 = new JMenu("教材发放模块");
        jMenu5 = new JMenu("关于");
        jMenuItem1 = new JMenuItem("用户信息添加");
        jMenuItem2 = new JMenuItem("用户信息修改");
        jMenuItem3 = new JMenuItem("用户信息删除");
        jMenuItem4 = new JMenuItem("退出");
        jMenuItem5 = new JMenuItem("教材录入");
        jMenuItem6 = new JMenuItem("教材查询");
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem3);
        jMenu1.add(jMenuItem4);
        jMenu2.add(jMenuItem5);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);
        jMenuBar.add(jMenu4);
        jMenuBar.add(jMenu5);

        */
/*下方整体框架实例化*//*

        jPanel_left = new JPanel(new GridLayout(8,1));
        jPanel_right = new JPanel(new BorderLayout());
        cardLayout = new CardLayout();
        cardJPanel = new JPanel(cardLayout);

        */
/*预先设置的JLablel*//*

        JLabel jLabel1 = new JLabel("第一张");
        JLabel jLabel2 = new JLabel("第二张");
        JLabel jLabel3 = new JLabel("第三张");
        JLabel jLabel4 = new JLabel("第四张");
        JLabel jLabel5 = new JLabel("第五张");
        JLabel jLabel6 = new JLabel("第六张");
        JLabel jLabel7 = new JLabel("第七张");
        JLabel jLabel8 = new JLabel("第八张");
        JLabel jLabel9 = new JLabel("第九张");
        JLabel jLabel10 = new JLabel("第十张");

        */
/*卡片布局*//*

        */
/*基本通用操作*//*

        */
/*数据库操作*//*

        Daodbc dbc = new Daodbc();
        Revisable dbr = new DBRevisable(dbc.getConnection());
        Connection connection = dbc.getConnection();

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        */
/*班级信息卡片*//*

        rowData1 = new Vector();
        columnNames1 = new Vector();
        hang1 = new Vector();


        columnNames1.add("班级号");
        columnNames1.add("班级名");
        columnNames1.add("人数");

        //TODO 数据库连接
        try {
            dbc.connection(sql);
            rowData1=dbr.searchClassesInfo("*");
        }catch (Exception e){
            e.printStackTrace();
        }


        jPanel3 = new JPanel();
        */
/*教师信息卡片*//*

        rowData2 = new Vector();
        columnNames2 = new Vector();
        hang2 = new Vector();

        columnNames2.add("教师号");
        columnNames2.add("姓名");
        columnNames2.add("性别");

        //TODO 数据库连接


        jPanel4 = new JPanel();
        */
/*课程信息卡片*//*

        rowData3 = new Vector();
        columnNames3 = new Vector();
        hang3 = new Vector();

        columnNames3.add("课程号");
        columnNames3.add("课程名");

        //TODO 数据库连接

        jPanel5 = new JPanel();
        */
/*教材信息卡片*//*

        rowData4 = new Vector();
        columnNames4 = new Vector();
        hang4 = new Vector();

        columnNames4.add("教材编号");
        columnNames4.add("教材名称");
        columnNames4.add("出版社");
        columnNames4.add("作者");
        columnNames4.add("价格");
        columnNames4.add("库存量");

        //TODO 数据库连接

        jPanel6 = new JPanel();
        */
/*征订信息*//*

        rowData5 = new Vector();
        columnNames5 = new Vector();
        hang5 = new Vector();

        columnNames5.add("班级号");
        columnNames5.add("教师号");
        columnNames5.add("课程号");
        columnNames5.add("教材号");
        columnNames5.add("订购数量");


        //TODO 数据库连接

        jPanel7 = new JPanel();
        */
/*发放信息卡片*//*

        rowData6 = new Vector();
        columnNames6 = new Vector();
        hang6 = new Vector();

        columnNames6.add("班级号");
        columnNames6.add("教师号");
        columnNames6.add("课程号");
        columnNames6.add("教材号");
        columnNames6.add("发放情况");
        columnNames6.add("发放日期");

        //TODO 数据库连接

        jPanel8 = new JPanel();
        */
/*关系库信息*//*

        rowData7 = new Vector();
        columnNames7 = new Vector();
        hang7 = new Vector();

        columnNames7.add("班级号");
        columnNames7.add("教师号");
        columnNames7.add("课程号");
        columnNames7.add("教材号");

        //TODO 数据库连接

        */
/*预处理文本框*//*

        jPanel1.add(jTable1);
        jPanel2.add(jLabel2);
        jPanel3.add(jLabel3);
        jPanel4.add(jLabel4);
        jPanel5.add(jLabel5);
        jPanel6.add(jLabel6);
        jPanel7.add(jLabel7);
        jPanel8.add(jLabel8);

        */
/*将8个面板带进card中*//*

        cardJPanel.add(jPanel1,"jp1");
        cardJPanel.add(jPanel2,"jp2");
        cardJPanel.add(jPanel3,"jp3");
        cardJPanel.add(jPanel4,"jp4");
        cardJPanel.add(jPanel5,"jp5");
        cardJPanel.add(jPanel6,"jp6");
        cardJPanel.add(jPanel7,"jp7");
        cardJPanel.add(jPanel8,"jp8");
        */
/*右下窗格*//*

        jPanel9 = new JPanel(new GridLayout(3,1));
        jPanel10 = new JPanel(new GridLayout(3,1));
        jPanel11 = new JPanel(new GridLayout(3,1));
        jPanel12 = new JPanel(new GridLayout(3,1));
        jPanel13 = new JPanel();
        jButton9 = new JButton("添加");
        jButton10 = new JButton("删除");
        jButton11 = new JButton("修改");
        jButton12 = new JButton("查询");

        jPanel9.add(jButton9);
        jPanel10.add(jButton10);
        jPanel11.add(jButton11);
        jPanel12.add(jButton12);

        jPanel13.add(jPanel9);
        jPanel13.add(jPanel10);
        jPanel13.add(jPanel11);
        jPanel13.add(jPanel12);

        */
/*组合窗格*//*

        jPanel_right.add(cardJPanel,"Center");
        jPanel_right.add(jPanel13,"South");

        */
/*左侧菜单栏*//*

        jButton1 = new JButton("用户信息");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardJPanel,"jp1");
            }
        });
        jButton2 = new JButton("班级信息");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardJPanel,"jp2");
            }
        });
        jButton3 = new JButton("教师信息");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardJPanel,"jp3");
            }
        });
        jButton4 = new JButton("课程信息");
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardJPanel,"jp4");
            }
        });
        jButton5 = new JButton("教材信息");
        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardJPanel,"jp5");
            }
        });
        jButton6 = new JButton("征订信息");
        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardJPanel,"jp6");
            }
        });
        jButton7 = new JButton("发放信息");
        jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardJPanel,"jp7");
            }
        });
        jButton8 = new JButton("关系表");
        jButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardJPanel,"jp8");
            }
        });
        jPanel_left.add(jButton1);
        jPanel_left.add(jButton2);
        jPanel_left.add(jButton3);
        jPanel_left.add(jButton4);
        jPanel_left.add(jButton5);
        jPanel_left.add(jButton6);
        jPanel_left.add(jButton7);
        jPanel_left.add(jButton8);

        */
/*拆分窗格*//*

//        jSplitPane = new JSplitPane();  //分隔栏
        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jPanel_left,jPanel_right);
        jSplitPane.setDividerLocation(1.0 / 3.0);
        jSplitPane.setEnabled(false);

        */
/*整体框架*//*

        this.add(jMenuBar,"North");
        this.add(jSplitPane,"Center");
        this.jSplitPane.setDividerLocation(2.0 /10.0);  //jSplitPane比例分割

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);


        */
/*右上侧窗格*//*

//        rowData = new Vector();
//        columnNames = new Vector();
//        Vector hang = new Vector();
//
//        columnNames.add("姓名");
//        columnNames.add("性别");
//        columnNames.add("年龄");
//        columnNames.add("籍贯");
//        columnNames.add("系别");
//        columnNames.add("备注");
//
//        Daodbc dbc = new Daodbc();
//        try{
//            dbc.getCon();
//            sql="SELECT * FROM stu";
//            conn = dbc.getConnection();
//            preparedStatement=conn.prepareStatement(sql);
//            resultSet =preparedStatement.executeQuery();
//            while (resultSet.next()){
//                hang.add(resultSet.getString(1));
//                hang.add(resultSet.getString(2));
//                hang.add(resultSet.getString(3));
//                hang.add(resultSet.getString(4));
//                hang.add(resultSet.getString(5));
//                hang.add(resultSet.getString(6));
//                rowData.add(hang);
//            }
//            jTable = new JTable(rowData,columnNames);
//            jScrollPane = new JScrollPane(jTable);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if (resultSet != null) resultSet.close();
//                if (preparedStatement != null) preparedStatement.close();
//                if (conn != null) conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }

    public static void main(String[] args){
        MainTable mainTable= new MainTable();
    }
}
*/
