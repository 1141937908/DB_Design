package com.view.addition;

import com.model.Teacher;
import com.view.table.TeacherTable;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by llc_1 on 2016/1/17.
 */
public class AddTeacherInfo extends JDialog implements ActionListener {

	/**
	 * 常用组件定义
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
	private JComboBox jComboBox;
	/*
	 * public static void main(String[] args){ AddTeacherInfo addTeacherInfo=new
	 * AddTeacherInfo(null, "添加教师信息", false, null, 100); }
	 */

	/**
	 * 构造函数 其中，owner是它的父窗口，title是它的窗口名，modal是指定的模式窗口
	 * 
	 * @param teacherTable
	 * @param title
	 * @param teacher
	 * @param rowNums
	 */
	public AddTeacherInfo(Frame owner, String title, boolean modal) {
		/* 调用父类的构造函数 */
		super(owner, title, modal);
		addTeacherInfoGUI();
	}

	private void addTeacherInfoGUI() {
		/* 常用组件实例化 */
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jPanel3 = new JPanel();
		jPanel4 = new JPanel();
		jPanel5 = new JPanel();

		jComboBox = new JComboBox();

		jButton1 = new JButton("提交");
		jButton1.addActionListener(this); // 监听1
		jButton2 = new JButton("退出");
		jButton2.addActionListener(this); // 监听2

		jLabel1 = new JLabel("教师号");
		jTextField1 = new JTextField(20);
		jTextField1.addActionListener(this);
		jLabel2 = new JLabel("姓   名");
		jTextField2 = new JTextField(20);
		jTextField2.addActionListener(this);
		jLabel3 = new JLabel("性   别");
		jComboBox.addItem("男");
		jComboBox.addItem("女");

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

		/* 窗体基本设置 */
		this.setLayout(new GridLayout(5, 1));
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(300, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * 监听函数 作用：监听并处理数据
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {

		/* 如果监听到“提交”按钮 */
		if (e.getSource() == jButton1) {
			Teacher teacher = new Teacher();
			String sql = "USE DB_Design;INSERT INTO Teacher VALUES(?,?,?)";
			String paras[] = { jTextField1.getText(), jTextField2.getText(), jComboBox.getSelectedItem().toString() };
			try {
				if (!teacher.updateTeacher(sql, paras)) {
					JOptionPane.showMessageDialog(this, "添加失败！");
					return;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			// 关闭对话框
			this.dispose();
		}
		/* 如果监听到“取消”按钮 */
		else if (e.getSource() == jButton2) {
			try {
				this.dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
