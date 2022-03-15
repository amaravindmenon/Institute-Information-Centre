package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;

public class Showfaculty extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Showfaculty frame = new Showfaculty();
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
	private JTextField textField;
	
	public Showfaculty() {
		
		super("faculty");
		conn = databaseconnect.connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,50, 1300,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setUndecorated(true);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblStudentData = new JLabel("Faculty Data");
		lblStudentData.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblStudentData.setBounds(6, 6, 114, 16);
		contentPane.add(lblStudentData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(132, 10, 1037, 12);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton.setBounds(1251, 6, 43, 40);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 69, 1275, 640);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setColumnHeaderView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home object = new Home();
				object.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(381, 724, 159, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home object = new Home();
				object.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(1184, 6, 65, 40);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(108, 27, 185, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("ENTER");
		lblSearch.setBounds(44, 34, 61, 16);
		contentPane.add(lblSearch);
		
		
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
	
		showrecord();
	}

public void showrecord() {
	
	JButton btnSearch = new JButton("SEARCH");
	btnSearch.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				stmt = conn.createStatement();
				String abc = textField.getText();
				String num = textField.getText();
				String sql = "select * from faculty where name LIKE '%"+abc+"%' or pnumber LIKE '%"+num+"%' " ;
				ResultSet res = stmt.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(res));
				
			}catch(Exception ea) {
				JOptionPane.showMessageDialog(null,ea);
			}
	
		}
	});
	btnSearch.setBounds(305, 28, 117, 29);
	contentPane.add(btnSearch);

	JButton btnShowAll = new JButton("SHOW ALL");
	btnShowAll.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				stmt = conn.createStatement();
				String sql = "select * from faculty";
				ResultSet res = stmt.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(res));
				
			}catch(Exception ea) {
				JOptionPane.showMessageDialog(null,ea);
			}
		}
	});
	btnShowAll.setBounds(422, 28, 117, 29);
	contentPane.add(btnShowAll);
	
	
			}
}
