package com.littleben.org;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Upload extends JFrame {

	private JPanel contentPane;
	private JTextField IDField;
	private JPasswordField passwordField;
	private JTextField REPOField;
	
	private static String code;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Upload frame = new Upload();
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
	public Upload(String code) {
		this.code = code;
	}
	
	private Upload() {
		setBounds(100, 100, 302, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IDField = new JTextField();
		IDField.setBounds(52, 26, 116, 21);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(52, 56, 116, 21);
		contentPane.add(passwordField);
		
		REPOField = new JTextField();
		REPOField.setBounds(52, 87, 116, 21);
		contentPane.add(REPOField);
		REPOField.setColumns(10);
		
		JLabel IDLabel = new JLabel("ID");
		IDLabel.setBounds(12, 29, 57, 15);
		contentPane.add(IDLabel);
		
		JLabel PWLabel = new JLabel("PW");
		PWLabel.setBounds(12, 57, 57, 15);
		contentPane.add(PWLabel);
		
		JLabel NameLabel = new JLabel("REPO");
		NameLabel.setBounds(12, 90, 57, 15);
		contentPane.add(NameLabel);
		
		JButton btnUpload = new JButton("\uC5C5\uB85C\uB4DC");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=IDField.getText();
				String PW=passwordField.getText();
				String REPO=REPOField.getText();
				boolean id=false,pw=false;
				try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://10.80.162.99/user", "admin", "1234");
                    
                    
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from user");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        id=resultSet.getString(1).equals(ID);
                        pw=resultSet.getString(2).equals(PW);
                        if(id&&pw) {
                        	break;
                        }
                    }
                    
                    preparedStatement = connection.prepareStatement("SELECT * from upload");
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                		if(resultSet.getString(2).equals(REPO)) {
                			JOptionPane.showMessageDialog(Upload.this, "해당 REPO 키는 이미 존재합니다", "Error", JOptionPane.ERROR_MESSAGE);
                			return;
                		}
                	}
                    
                    preparedStatement = connection.prepareStatement("SELECT * from upload");
                    resultSet = preparedStatement.executeQuery();
                    
                    if (id&&pw) {
                    	connection.prepareStatement("insert into upload values(" + "'" + code + "'"+","+"'"+REPO+"'"+")").execute();
                    	JOptionPane.showMessageDialog(Upload.this, "업로드 성공!\n REPO Key : "+REPO+"", "Success", JOptionPane.ERROR_MESSAGE);
                    	return;
                    }else {
                    	JOptionPane.showMessageDialog(Upload.this, "Failed to Login!!!", "Error", JOptionPane.ERROR_MESSAGE);
                    	return;
                    }
                    

                } catch (ClassNotFoundException | SQLException p) {
                    p.printStackTrace();
                }	
				
			}
		});
		btnUpload.setBounds(180, 25, 94, 50);
		contentPane.add(btnUpload);
		
		JButton btnRegister = new JButton("\uAC00\uC785\uD558\uAE30");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signup().main(new String[] {""});
			}
		});
		btnRegister.setBounds(180, 86, 94, 23);
		contentPane.add(btnRegister);
	}
}
