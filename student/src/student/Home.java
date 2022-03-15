package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Home extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		getContentPane().setForeground(Color.LIGHT_GRAY);
		getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		getContentPane().setBackground(UIManager.getColor("CheckBox.disabledText"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,50, 900,800);
		
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSTITUTE INFORMATION CENTRE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/image/school.png")));
		lblNewLabel.setBounds(167, 34, 557, 152);
		getContentPane().add(lblNewLabel);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblHome.setBounds(6, 6, 72, 25);
		getContentPane().add(lblHome);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(698, 10, 1, 12);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(77, 10, 717, 12);
		getContentPane().add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Addstudent object = new Addstudent();
				object.setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/image/graduated.png")));
		lblNewLabel_1.setBounds(20, 232, 230, 185);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnAddStudent = new JButton("ADD STUDENT");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Addstudent object = new Addstudent();
				object.setVisible(true);
			}
		});
		btnAddStudent.setBounds(78, 441, 136, 29);
		getContentPane().add(btnAddStudent);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Showstudents object = new Showstudents();
				object.setVisible(true);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/image/students.png")));
		lblNewLabel_2.setBounds(635, 209, 230, 220);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnShowStudent = new JButton("SHOW STUDENT");
		btnShowStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Showstudents object = new Showstudents();
				object.setVisible(true);
			}
		});
		btnShowStudent.setBounds(675, 441, 145, 29);
		getContentPane().add(btnShowStudent);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Studentoperation object = new Studentoperation();
				object.setVisible(true);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(Home.class.getResource("/image/book.png")));
		lblNewLabel_3.setBounds(332, 187, 245, 244);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnOperations = new JButton("OPERATIONS");
		btnOperations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Studentoperation object = new Studentoperation();
				object.setVisible(true);
			}
		});
		btnOperations.setBounds(359, 441, 130, 29);
		getContentPane().add(btnOperations);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Addfaculty object = new Addfaculty();
				object.setVisible(true);	
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(Home.class.getResource("/image/admin.png")));
		lblNewLabel_4.setBounds(50, 505, 183, 185);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnAddAdmin = new JButton("ADD FACULTY");
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Addfaculty object = new Addfaculty();
				object.setVisible(true);
			}
		});
		btnAddAdmin.setBounds(89, 702, 117, 29);
		getContentPane().add(btnAddAdmin);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Facultyoperation object = new Facultyoperation();
				object.setVisible(true);
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(Home.class.getResource("/image/admin123.png")));
		lblNewLabel_5.setBounds(353, 505, 158, 185);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnOperations_1 = new JButton("OPERATIONS");
		btnOperations_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Facultyoperation object = new Facultyoperation();
				object.setVisible(true);
			}
		});
		btnOperations_1.setBounds(372, 702, 117, 29);
		getContentPane().add(btnOperations_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Showfaculty object = new Showfaculty();
				object.setVisible(true);
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon(Home.class.getResource("/image/employee.png")));
		lblNewLabel_6.setBounds(649, 509, 202, 177);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnShowAdmin = new JButton("SHOW FACULTY");
		btnShowAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Showfaculty object = new Showfaculty();
				object.setVisible(true);
			}
		});
		btnShowAdmin.setBounds(675, 702, 136, 29);
		getContentPane().add(btnShowAdmin);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton.setFont(new Font("Marker Felt", Font.PLAIN, 18));
		btnNewButton.setBounds(821, 6, 73, 36);
		getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Home");
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
