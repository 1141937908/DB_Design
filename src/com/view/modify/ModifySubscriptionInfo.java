package com.view.modify;

import com.dao.Daodbc;
import com.model.Give;
import com.model.Subscription;
import com.view.table.SubscriptionTable;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by llc_1 on 2016/1/18.
 */
public class ModifySubscriptionInfo extends JDialog implements ActionListener {
	/**
	 * 常用组件定义
	 */
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private JPanel jPanel5;
	private JPanel jPanel6;
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField jTextField1;
	private JTextField jTextField5;
	private JComboBox<String> jComboBox1;
	private JComboBox<String> jComboBox2;
	private JComboBox<String> jComboBox3;
	private JComboBox<String> jComboBox4;

	public ModifySubscriptionInfo(Frame owner, String title, boolean modal, Subscription subscription, int rowNums) {
		super(owner, title, modal);

		/* 常用组件实例化 */
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jPanel3 = new JPanel();
		jPanel4 = new JPanel();
		jPanel5 = new JPanel();
		jPanel6 = new JPanel();

		jButton1 = new JButton("提交");
		jButton1.addActionListener(this); // 监听1
		jButton2 = new JButton("退出");
		jButton2.addActionListener(this); // 监听2

//		jTextField1 = new JTextField(20);
//		jTextField1.setText((String) subscription.getValueAt(rowNums, 0));
//		jTextField1.setEditable(false);
//		jTextField2 = new JTextField(20);
//		jTextField2.setText((String) subscription.getValueAt(rowNums, 1));
//		jTextField2.setEditable(false);
//		jTextField3 = new JTextField(20);
//		jTextField3.setText((String) subscription.getValueAt(rowNums, 2));
//		jTextField3.setEditable(false);
//		jTextField4 = new JTextField(20);
//		jTextField4.setText((String) subscription.getValueAt(rowNums, 3));
//		jTextField4.setEditable(false);
		jTextField5 = new JTextField(30);
		jTextField5.setText((String) subscription.getValueAt(rowNums, 4));

		jLabel1 = new JLabel("班 级 号");
		jLabel2 = new JLabel("教 师 号");
		jLabel3 = new JLabel("课 程 号");
		jLabel4 = new JLabel("教 材 号");
		jLabel5 = new JLabel("订购数量");

		/* 连接数据库查找相关信息 */
		Daodbc dbc = new Daodbc();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Connection connection = dbc.getConnection();

		String sql1 = "SELECT Cno FROM Classes";
		String sql2 = "SELECT Tno FROM Teacher";
		String sql3 = "SELECT Lno FROM Lesson";
		String sql4 = "SELECT Bno FROM Book";

		Vector<String> vector1 = new Vector<String>();
		Vector<String> vector2 = new Vector<String>();
		Vector<String> vector3 = new Vector<String>();
		Vector<String> vector4 = new Vector<String>();

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
				vector3.add(resultSet.getString("Lno"));
			}

			preparedStatement = connection.prepareStatement(sql4);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vector4.add(resultSet.getString("Bno"));
			}

			jComboBox1 = new JComboBox<String>(vector1);
			jComboBox2 = new JComboBox<String>(vector2);
			jComboBox3 = new JComboBox<String>(vector3);
			jComboBox4 = new JComboBox<String>(vector4);
			jComboBox1.setPreferredSize(new Dimension(250,20));
			jComboBox2.setPreferredSize(new Dimension(250,20));
			jComboBox3.setPreferredSize(new Dimension(250,20));
			jComboBox4.setPreferredSize(new Dimension(250,20));
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
		jPanel6.add(jButton1);
		jPanel6.add(jButton2);

		this.add(jPanel1);
		this.add(jPanel2);
		this.add(jPanel3);
		this.add(jPanel4);
		this.add(jPanel5);
		this.add(jPanel6);
		// this.add(jPanel6);

		/* 窗体基本设置 */
		this.setLayout(new GridLayout(6, 1));
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/* 如果监听到了jButton1按钮 */
		if (e.getSource() == jButton1) {
			String sql1 = "USE DB_Design;UPDATE Subscription SET Onum=? WHERE Cno=? AND Tno=? AND Lno=? AND Bno=?";
//			String sql2 = "USE DB_Design;UPDATE Give Gs=0 SET Cno=? AND Tno=? AND Lno=? AND Bno=?";
			String[] paras1 =  new String[]{ jTextField1.getText().toString(), (String) jComboBox1.getSelectedItem(),
					(String)jComboBox2.getSelectedItem(), (String)jComboBox3.getSelectedItem(),
					(String)jComboBox4.getSelectedItem() };
		
			//String[] paras2 = { (String)jComboBox1.getSelectedItem(), (String)jComboBox2.getSelectedItem(),
			//		(String)jComboBox3.getSelectedItem(), (String)jComboBox4.getSelectedItem() };
			Subscription subscription = new Subscription();
			Give give = new Give();
			try {
				subscription.updateSubscription(sql1, paras1);
			//	give.updateGive(sql2, paras2);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			this.dispose();
		} else if (e.getSource() == jButton2) {
			try {
				this.dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
