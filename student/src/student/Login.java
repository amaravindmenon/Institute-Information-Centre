package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
	public Login() {
		
		super("Login");
		conn = databaseconnect.connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 650, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setUndecorated(true);
		contentPane.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(267, 187, 256, 40);
		txtEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(267, 268, 254, 40);
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/image/SSecurity1.png")));
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				try {
					stmt = conn.createStatement();
					String userEmail = txtEmail.getText();
					String userPass = passwordField.getText();
					
					String sql = "Select * from admin where email  = '"+userEmail+"'&& password = '"+userPass+"'";
					
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						setVisible(false);
						Home object = new Home();
						object.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"password or email incorrect");
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
				
				}
			}
			
		});
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				stmt = conn.createStatement();
				String userEmail = txtEmail.getText();
				String userPass = passwordField.getText();
				
				String sql = "Select * from admin where email  = '"+userEmail+"'&& password = '"+userPass+"'";
				
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					setVisible(false);
					Home object = new Home();
					object.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"password or email incorrect");
				}
				
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,ex);
			}
			
			}
		});
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(98, 343, 163, 59);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnCancel.setBounds(345, 343, 156, 59);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCancel);
		
		JLabel lblEmailId = new JLabel("EMAIL ID");
		lblEmailId.setBounds(125, 196, 74, 23);
		lblEmailId.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		contentPane.add(lblEmailId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(114, 277, 106, 23);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		contentPane.add(lblPassword);
		
		JLabel lblLoginPage = new JLabel("LOGIN PAGE");
		lblLoginPage.setBounds(237, 93, 282, 59);
		lblLoginPage.setBackground(Color.WHITE);
		lblLoginPage.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		contentPane.add(lblLoginPage);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBounds(603, 0, 47, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/image/2321232.png")));
		lblNewLabel.setBounds(145, 47, 118, 140);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/image/login.png")));
		lblNewLabel_1.setBounds(234, 22, 163, 59);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/image/change-password.png")));
		lblNewLabel_3.setBounds(6, 260, 96, 59);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/image/email png.png")));
		lblNewLabel_2.setBounds(32, 163, 92, 85);
		contentPane.add(lblNewLabel_2);
	}
}
