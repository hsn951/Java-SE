package com.qst.dms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qst.dms.service.LogRecService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class DeleteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFrame frame = new DeleteFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteFrame() {
		setTitle("注销界面");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel p = new JPanel();
		contentPane.add(p);
		p.setLayout(null);
		
		JLabel label = new JLabel("注销");
		label.setBounds(194, 5, 36, 21);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		p.add(label);
		
		JLabel label_1 = new JLabel("用户名 ：");
		label_1.setBounds(34, 70, 54, 26);
		p.add(label_1);
		
		JLabel label_2 = new JLabel("    密码 ：");
		label_2.setBounds(24, 139, 66, 15);
		p.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(120, 73, 106, 21);
		p.add(textField);
		textField.setColumns(10);
		
		JPasswordField txtpwd = new JPasswordField();
		txtpwd.setBounds(120, 136, 110, 21);
		p.add(txtpwd);
		
		JButton button = new JButton("确认注销");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LogRecService logrecservice =new LogRecService();
					String userName = textField.getText().trim();
					String password = new String(txtpwd.getPassword());
				logrecservice.DeleteUser(userName,password);
				JOptionPane.showMessageDialog(null, "用户注销成功！", "提示",
						JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception e) {
						e.printStackTrace();
					}
			}
		});
		button.setBounds(120, 203, 93, 23);
		p.add(button);
		
		JButton btn_ReturnLogin = new JButton("返回登录");
		btn_ReturnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				new LoginFrame();
			}
		});
		btn_ReturnLogin.setBounds(237, 203, 93, 23);
		p.add(btn_ReturnLogin);
	}
}
