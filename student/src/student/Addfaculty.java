package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Addfaculty extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addfaculty frame = new Addfaculty();
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
	
	public Addfaculty() {
		
		super("Addfaculty");
		conn = databaseconnect.connection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 50, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		setUndecorated(true);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblInsertFaculty = new JLabel("INSERT FACULTY DATA");
		lblInsertFaculty.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblInsertFaculty.setBounds(190, 51, 347, 31);
		contentPane.add(lblInsertFaculty);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(115, 130, 78, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField.setBounds(317, 128, 356, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblAddress.setBounds(115, 204, 109, 16);
		contentPane.add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(317, 199, 356, 26);
		contentPane.add(textField_1);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCity.setBounds(115, 276, 66, 25);
		contentPane.add(lblCity);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(317, 271, 356, 30);
		contentPane.add(textField_2);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblState.setBounds(115, 347, 78, 25);
		contentPane.add(lblState);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(317, 342, 356, 30);
		contentPane.add(textField_3);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(115, 418, 129, 24);
		contentPane.add(lblPhoneNumber);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(317, 413, 356, 29);
		contentPane.add(textField_4);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEmailId.setBounds(115, 498, 101, 28);
		contentPane.add(lblEmailId);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(317, 496, 356, 33);
		contentPane.add(textField_5);
		
		JLabel lblSubjectsTeaching = new JLabel("Subjects Teaching");
		lblSubjectsTeaching.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSubjectsTeaching.setBounds(115, 573, 158, 25);
		contentPane.add(lblSubjectsTeaching);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(317, 571, 356, 30);
		contentPane.add(textField_6);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setIcon(new ImageIcon(Addfaculty.class.getResource("/image/submit.png")));
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(textField.getText() == null || textField_1.getText()== null || textField_2.getText() == null || textField_3.getText() == null ||  textField_4.getText() == null || textField_5.getText() == null || textField_6.getText() == null) {
						JOptionPane.showMessageDialog(null, "Please fill all details");
					}
				else {
				try {
					stmt = conn.createStatement();
					String Faname = textField.getText();
					String Faaddress = textField_1.getText();
					String Facity = textField_2.getText();
					String Fastate = textField_3.getText();
					String FaPNumber = textField_4.getText();
					String Faemail = textField_5.getText();
					String Fasubject = textField_6.getText();
					if(FaPNumber.length() != 10){
						JOptionPane.showMessageDialog(null, "Please Enter 10 Digit number");
					}else {
					String 	sql = "Insert into faculty(name, address, city, state, pnumber, email, subject) values('"+Faname+"','"+Faaddress+"','"+Facity+"','"+Fastate+"','"+FaPNumber+"','"+Faemail+"','"+Fasubject+"') ";
					stmt.execute(sql);
					JOptionPane.showMessageDialog(null, "Data is successfully inserted");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					}
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "Please fill all details");
				}}		
			}
		});
		btnSubmit.setBounds(173, 669, 176, 43);
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setIcon(new ImageIcon(Addfaculty.class.getResource("/image/clear-icon-23.png")));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
			}
		});
		btnClear.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnClear.setBounds(500, 669, 148, 43);
		contentPane.add(btnClear);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnX.setBounds(728, 6, 66, 33);
		contentPane.add(btnX);
		
		JLabel lblUpdateAndSearch = new JLabel("INSERT");
		lblUpdateAndSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblUpdateAndSearch.setBounds(6, 6, 158, 16);
		contentPane.add(lblUpdateAndSearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(140, 10, 508, 12);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home object = new Home();
				object.setVisible(true);
			}
		});
		btnNewButton.setBounds(654, 6, 72, 33);
		contentPane.add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Home");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home object = new Home();
				object.setVisible(true);
			}
		});
		mntmNewMenuItem.setSelected(true);
		mnFile.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login object = new Login();
				object.setVisible(true);
			}
		});
		mnFile.add(mntmNewMenuItem_1);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		mntmClose.setSelected(true);
		mnFile.add(mntmClose);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Aboutus object = new Aboutus();
				object.setVisible(true);
			}
		});
		mnEdit.add(mntmAbout);
	}
}
