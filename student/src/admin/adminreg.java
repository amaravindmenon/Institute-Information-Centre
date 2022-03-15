package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.Login;
import student.databaseconnect;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class adminreg extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminreg frame = new adminreg();
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
	private JTextField textField_name;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	public adminreg() {
		
		super("adminreg");
		conn = databaseconnect.connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,50, 800,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setUndecorated(true);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(733, 6, 61, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblAddUserAdmin = new JLabel("ADD USER ADMIN");
		lblAddUserAdmin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAddUserAdmin.setBounds(64, 42, 214, 27);
		contentPane.add(lblAddUserAdmin);
		
		JLabel lblUserid = new JLabel("Userid");
		lblUserid.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblUserid.setBounds(48, 112, 61, 16);
		contentPane.add(lblUserid);
		
		textField_id = new JTextField();
		textField_id.setBounds(189, 107, 191, 32);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 260, 80, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnAddUserAdmin = new JButton("ADD USER ADMIN");
		btnAddUserAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					String userid = textField_id.getText();
					String name = textField_name.getText();
					String userpass = passwordField_1.getText();
					
					
					String sql = "Insert into admin(email, name, password) values('"+userid+"','"+name+"','"+userpass+"') ";
					stmt.execute(sql);
					textField_id.setText("");
					textField_name.setText("");
					passwordField_1.setText("");
					JOptionPane.showMessageDialog(null, "Data is successfully inserted");
					}
				    catch(Exception er) {
					JOptionPane.showMessageDialog(null,"Data Not inserted");
				}}
		
		});
		btnAddUserAdmin.setBounds(461, 142, 145, 40);
		contentPane.add(btnAddUserAdmin);
		
		JLabel lblEditUserAdmin = new JLabel("EDIT USER ADMIN");
		lblEditUserAdmin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEditUserAdmin.setBounds(100, 404, 182, 28);
		contentPane.add(lblEditUserAdmin);
		
		JLabel lblNewLabel_1 = new JLabel("USERID");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(29, 488, 99, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(189, 481, 201, 33);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("Password");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(29, 635, 80, 16);
		contentPane.add(label);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(189, 553, 201, 33);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(37, 560, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					String email1 = textField_2.getText();
					String name1 = textField_3.getText();
					String pass1 = passwordField.getText();
					
					String sql = "update admin set name='"+name1+"',password='"+pass1+"' where email = '"+email1+"'";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Data is successfully inserted");
					textField_2.setText("");
					textField_3.setText("");
					passwordField.setText("");
					
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "Please fill all details");
				}
			}
		});
		btnUpdate.setBounds(38, 711, 123, 40);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt=conn.createStatement();
					String user12 = textField_2.getText();
					
					String sql = "Delete From admin where email = '"+user12+"'";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Data deleted");
					}
					catch(Exception ep) {JOptionPane.showMessageDialog(null,"Please Fill all details");
					}
					textField_2.setText("");
					textField_3.setText("");
					passwordField.setText("");
			}});
			
		btnDelete.setBounds(237, 710, 132, 42);
		contentPane.add(btnDelete);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					
					String user = textField_2.getText();
					
					String sql = "Select * From admin where email = '"+user+"' ";
					
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						
						textField_3.setText(rs.getString("name"));
						passwordField.setText(rs.getString("password"));
						
					}else {
						JOptionPane.showMessageDialog(null,"Record not found");
					}
					
					
				}catch(Exception ex) { JOptionPane.showMessageDialog(null,"Enter The correct email id");
				}
				
			}
		});
		btnSearch.setBounds(500, 536, 132, 40);
		contentPane.add(btnSearch);
		
		textField_name = new JTextField();
		textField_name.setBounds(189, 180, 191, 32);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblName.setBounds(48, 188, 61, 16);
		contentPane.add(lblName);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(189, 631, 201, 32);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(189, 256, 191, 32);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				adminpanel object = new adminpanel();
				object.setVisible(true);
			
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton_1.setBounds(585, 7, 132, 40);
		contentPane.add(btnNewButton_1);
		
	}
}
