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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Facultyoperation extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField city;
	private JTextField state;
	private JTextField pnumber;
	private JTextField email;
	private JTextField subject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facultyoperation frame = new Facultyoperation();
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
	
	public Facultyoperation() {
		
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
		
		JLabel lblInsertFaculty = new JLabel("UPDATE AND SEARCH FACULTY DATA");
		lblInsertFaculty.setBounds(137, 39, 456, 31);
		lblInsertFaculty.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		contentPane.add(lblInsertFaculty);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(48, 145, 81, 26);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(190, 143, 318, 31);
		name.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(48, 220, 90, 16);
		lblAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblAddress);
		
		address = new JTextField();
		address.setBounds(190, 215, 318, 26);
		address.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		address.setColumns(10);
		contentPane.add(address);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(48, 289, 85, 25);
		lblCity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblCity);
		
		city = new JTextField();
		city.setBounds(190, 287, 318, 30);
		city.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		city.setColumns(10);
		contentPane.add(city);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(48, 365, 85, 25);
		lblState.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblState);
		
		state = new JTextField();
		state.setBounds(190, 356, 318, 33);
		state.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		state.setColumns(10);
		contentPane.add(state);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(48, 445, 125, 24);
		lblPhoneNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblPhoneNumber);
		
		pnumber = new JTextField();
		pnumber.setBounds(190, 443, 318, 33);
		pnumber.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		pnumber.setColumns(10);
		contentPane.add(pnumber);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setBounds(48, 520, 85, 28);
		lblEmailId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblEmailId);
		
		email = new JTextField();
		email.setBounds(190, 518, 318, 33);
		email.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		email.setColumns(10);
		contentPane.add(email);
		
		JLabel lblSubjectsTeaching = new JLabel("Subjects Teaching");
		lblSubjectsTeaching.setBounds(48, 597, 138, 25);
		lblSubjectsTeaching.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblSubjectsTeaching);
		
		subject = new JTextField();
		subject.setBounds(190, 597, 318, 33);
		subject.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		subject.setColumns(10);
		contentPane.add(subject);
		
		JButton btnSubmit = new JButton("UPDATE");
		btnSubmit.setIcon(new ImageIcon(Facultyoperation.class.getResource("/image/Apps-system-software-update-icon.png")));
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnSubmit.setBounds(93, 669, 138, 43);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt = conn.createStatement();
					int stdid = Integer.parseInt(id.getText());
					String Faname = name.getText();
					String Faaddress = address.getText();
					String Facity = city.getText();
					String Fastate = state.getText();
					String FaPNumber = pnumber.getText();
					String Faemail = email.getText();
					String Fasubject = subject.getText();
					
					if(FaPNumber.length() != 10){
						JOptionPane.showMessageDialog(null, "Please Enter 10 Digit number");
					}else {
					String sql = "update faculty set name ='"+Faname+"', address='"+Faaddress+"', city='"+Facity+"', state='"+Fastate+"', pnumber='"+FaPNumber+"', email='"+Faemail+"', subject='"+Fasubject+"' where id = '"+stdid+"'";
					stmt.execute(sql);
					JOptionPane.showMessageDialog(null, "Data is successfully updated");
					name.setText("");
					address.setText("");
					city.setText("");
					state.setText("");
					pnumber.setText("");
					email.setText("");
					subject.setText("");
				}}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "Please fill all details");
				}
			}
		});
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setIcon(new ImageIcon(Facultyoperation.class.getResource("/image/clear-icon-23.png")));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				address.setText("");
				city.setText("");
				state.setText("");
				pnumber.setText("");
				email.setText("");
				subject.setText("");
			}
		});
		btnClear.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnClear.setBounds(500, 669, 148, 43);
		contentPane.add(btnClear);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stmt=conn.createStatement();
					int stdid = Integer.parseInt(id.getText());
					String sql = "Delete From faculty where id = '"+stdid+"'";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Data deleted");
					}catch(Exception ep) {JOptionPane.showMessageDialog(null,"Please fill all details");
					}
					name.setText("");
					address.setText("");
					city.setText("");
					state.setText("");
					pnumber.setText("");
					email.setText("");
					subject.setText("");
					}});
		btnNewButton.setIcon(new ImageIcon(Facultyoperation.class.getResource("/image/25776-7-delete-button-image.png")));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton.setBounds(289, 669, 138, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setIcon(new ImageIcon(Facultyoperation.class.getResource("/image/Search-icon.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					stmt = conn.createStatement();
					
					int stdid = Integer.parseInt(id.getText());
					
					String sql = "Select * From faculty where id = '"+stdid+"' ";
					
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						
						name.setText(rs.getString("name"));
						address.setText(rs.getString("address"));
						city.setText(rs.getString("city"));
						state.setText(rs.getString("state"));
						pnumber.setText(rs.getString("pnumber"));
						email.setText(rs.getString("email"));
						subject.setText(rs.getString("subject"));
						
					}else {
						JOptionPane.showMessageDialog(null,"Record not found");
					}
					
					
				}catch(Exception ex) { JOptionPane.showMessageDialog(null,"Please fill all details");
				}
			
			
			} 
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton_1.setBounds(599, 131, 138, 43);
		contentPane.add(btnNewButton_1);
		
		id = new JTextField();
		id.setBounds(190, 92, 237, 31);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblId.setBounds(48, 97, 61, 16);
		contentPane.add(lblId);
		
		JLabel lblUpdateAndSearch = new JLabel("UPDATE AND SEARCH");
		lblUpdateAndSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblUpdateAndSearch.setBounds(6, 12, 167, 16);
		contentPane.add(lblUpdateAndSearch);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnX.setBounds(739, 6, 61, 38);
		contentPane.add(btnX);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(169, 15, 495, 12);
		contentPane.add(separator);
		
		JLabel label = new JLabel("(Enter Id to search Data)");
		label.setBounds(457, 99, 154, 16);
		contentPane.add(label);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home object = new Home();
				object.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(666, 8, 71, 36);
		contentPane.add(btnNewButton_2);
		
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

