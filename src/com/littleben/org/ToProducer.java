package com.littleben.org;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ToProducer extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToProducer frame = new ToProducer();
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
	public ToProducer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(12, 34, 435, 274);
		contentPane.add(scrollPane);
		
		JTextArea txtrMessage = new JTextArea();
		txtrMessage.setText("\uC0AC\uB791\uD574\uC694 \uAC1C\uBC1C\uC790\uB2D8 \r\nMessage Area");
		txtrMessage.setLineWrap(true);
		scrollPane.setViewportView(txtrMessage);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://10.80.162.99/user", "admin", "1234");
                    
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from user");
                    ResultSet resultSet = preparedStatement.executeQuery();

                    String Name=txtname.getText();//field
                    String Message=txtrMessage.getText();//area
                    
                    connection.prepareStatement("insert into message values(" + "'" + Message + "'"+","+"'"+Name+"'"+")").execute();
                   

                } catch (ClassNotFoundException | SQLException p) {
                    p.printStackTrace();
                }	
			}
		});
		btnNewButton.setBounds(12, 315, 215, 23);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrMessage.setText("");
			}
		});
		btnClear.setBounds(239, 315, 208, 23);
		contentPane.add(btnClear);
		
		txtname = new JTextField();
		txtname.setText("\uC774\uB984/NAME");
		txtname.setBounds(12, 3, 435, 21);
		contentPane.add(txtname);
		txtname.setColumns(10);
	}

}
