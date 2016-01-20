package com.view.table;

import com.dao.Daodbc;
import com.model.Book;
import com.model.Lesson;
import com.model.Teacher;
import com.view.addition.AddBookInfo;
import com.view.addition.AddTeacherInfo;
import com.view.modify.ModifyBookInfo;
import com.view.modify.ModifyTeacherInfo;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TeacherTable extends JFrame implements ActionListener {

	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JTable jTable1, jTable2;
	private JTextField jTextField;
	private JPanel jPanel1, jPanel2;
	private JMenuBar jMenuBar;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenuItem jMenuItem1_1;
	private JMenuItem jMenuItem1_2;
	private JMenuItem jMenuItem1_3;
	private JMenuItem jMenuItem1_4;
	private JMenuItem jMenuItem1_5;
	private JMenuItem jMenuItem1_6;
	private JMenuItem jMenuItem1_7;
	private JMenuItem jMenuItem1_8;
	private JMenuItem jMenuItem1_9;
	// private JMenuItem jMenuItem2_1;
	// private JMenuItem jMenuItem2_2;

	Daodbc dbc;
	Teacher teacher;

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TeacherTable TeacherTable = new TeacherTable();
	}

	public TeacherTable() {
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
		// jMenuItem2_1 = new JMenuItem("多表连接查询");
		// jMenuItem2_1.addActionListener(this);
		// jMenuItem2_2 = new JMenuItem("导入sql文件");
		// jMenuItem2_2.addActionListener(this);
		jMenu1.add(jMenuItem1_1);
		jMenu1.add(jMenuItem1_2);
		jMenu1.add(jMenuItem1_3);
		jMenu1.add(jMenuItem1_4);
		jMenu1.add(jMenuItem1_5);
		jMenu1.add(jMenuItem1_6);
		jMenu1.add(jMenuItem1_7);
		jMenu1.add(jMenuItem1_8);
		jMenu1.add(jMenuItem1_9);
		// jMenu2.add(jMenuItem2_1);
		// jMenu2.add(jMenuItem2_2);
		jMenuBar.add(jMenu1);
		// jMenuBar.add(jMenu2);
		/* 下方选项 */
		jButton1 = new JButton("增加");
		jButton1.addActionListener(this);
		jButton2 = new JButton("删除");
		jButton2.addActionListener(this);
		jButton3 = new JButton("修改");
		jButton3.addActionListener(this);
		jButton4 = new JButton("查询");
		jButton4.addActionListener(this);
		jButton5 = new JButton("刷新");
		jButton5.addActionListener(this);
		jTextField = new JTextField(20);
		jPanel1 = new JPanel();
		jPanel1.add(jButton1);
		jPanel1.add(jButton2);
		jPanel1.add(jButton3);
		jPanel1.add(jButton4);
		jPanel1.add(jTextField);
		jPanel1.add(jButton5);

		teacher = new Teacher();
		String[] paras = { "1" };
		teacher.queryTeacher("USE DB_Design;SELECT * FROM Teacher WHERE 1=?", paras);
		jTable2 = new JTable(teacher);
		JScrollPane jScrollPane = new JScrollPane(jTable2);

		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel1, BorderLayout.SOUTH);
		this.add(jMenuBar, BorderLayout.NORTH);
		this.setTitle("教师");
		this.setSize(1000, 550);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jMenuItem1_1) {
			UsersTable usersTable = new UsersTable();
			this.dispose();
		} else if (e.getSource() == jMenuItem1_2) {
			ClassesTable classesTable = new ClassesTable();
			this.dispose();
		} else if (e.getSource() == jMenuItem1_3) {
			TeacherTable teacherTable = new TeacherTable();
			this.dispose();
		} else if (e.getSource() == jMenuItem1_4) {
			LessonTable lessonTable = new LessonTable();
			this.dispose();
		} else if (e.getSource() == jMenuItem1_5) {
			BookTable bookTable = new BookTable();
			this.dispose();
		} else if (e.getSource() == jMenuItem1_6) {
			SubscriptionTable subscriptionTable = new SubscriptionTable();
			this.dispose();
		} else if (e.getSource() == jMenuItem1_7) {
			GiveTable giveTable = new GiveTable();
			this.dispose();
		} else if (e.getSource() == jMenuItem1_8) {
			RelationshipTable relationshipTable = new RelationshipTable();
			this.dispose();
		} else if (e.getSource() == jMenuItem1_9) {
			this.dispose();
		} /*
			 * else if (e.getSource() == jMenuItem2_1) {
			 * 
			 * } else if (e.getSource() == jMenuItem2_2) { Daodbc dbc = new
			 * Daodbc(); try { dbc.DaoSQL("src/DateBaseSQL.sql"); } catch
			 * (SQLException e1) { e1.printStackTrace(); } }
			 */
		/* 新增 */
		else if (e.getSource() == jButton1) {
			AddTeacherInfo addTeacherInfo = new AddTeacherInfo(this, "add", true);

			teacher = new Teacher();
			String sql = "USE DB_Design;SELECT * FROM Teacher WHERE 1=?";
			String[] paras = { "1" };
			try {
				teacher.queryTeacher(sql, paras);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jTable2.setModel(teacher);
		}
		/* 删除 */
		else if (e.getSource() == jButton2) {
			int rowIndex = this.jTable2.getSelectedRow();
			if (rowIndex == -1) {
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			String TeacherId = (String) teacher.getValueAt(rowIndex, 0);
			System.out.println(TeacherId);
			String sql = "USE DB_Design;DELETE FROM Teacher WHERE Bno=?";
			String[] paras = { TeacherId };
			Teacher teacher = new Teacher();
			try {
				teacher.updateTeacher(sql, paras);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			teacher = new Teacher();
			sql = "USE DB_Design;SELECT * FROM Teacher WHERE 1=?";
			String[] paras2 = { "1" };
			try {
				teacher.queryTeacher(sql, paras2);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jTable2.setModel(teacher);

		}
		/* 修改 */
		else if (e.getSource() == jButton3) {
			int rowIndex = this.jTable2.getSelectedRow();
			if (rowIndex == -1) {
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}

			ModifyTeacherInfo modifyTeacherInfo = new ModifyTeacherInfo(this, "modify", true, teacher, rowIndex);

			Teacher teacher1 = new Teacher();
			String sql = "USE DB_Design;SELECT * FROM Teacher WHERE 1=?";
			String[] paras2 = { "1" };
			try {
				teacher1.queryTeacher(sql, paras2);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jTable2.setModel(teacher1);

		}
		/* 查询 */
		else if (e.getSource() == jButton4) {
			String Tno = this.jTextField.getText().trim();
			String sql = "USE DB_Design;SELECT * FROM Teacher WHERE Tno=?";
			String[] paras = { Tno };
			teacher = new Teacher();
			try {
				teacher.queryTeacher(sql, paras);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jTable2.setModel(teacher);
		}
		/* 刷新 */
		else if (e.getSource() == jButton5) {
			String sql = "USE DB_Design;SELECT * FROM Teacher WHERE 1=?";
			String[] paras = { "1" };
			Teacher teacher = new Teacher();
			try {
				teacher.queryTeacher(sql, paras);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jTable2.setModel(teacher);
		}
	}
}