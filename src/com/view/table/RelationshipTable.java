package com.view.table;

import com.model.Book;
import com.model.Relationship;
import com.view.addition.AddBookInfo;
import com.view.jframe.Framewindows;
import com.view.modify.ModifyBookInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelationshipTable extends JFrame implements ActionListener{

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JTable jTable;
    private JTextField jTextField;
    private JPanel jPanel;

    Book book;

    public RelationshipTable(){
        jButton1 = new JButton("增加");
        jButton1.addActionListener(this);
        jButton2 = new JButton("删除");
        jButton2.addActionListener(this);
        jButton3 = new JButton("修改");
        jButton3.addActionListener(this);
        jButton4 = new JButton("查询");
        jButton4.addActionListener(this);
        jTextField = new JTextField(20);
        jPanel = new JPanel();
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jTextField);
        jPanel.add(jButton4);

        book = new Book();
        String paras[] = {"1"};
        book.searchBook("USE DB_Design;SELECT * FROM Book WHERE 1=?",paras);
        jTable = new JTable(book);
        Framewindows framewindows = new Framewindows(jTable,jPanel);
    }

    public static void main(String[] args){
        Relationship relationship = new Relationship();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButton1){   //增加
            Book book = new Book();
            AddBookInfo addBookInfo = new AddBookInfo(this,"增加教材数据", true,book,book.getRowCount());
            //重建窗口
            String paras[] = {"1"};
            book.searchBook("USE DB_Design;SELECT * FROM Book WHERE 1=?",paras);
            JTable jTable = new JTable(book);
            Framewindows framewindows = new Framewindows(jTable,jPanel);
        }
        else if (e.getSource()==jButton2){  //删除
            int rowNum=this.jTable.getSelectedRow();
            if(rowNum==-1){
                JOptionPane.showMessageDialog(this,"选择一行");
                return;
            }
            String BookId = (String)book.getValueAt(rowNum,0);
            String sql = "USE DB_Design;DELETE FROM Book WHERE Bno=?";
            String[] paras ={BookId};
            Book book1= new Book();
            book1.searchBook(sql,paras);
            //更新数据库
            book = new Book();
            String[] paras1={"1"};
            book.searchBook("USE DB_Design;SELECT * FROM Book WHERE 1=?",paras1);
            //更新表
            jTable.setModel(book);
        }else if(e.getSource()==jButton3){  //修改
            Book book = new Book();
            ModifyBookInfo modifyBookInfo = new ModifyBookInfo(this,"修改数据",true,book,book.getRowCount());
            //重建窗口
            String paras[] = {"1"};
            book.searchBook("USE DB_Design;SELECT * FROM Book WHERE 1=?",paras);
            JTable jTable = new JTable(book);
            Framewindows framewindows = new Framewindows(jTable,jPanel);
        }
    }
}
