package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.Home;
import student.databaseconnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class adminpanel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpanel frame = new adminpanel();
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
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs =  null;
	private JPasswordField passwordField;
	
	public adminpanel() {
		
		super("Login");
		conn = databaseconnect.connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setUndecorated(true);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin ID");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setBounds(152, 178, 118, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Pass");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(152, 264, 134, 21);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(353, 173, 212, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAdminPanel = new JLabel("ADMIN PANEL");
		lblAdminPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblAdminPanel.setBounds(235, 78, 190, 26);
		contentPane.add(lblAdminPanel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					String adminid = textField.getText();
					String adminpass = passwordField.getText();
					
					String sql = "Select * from adminpanel where adminid  = '"+adminid+"' && adminpass = '"+adminpass+"'";
					
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						setVisible(false);
						adminreg object = new adminreg();
						object.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"Enter the correct admin details");
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Database error");
				}
				
				}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.setBounds(265, 359, 128, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setBounds(583, 6, 61, 35);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(353, 250, 212, 35);
		contentPane.add(passwordField);
	}
}
