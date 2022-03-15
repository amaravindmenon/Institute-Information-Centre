package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class Addstudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addstudent frame = new Addstudent();
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
	
	
	public Addstudent() {
		
		super("Addstudent");
		conn = databaseconnect.connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,50, 800,800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setUndecorated(true);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblInsertStudentData = new JLabel("INSERT STUDENT DATA");
		lblInsertStudentData.setBounds(218, 27, 384, 53);
		lblInsertStudentData.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		contentPane.add(lblInsertStudentData);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(138, 126, 61, 16);
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(319, 121, 236, 26);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setBounds(138, 184, 130, 16);
		lblFathersName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblFathersName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(319, 179, 236, 26);
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(138, 302, 101, 16);
		lblAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setBounds(319, 297, 236, 26);
		textField_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		JLabel lblMothersName = new JLabel("Mother's Name");
		lblMothersName.setBounds(138, 244, 143, 16);
		lblMothersName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblMothersName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(319, 239, 236, 26);
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(138, 537, 61, 16);
		lblCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblCourse);
		
		textField_7 = new JTextField();
		textField_7.setBounds(319, 532, 236, 26);
		textField_7.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField_7.setColumns(10);
		contentPane.add(textField_7);
		
		JLabel lblNumber = new JLabel("Phone Number");
		lblNumber.setBounds(138, 479, 130, 16);
		lblNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblNumber);
		
		textField_6 = new JTextField();
		textField_6.setBounds(319, 474, 236, 26);
		textField_6.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField_6.setColumns(10);
		contentPane.add(textField_6);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(138, 419, 61, 16);
		lblState.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblState);
		
		textField_4 = new JTextField();
		textField_4.setBounds(319, 356, 236, 26);
		textField_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(138, 361, 61, 16);
		lblCity.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblCity);
		
		textField_5 = new JTextField();
		textField_5.setBounds(319, 414, 236, 26);
		textField_5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField_5.setColumns(10);
		contentPane.add(textField_5);
		
		JLabel lblInsert = new JLabel("INSERT");
		lblInsert.setBounds(27, 2, 68, 16);
		lblInsert.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblInsert);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(97, 6, 555, 12);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBounds(736, 2, 58, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setBounds(166, 636, 153, 41);
		btnNewButton_1.setIcon(new ImageIcon(Addstudent.class.getResource("/image/submit.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText() == null || textField_1.getText()== null || textField_2.getText() == null || textField_3.getText() == null ||  textField_4.getText() == null || textField_5.getText() == null || textField_6.getText() == null) {
					JOptionPane.showMessageDialog(null, "Ohh Snap!! All Field Required");
				}
			else {
				try {
					stmt = conn.createStatement();
					String stdName = textField.getText();
					String stdFaName = textField_1.getText();
					String stdMoName = textField_2.getText();
					String stdaddress = textField_3.getText();
					String stdstate = textField_4.getText();
					String stdcity = textField_5.getText();
					String stdnumber = textField_6.getText();
					String stdcourse = textField_7.getText();
					
					if(stdnumber.length() != 10){
						JOptionPane.showMessageDialog(null, "Please Enter 10 Digit number");
					}else {
					String sql = "Insert into student(stdName, stdFaName, stdMoName, stdaddress, stdstate, stdcity, stdnumber, stdcourse) values('"+stdName+"','"+stdFaName+"','"+stdMoName+"','"+stdaddress+"','"+stdstate+"','"+stdcity+"','"+stdnumber+"','"+stdcourse+"') ";
					stmt.execute(sql);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					JOptionPane.showMessageDialog(null, "Data is successfully inserted");
					}
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null,"Data Problem");
				}}
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setBounds(453, 636, 137, 41);
		btnNewButton_2.setIcon(new ImageIcon(Addstudent.class.getResource("/image/clear-icon-23.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home object = new Home();
				object.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(666, 2, 68, 33);
		contentPane.add(btnNewButton_3);
		
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
