package com.view.addition;

//import com.dao.DBRevisable;
import com.model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by llc_1 on 2016/1/17.
 */
public class AddBookInfo extends JDialog implements ActionListener{

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

    public AddBookInfo(Frame owner , String title , boolean modal,Book book,int rowNums){

        super(owner,title,modal);   //调用父类构造方法
        addBookInfoGUI();
    }

    private void addBookInfoGUI(){
        /*常用组件实例化*/
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jPanel7 = new JPanel();

        jButton1 = new JButton("提交");
        jButton1.addActionListener(this);   //监听1
        jButton2 = new JButton("取消");
        jButton2.addActionListener(this);   //监听2

        jTextField1 = new JTextField(20);
        jTextField2 = new JTextField(20);
        jTextField3 = new JTextField(20);
        jTextField4 = new JTextField(20);
        jTextField5 = new JTextField(20);
        jTextField6 = new JTextField(20);
        jLabel1 = new JLabel("ISBN编号");
        jLabel2 = new JLabel("教材名称");
        jLabel3 = new JLabel("出  版  社");
        jLabel4 = new JLabel("作       者");
        jLabel5 = new JLabel("价       格");
        jLabel6 = new JLabel("库  存  量");

        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField2);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField3);
        jPanel4.add(jLabel4);
        jPanel4.add(jTextField4);
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
        this.setLayout(new GridLayout(6,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(300,300);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*如果监听到“提交”按钮*/
        if (e.getSource()==jButton1){
            Book book = new Book();
            String sql = "USE DB_Design;INSERT INTO Book VALUES(?,?,?,?,?,?)";
            String paras[]={jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),jTextField6.getText()};
            try {
                if (!book.addBook(sql,paras)){
                    JOptionPane.showConfirmDialog(this, "添加失败！");
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
