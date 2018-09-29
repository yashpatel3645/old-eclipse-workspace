import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.InputMethodListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.InputMethodEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class Search_student {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JButton btnSearch;
	private JLabel lblSearchBy;
	private JComboBox comboBox;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_student window = new Search_student();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search_student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSearch.setBounds(248, 139, 103, 35);
		frame.getContentPane().add(lblSearch);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(361, 139, 637, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 235, 1253, 421);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st  = con.createStatement();
					if(comboBox.getSelectedItem().toString() == "Student Name")
					{
						 ResultSet rs  = st.executeQuery("Select * from yashdb.student_details where LOWER(first_name) like '"+textField.getText()+"%' order by room_no");
						 table.setModel(DbUtils.resultSetToTableModel(rs));	
					}
					if(comboBox.getSelectedItem().toString() == "Roll No.")
					{
					ResultSet rs  = st.executeQuery("Select * from yashdb.student_details where ROLL_NUMBER like'"+textField.getText()+"%' order by room_no");
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					if(comboBox.getSelectedItem().toString() == "Block")
					{
					ResultSet rs  = st.executeQuery("Select * from yashdb.student_details where Lower(block) like'"+textField.getText()+"%'order by room_no");
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					if(comboBox.getSelectedItem().toString() == "Room No.")
					{
					ResultSet rs  = st.executeQuery("Select * from yashdb.student_details where room_n0 like '"+textField.getText()+"%'order by room_no");
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					if(comboBox.getSelectedItem().toString() == "College")
					{
					ResultSet rs  = st.executeQuery("Select * from yashdb.student_details where Lower(College) like'"+textField.getText()+"%'order by room_no");
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					if(comboBox.getSelectedItem().toString() == "Contect No.")
					{
					ResultSet rs  = st.executeQuery("Select * from yashdb.student_details where MOBILE_NUMBER like'"+textField.getText()+"%'order by room_no");
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					if(comboBox.getSelectedItem().toString() == "")
					{
						ResultSet rs1  = st.executeQuery("Select * from yashdb.student_details order by room_no");
						 table.setModel(DbUtils.resultSetToTableModel(rs1));
					}
				}
				catch(Exception ep)
				{
					 JOptionPane.showMessageDialog(null,ep.getMessage());
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(1008, 139, 103, 35);
		frame.getContentPane().add(btnSearch);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
			Statement st  = con.createStatement();
			ResultSet rs1  = st.executeQuery("Select * from yashdb.student_details order by room_no");
			 table.setModel(DbUtils.resultSetToTableModel(rs1));
		}
		catch(Exception ep)
		{
			 JOptionPane.showMessageDialog(null,ep.getMessage());
		}
			 
			 lblSearchBy = new JLabel("Search By");
			 lblSearchBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
			 lblSearchBy.setBounds(1027, 60, 103, 27);
			 frame.getContentPane().add(lblSearchBy);
			 
			 comboBox = new JComboBox();
			 comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
			 comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student Name", "Roll No.", "Block", "Room No.", "College", "Contect No."}));
			 comboBox.setBackground(Color.WHITE);
			 comboBox.setBounds(1120, 63, 140, 24);
			 frame.getContentPane().add(comboBox);
			 
			 btnBack = new JButton("Back");
			 btnBack.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		frame.setVisible(false);
			 		Main.main(null);
			 	}
			 });
			 btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
			 btnBack.setBounds(10, 671, 89, 23);
			 frame.getContentPane().add(btnBack);
		
	}
}
