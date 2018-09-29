import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Show_request {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show_request window = new Show_request();
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
	public Show_request() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRequestsFromEmpty = new JLabel("Requests From Empty Rooms");
		lblRequestsFromEmpty.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRequestsFromEmpty.setBounds(56, 111, 522, 62);
		frame.getContentPane().add(lblRequestsFromEmpty);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 229, 888, 360);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Main.main(null);
			}
		});
		btnBack.setBounds(56, 648, 89, 23);
		frame.getContentPane().add(btnBack);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
			Statement st  = con.createStatement();
			ResultSet rs = st.executeQuery("select * from yashdb.request order by request_no");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception ep)
		{
			 JOptionPane.showMessageDialog(null,ep.getMessage());
		}
	}
}
