import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AllotNewSeat {

	private JFrame frame;
	private JComboBox BLOCK;
	private JComboBox ROOM;
	private JTextField MNAME;
	private JTextField FNAME;
	private JTextField MOBILE;
	private JTextField BIRTH;
	private JTextField ROLL;
	private JTextField LNAME;
	private JTextField COLLEGE;
	private JTextField PARENTSMOBILE;
	private JTextField FEES;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllotNewSeat window = new AllotNewSeat();
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
	public AllotNewSeat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(399, 222, 164, 23);
		frame.getContentPane().add(lblName);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblStudentDetails.setBounds(57, 39, 460, 66);
		frame.getContentPane().add(lblStudentDetails);
		
		JLabel lblRommNo = new JLabel("Room No.");
		lblRommNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRommNo.setBounds(399, 188, 164, 23);
		frame.getContentPane().add(lblRommNo);
		
		JLabel lblBlock = new JLabel("Block");
		lblBlock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBlock.setBounds(399, 154, 164, 23);
		frame.getContentPane().add(lblBlock);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMiddleName.setBounds(399, 256, 164, 23);
		frame.getContentPane().add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(399, 290, 164, 23);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblRollNo = new JLabel("Roll No.");
		lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRollNo.setBounds(399, 324, 164, 23);
		frame.getContentPane().add(lblRollNo);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBirthDate.setBounds(399, 358, 164, 23);
		frame.getContentPane().add(lblBirthDate);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMobileNo.setBounds(399, 391, 164, 23);
		frame.getContentPane().add(lblMobileNo);
		
		JLabel lblParentMobileNo = new JLabel("Parent Mobile No.");
		lblParentMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParentMobileNo.setBounds(399, 425, 164, 23);
		frame.getContentPane().add(lblParentMobileNo);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(399, 459, 164, 23);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCollege = new JLabel("College");
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCollege.setBounds(399, 494, 164, 23);
		frame.getContentPane().add(lblCollege);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFees.setBounds(399, 528, 164, 23);
		frame.getContentPane().add(lblFees);
		
		ROOM = new JComboBox();
		ROOM.setBackground(Color.WHITE);
		ROOM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ROOM.setBounds(573, 187, 280, 23);
		frame.getContentPane().add(ROOM);
		
		MNAME = new JTextField();
		MNAME.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MNAME.setColumns(10);
		MNAME.setBounds(573, 255, 280, 23);
		frame.getContentPane().add(MNAME);
		
		FNAME = new JTextField();
		FNAME.setFont(new Font("Tahoma", Font.PLAIN, 16));
		FNAME.setColumns(10);
		FNAME.setBounds(573, 221, 280, 23);
		frame.getContentPane().add(FNAME);
		
		MOBILE = new JTextField();
		MOBILE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MOBILE.setColumns(10);
		MOBILE.setBounds(573, 392, 280, 23);
		frame.getContentPane().add(MOBILE);
		
		BIRTH = new JTextField();
		BIRTH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BIRTH.setColumns(10);
		BIRTH.setBounds(573, 358, 280, 23);
		frame.getContentPane().add(BIRTH);
		
		ROLL = new JTextField();
		ROLL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ROLL.setColumns(10);
		ROLL.setBounds(573, 324, 280, 23);
		frame.getContentPane().add(ROLL);
		
		LNAME = new JTextField();
		LNAME.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LNAME.setColumns(10);
		LNAME.setBounds(573, 290, 280, 23);
		frame.getContentPane().add(LNAME);
		
		COLLEGE = new JTextField();
		COLLEGE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		COLLEGE.setColumns(10);
		COLLEGE.setBounds(573, 493, 280, 23);
		frame.getContentPane().add(COLLEGE);
		
		PARENTSMOBILE = new JTextField();
		PARENTSMOBILE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PARENTSMOBILE.setColumns(10);
		PARENTSMOBILE.setBounds(573, 425, 280, 23);
		frame.getContentPane().add(PARENTSMOBILE);
		
		FEES = new JTextField();
		FEES.setFont(new Font("Tahoma", Font.PLAIN, 16));
		FEES.setColumns(10);
		FEES.setBounds(573, 527, 280, 23);
		frame.getContentPane().add(FEES);
		
		BLOCK = new JComboBox();
		BLOCK.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
		BLOCK.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ROOM.removeAllItems();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st  = con.createStatement();
					
					if(BLOCK.getSelectedItem().toString() == "A")
					{
					ResultSet rs  = st.executeQuery("Select * from yashdb.room where status=0 And Roomid between 1 and 60 order by roomid");
					while(rs.next())
					{
						String str  = rs.getString("roomid");
						ROOM.addItem(str);
					}
					}
					if(BLOCK.getSelectedItem().toString() == "B")
					{
					ResultSet rs1  = st.executeQuery("Select * from yashdb.room where status<2 And Roomid between 61 and 90 order by roomid");
					while(rs1.next())
					{
						String str  = rs1.getString("roomid");
						ROOM.addItem(str);
					}
					}
					
				}
				catch(Exception ep)
				{
					 JOptionPane.showMessageDialog(null,ep.getMessage());
				}
			}
		});
		BLOCK.setBackground(Color.WHITE);
		BLOCK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BLOCK.setBounds(573, 153, 280, 23);
		frame.getContentPane().add(BLOCK);
		
		JTextField ADDRE = new JTextField();
		ADDRE.setBounds(573, 460, 280, 23);
		frame.getContentPane().add(ADDRE);
		frame.setBounds(100, 100, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		ADDRE.setBorder(border);
		BLOCK.setBorder(border);
		ROOM.setBorder(border);
		MNAME.setBorder(border);
		FNAME.setBorder(border);
		MOBILE.setBorder(border);
		BIRTH.setBorder(border);
		ROLL.setBorder(border);
		LNAME.setBorder(border);
		COLLEGE.setBorder(border);
		PARENTSMOBILE.setBorder(border);
		FEES.setBorder(border);

		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","yash");
				Statement st = con.createStatement();
				int rs = st.executeUpdate("INSERT INTO YASHDB.STUDENT_DETAILS(ROLL_NUMBER,BLOCK,ROOM_NO,FIRST_NAME,MIDDLE_NAME,LAST_NAME,BIRTHDAY,MOBILE_NUMBER,FATHER_NUMBER,ADDRESS,COLLEGE,FEES)VALUES('"+ROLL.getText()+"','"+BLOCK.getSelectedItem().toString()+"','"+ROOM.getSelectedItem().toString()+"','"+FNAME.getText()+"','"+MNAME.getText()+"','"+LNAME.getText()+"','"+BIRTH.getText()+"','"+MOBILE.getText()+"','"+PARENTSMOBILE.getText()+"','"+ADDRE.getText()+"','"+COLLEGE.getText()+"','"+FEES.getText()+"')");
				
				ResultSet rs2=st.executeQuery("select * from yashdb.room where roomid='"+ROOM.getSelectedItem().toString()+"'");
				while(rs2.next())
				{
					if(rs2.getString("roll").isEmpty())
					{
						int rs1  = st.executeUpdate("UPDATE YASHDB.ROOM SET ROLL='"+ROLL.getText()+"',STATUS=1 where Roomid='"+ROOM.getSelectedItem().toString()+"'");
					}
					else
					{
						int rs1  = st.executeUpdate("UPDATE YASHDB.ROOM SET ROLL_2='"+ROLL.getText()+"',STATUS=2 where Roomid='"+ROOM.getSelectedItem().toString()+"'");
						
					}
				}
				
				JOptionPane.showMessageDialog(null, "Room Allocated.");
				}
				catch(Exception ep)
				{
					JOptionPane.showMessageDialog(null,ep.getMessage());
				}
			}
		});
		btnSave.setBackground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBounds(1060, 621, 147, 41);
		frame.getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Main.main(null);
			}
		});
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(47, 633, 147, 41);
		frame.getContentPane().add(btnBack);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
			Statement st  = con.createStatement();
			
			if(BLOCK.getSelectedItem().toString() == "A")
			{
			ResultSet rs  = st.executeQuery("Select * from yashdb.room where status=0 And Roomid between 1 and 60 order by roomid");
			while(rs.next())
			{
				String str  = rs.getString("roomid");
				ROOM.addItem(str);
			}
			}
			
			
		}
		catch(Exception ep)
		{
			 JOptionPane.showMessageDialog(null,ep.getMessage());
		}
	}
}
