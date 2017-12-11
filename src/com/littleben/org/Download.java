package com.littleben.org;

import java.awt.Component;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Download extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblRepo;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Download frame = new Download();
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
	public Download() {
		setBounds(100, 100, 629, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(81, 22, 395, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblRepo = new JLabel("REPO key");
		lblRepo.setBounds(12, 25, 57, 15);
		contentPane.add(lblRepo);
		
		JButton btnE = new JButton("\uB2E4\uC6B4\uB85C\uB4DC");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String repokey=textField.getText();
				try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://10.80.162.99/user", "admin", "1234");
                    
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from upload");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    
                   while(resultSet.next()) {
                	   if (resultSet.getString(2).equals(repokey)) {
                       	String code=resultSet.getString(1);
                       	textArea.setText(code);
                       	return;
                       }
                   }
                    if(textArea.getText().isEmpty()) {
                       	JOptionPane.showMessageDialog(Download.this, "그런 코드가 없습니다", "Error", JOptionPane.ERROR_MESSAGE);
                       	return;
                       }

                } catch (ClassNotFoundException | SQLException p) {
                    p.printStackTrace();
                }
			}
		});
		btnE.setBounds(488, 21, 97, 23);
		contentPane.add(btnE);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(12, 53, 589, 346);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setText("//\uB2E4\uC6B4\uB85C\uB4DC\uC2DC \uC5EC\uAE30\uC5D0 \uBCF5\uC0AC\uB429\uB2C8\uB2E4.");
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
	}
}
