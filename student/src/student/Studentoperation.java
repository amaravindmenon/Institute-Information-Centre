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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class Studentoperation extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField faname;
	private JTextField address;
	private JTextField moname;
	private JTextField course;
	private JTextField pnumber;
	private JTextField state;
	private JTextField city;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentoperation frame = new Studentoperation();
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
	private JTextField id;
	
	public Studentoperation() {
		
		super("studentoperation");
		conn = databaseconnect.connection();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,50, 800,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setUndecorated(true);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblInsertStudentData = new JLabel("UPDATE OR SEARCH STUDENT DATA");
		lblInsertStudentData.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblInsertStudentData.setBounds(107, 27, 569, 53);
		contentPane.add(lblInsertStudentData);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblName.setBounds(137, 164, 61, 16);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		name.setBounds(318, 159, 236, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblFathersName.setBounds(137, 222, 130, 16);
		contentPane.add(lblFathersName);
		
		faname = new JTextField();
		faname.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		faname.setColumns(10);
		faname.setBounds(318, 217, 236, 26);
		contentPane.add(faname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAddress.setBounds(137, 340, 101, 16);
		contentPane.add(lblAddress);
		
		address = new JTextField();
		address.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		address.setColumns(10);
		address.setBounds(318, 335, 236, 26);
		contentPane.add(address);
		
		JLabel lblMothersName = new JLabel("Mother's Name");
		lblMothersName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblMothersName.setBounds(137, 282, 143, 16);
		contentPane.add(lblMothersName);
		
		moname = new JTextField();
		moname.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		moname.setColumns(10);
		moname.setBounds(318, 277, 236, 26);
		contentPane.add(moname);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCourse.setBounds(137, 575, 61, 16);
		contentPane.add(lblCourse);
		
		course = new JTextField();
		course.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		course.setColumns(10);
		course.setBounds(318, 570, 236, 26);
		contentPane.add(course);
		
		JLabel lblNumber = new JLabel("Phone Number");
		lblNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNumber.setBounds(137, 517, 130, 16);
		contentPane.add(lblNumber);
		
		pnumber = new JTextField();
		pnumber.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		pnumber.setColumns(10);
		pnumber.setBounds(318, 512, 236, 26);
		contentPane.add(pnumber);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblState.setBounds(137, 457, 61, 16);
		contentPane.add(lblState);
		
		city = new JTextField();
		city.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		city.setColumns(10);
		city.setBounds(318, 394, 236, 26);
		contentPane.add(city);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCity.setBounds(137, 399, 61, 16);
		contentPane.add(lblCity);
		
		state = new JTextField();
		state.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		state.setColumns(10);
		state.setBounds(318, 452, 236, 26);
		contentPane.add(state);
		
		JLabel lblInsert = new JLabel("UPDATE AND SEARCH");
		lblInsert.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblInsert.setBounds(27, 2, 154, 16);
		contentPane.add(lblInsert);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(203, 6, 458, 12);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton.setBounds(736, 2, 58, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setIcon(new ImageIcon(Studentoperation.class.getResource("/image/Apps-system-software-update-icon.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int stdid = Integer.parseInt(id.getText());
					String stdName = name.getText();
					String stdFaName = faname.getText();
					String stdMoName = moname.getText();
					String stdaddress = address.getText();
					String stdstate = city.getText();
					String stdcity = state.getText();
					String stdnumber = pnumber.getText();
					String stdcourse = course.getText();
					
					
					if(stdnumber.length() != 10){
						JOptionPane.showMessageDialog(null, "Please Enter 10 Digit number");
					}else {
					String sql = "update student set stdName = '"+stdName+"',stdFaName='"+stdFaName+"', stdMoName='"+stdMoName+"', stdaddress='"+stdaddress+"', stdstate='"+stdstate+"', stdcity='"+stdcity+"', stdnumber='"+stdnumber+"', stdcourse='"+stdcourse+"' where stdid='"+stdid+"'";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Data is successfully inserted");
					name.setText("");
					faname.setText("");
					moname.setText("");
					address.setText("");
					city.setText("");
					state.setText("");
					pnumber.setText("");
					course.setText("");
				}}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "Please fill all details");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton_1.setBounds(166, 636, 143, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setIcon(new ImageIcon(Studentoperation.class.getResource("/image/clear-icon-23.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			id.setText("");
			name.setText("");
			faname.setText("");
			moname.setText("");
			address.setText("");
			city.setText("");
			state.setText("");
			pnumber.setText("");
			course.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton_2.setBounds(551, 636, 137, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SEARCH");
		btnNewButton_3.setIcon(new ImageIcon(Studentoperation.class.getResource("/image/Search-icon.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				stmt = conn.createStatement();
				
				int stdid = Integer.parseInt(id.getText());
				
				String sql = "Select * From Student where stdid = '"+stdid+"' ";
				
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					
					name.setText(rs.getString("stdName"));
					faname.setText(rs.getString("stdFaName"));
					moname.setText(rs.getString("stdMoName"));
					address.setText(rs.getString("stdaddress"));
					city.setText(rs.getString("stdstate"));
					state.setText(rs.getString("stdcity"));
					pnumber.setText(rs.getString("stdnumber"));
					course.setText(rs.getString("stdcourse"));
					
				}else {
					JOptionPane.showMessageDialog(null,"Record not found");
				}
				
				
			}catch(Exception ex) { JOptionPane.showMessageDialog(null,"Enter The Register Id Number");
			}
			}
		});
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton_3.setBounds(632, 148, 143, 47);
		contentPane.add(btnNewButton_3);
		
		id = new JTextField();
		id.setBounds(318, 92, 220, 33);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblId.setBounds(137, 103, 61, 16);
		contentPane.add(lblId);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.setIcon(new ImageIcon(Studentoperation.class.getResource("/image/25776-7-delete-button-image.png")));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			stmt=conn.createStatement();
			int stdid = Integer.parseInt(id.getText());
			if(name.getText() == null || faname.getText()== null || moname.getText() == null || address.getText() == null ||  city.getText() == null || state.getText() == null || pnumber.getText() == null || course.getText() == null) {
				JOptionPane.showMessageDialog(null, "Please fill all details");
			}
		else {
			String sql = "Delete From Student where stdid = '"+stdid+"'";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"Data deleted");
			}}
			catch(Exception ep) {JOptionPane.showMessageDialog(null,"Please fill all details");
			}
			name.setText("");
			faname.setText("");
			moname.setText("");
			address.setText("");
			city.setText("");
			state.setText("");
			pnumber.setText("");
			course.setText("");
			}});
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton_4.setBounds(363, 637, 143, 41);
		contentPane.add(btnNewButton_4);
		
		JLabel lblenterIdTo = new JLabel("(Enter Id to search Data)");
		lblenterIdTo.setBounds(568, 100, 154, 16);
		contentPane.add(lblenterIdTo);
		
		JButton btnNewButton_5 = new JButton("BACK");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home object = new Home();
				object.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(676, 2, 61, 33);
		contentPane.add(btnNewButton_5);
		
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
