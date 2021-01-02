package com.qst.dms.ui;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

import com.qst.dms.entity.User;
import com.qst.dms.service.UserService;
import com.qst.dms.utils.MD5Utils;

// 登录窗口
@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	// 主面板
	private JPanel contentPane;
	// 用户名文本框
	private JTextField txtName;
	// 密码文本框
	private JPasswordField txtPwd;
	// 登录按钮
	JButton btnLogin = new JButton("登录");
	// 重置按钮
	JButton btnReset = new JButton("重置");
	// 注册按钮
	JButton btnRegist = new JButton("注册");

	// 注册的用户
	private static User user;
	// 用户业务类
	private UserService userService;
	
	// 构造方法
	public LoginFrame() {
		
		// 实例化用户业务类对象
		userService = new UserService();
		setVisible(true);
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 50, 436, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(159, 10, 200, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblUserName = new JLabel("          用户名");
		lblUserName.setBounds(33, -1, 155, 46);
		panel.add(lblUserName);
		lblUserName.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 106, 436, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPassWord = new JLabel("          密  码");
		lblPassWord.setFont(new Font("宋体", Font.PLAIN, 14));
		lblPassWord.setLabelFor(lblUserName);
		lblPassWord.setBounds(34, 0, 163, 46);
		panel_1.add(lblPassWord);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(159, 12, 204, 24);
		panel_1.add(txtPwd);
		
		// 登录按钮
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mpassword;
				// 获取用户输入的数据
				String userName = txtName.getText().trim();
				String password = new String(txtPwd.getPassword());
				user = userService.findUserByName(userName);
				if (user != null) {
					//转换成加密后的密码与数据库比对
					mpassword = MD5Utils.str2MD5(password);
					if (mpassword.equals(user.getPassword())) {
						// 输出提示信息
						JOptionPane.showMessageDialog(null,"登录成功！","登录成功",JOptionPane.PLAIN_MESSAGE);
						new MainFrame();
					} else {
						// 输出提示信息
						JOptionPane.showMessageDialog(null,"密码错误，请重新输入！","登录失败",JOptionPane.PLAIN_MESSAGE);
						// 清空密码
						txtPwd.setText("");
						// 重置单选按钮为未选择
						btnLogin.setSelected(false);
						btnReset.setSelected(false);
					}
				} else {
					// 输出提示信息
					JOptionPane.showMessageDialog(null,"用户名不存在！","登录失败",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		// 重置按钮
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 清空用户名和密码
				txtName.setText("");
				txtPwd.setText("");
				// 重置单选按钮为未选择
				btnLogin.setSelected(false);
				btnReset.setSelected(false);
			}
		});
		
		// 注册按钮
		btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistFrame();
			}
		});
		

		btnLogin.setFont(new Font("宋体", Font.PLAIN, 15));
		btnLogin.setBounds(113, 197, 97, 23);
		contentPane.add(btnLogin);
		btnReset.setFont(new Font("宋体", Font.PLAIN, 15));
		btnReset.setBounds(220, 197, 97, 23);
		contentPane.add(btnReset);
		btnRegist.setFont(new Font("宋体", Font.PLAIN, 15));
		btnRegist.setBounds(327, 197, 97, 23);
		contentPane.add(btnRegist);
		
		JButton button = new JButton("注销");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteFrame();
			}
		});
		button.setBounds(10, 197, 93, 23);
		contentPane.add(button);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
