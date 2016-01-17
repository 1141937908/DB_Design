package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class test4 extends JFrame {

    public test4(){
        init();
    }

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

    private JTable jTable;
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

    private void init(){
        this.setSize(1000,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);


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

        /*下方整体框架实例化*/
        jPanel_left = new JPanel(new GridLayout(8,1));
        jPanel_right = new JPanel(new BorderLayout());

        cardLayout = new CardLayout();
        cardJPanel = new JPanel(cardLayout);
        /*预先设置的JLablel*/
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

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jPanel7 = new JPanel();
        jPanel8 = new JPanel();

        jPanel1.add(jLabel1);
        jPanel2.add(jLabel2);
        jPanel3.add(jLabel3);
        jPanel4.add(jLabel4);
        jPanel5.add(jLabel5);
        jPanel6.add(jLabel6);
        jPanel7.add(jLabel7);
        jPanel8.add(jLabel8);

        cardJPanel.add(jPanel1,"j1");
        cardJPanel.add(jPanel2,"j2");
        cardJPanel.add(jPanel3,"j3");
        cardJPanel.add(jPanel4,"j4");
        cardJPanel.add(jPanel5,"j5");
        cardJPanel.add(jPanel6,"j6");
        cardJPanel.add(jPanel7,"j7");
        cardJPanel.add(jPanel8,"j8");

        /*右下部分*/
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

        /*组合窗格*/
        jPanel_right.add(cardJPanel,"Center");
        jPanel_right.add(jPanel13,"South");

        /*左侧菜单栏*/
        jButton1 = new JButton("用户信息");
        jButton2 = new JButton("班级信息");
        jButton3 = new JButton("教师信息");
        jButton4 = new JButton("课程信息");
        jButton5 = new JButton("教材信息");
        jButton6 = new JButton("征订信息");
        jButton7 = new JButton("发放信息");
        jButton8 = new JButton("关系表");
        jPanel_left.add(jButton1);
        jPanel_left.add(jButton2);
        jPanel_left.add(jButton3);
        jPanel_left.add(jButton4);
        jPanel_left.add(jButton5);
        jPanel_left.add(jButton6);
        jPanel_left.add(jButton7);
        jPanel_left.add(jButton8);

        /*分隔栏*/
        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jPanel_left,jLabel1);
        jSplitPane.setDividerLocation(1.0 / 3.0);
        jSplitPane.setEnabled(false);

        this.add(jMenuBar,"North");
        this.add(jSplitPane,"Center");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);

    }

    public static void main(String[] args){
        test4 test4= new test4();
    }
}