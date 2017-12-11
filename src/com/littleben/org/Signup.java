package com.littleben.org;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Signup extends JFrame {

	 private Connection connection; //연결 유지 객체
	    private PreparedStatement preparedStatement; // 문장 연결 객체
	    private ResultSet resultSet;// 결과 값 담는 객체

	
	private JPanel contentPane;
	private JTextField IDField;
	private JPasswordField PWField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IDField = new JTextField();
		IDField.setBounds(63, 26, 116, 21);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		JLabel label = new JLabel("\uC544\uC774\uB514");
		label.setBounds(12, 29, 57, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_1.setBounds(12, 60, 57, 15);
		contentPane.add(label_1);
		
		PWField = new JPasswordField();
		PWField.setBounds(63, 57, 116, 21);
		contentPane.add(PWField);
		
		JButton button = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
                     Class.forName("com.mysql.jdbc.Driver");
                     connection = DriverManager.getConnection("jdbc:mysql://10.80.162.99/user", "admin", "1234");
                     preparedStatement = connection.prepareStatement("SELECT * from user");
                     resultSet = preparedStatement.executeQuery();
                     
                     Set<String> user=new HashSet<String>();
                     user.add(IDField.getText());
                     user.add(PWField.getText());
                     
                     String id=IDField.getText();
                     String pw=PWField.getText();
                     while (resultSet.next()) {
                         if (resultSet.getString(1).equals(id)) {
                        	 JOptionPane.showMessageDialog(Signup.this, "ID가 이미 존재합니다", "Error", JOptionPane.ERROR_MESSAGE);
                        	 return;
                         }
                         if(pw.length()<4) {
                        	 JOptionPane.showMessageDialog(Signup.this, "비밀번호는 4자 이상이어야 합니다", "Error", JOptionPane.ERROR_MESSAGE);
                        	 return;
                         }
                     }
                     JOptionPane.showMessageDialog(Signup.this, "가입 성공!", "Success", JOptionPane.ERROR_MESSAGE);
                     connection.prepareStatement("insert into user values(" + "'" + id + "'"+","+"'"+pw+"'"+","+"'"+0+"'"+")").execute();

                 } catch (ClassNotFoundException | SQLException e) {
                     e.printStackTrace();
                 }

			}
		});
		button.setBounds(191, 25, 87, 50);
		contentPane.add(button);
		
	}

}
