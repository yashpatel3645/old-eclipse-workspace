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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class shift_empty {

	private JFrame frame;
	private JTextField s1roll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shift_empty window = new shift_empty();
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
	public shift_empty() {
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
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		JLabel lblShiftToEmpty = new JLabel("Shift To Empty Room");
		lblShiftToEmpty.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblShiftToEmpty.setBounds(423, 139, 358, 54);
		frame.getContentPane().add(lblShiftToEmpty);
		
		JLabel lblStudentDetail = new JLabel("Student Detail");
		lblStudentDetail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentDetail.setBounds(123, 273, 108, 26);
		frame.getContentPane().add(lblStudentDetail);
		
		JLabel lblBlock = new JLabel("Block");
		lblBlock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBlock.setBounds(123, 355, 73, 26);
		frame.getContentPane().add(lblBlock);
		
		JLabel lblRoomNo = new JLabel("Room No.");
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRoomNo.setBounds(123, 396, 73, 26);
		frame.getContentPane().add(lblRoomNo);
		
		JLabel lblRollNo = new JLabel("Roll No.");
		lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRollNo.setBounds(123, 433, 73, 33);
		frame.getContentPane().add(lblRollNo);
		
		JComboBox s1room = new JComboBox();
		s1room.setBounds(249, 401, 246, 25);
		frame.getContentPane().add(s1room);
		
		s1roll = new JTextField();
		s1roll.setBounds(249, 441, 246, 25);
		frame.getContentPane().add(s1roll);
		s1roll.setColumns(10);
		
		JLabel lblEmptyRoom = new JLabel("Empty Room");
		lblEmptyRoom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmptyRoom.setBounds(776, 273, 122, 26);
		frame.getContentPane().add(lblEmptyRoom);
		
		JLabel label = new JLabel("Block");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(776, 351, 73, 26);
		frame.getContentPane().add(label);
		
		JComboBox eroom = new JComboBox();
		eroom.setBounds(902, 397, 246, 25);
		frame.getContentPane().add(eroom);
		
		JLabel label_1 = new JLabel("Room No.");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(776, 392, 73, 26);
		frame.getContentPane().add(label_1);
		
		
		
		JComboBox s1block = new JComboBox();
		s1block.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				s1room.removeAllItems();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st  = con.createStatement();
					
					if(s1block.getSelectedItem().toString() == "A")
					{
					ResultSet rs  = st.executeQuery("Select * from yashdb.room where status=1 And Roomid between 1 and 60 order by roomid");
					while(rs.next())
					{
						String str  = rs.getString("roomid");
						s1room.addItem(str);
					}
					}
					if(s1block.getSelectedItem().toString() == "B")
					{
					ResultSet rs1  = st.executeQuery("Select * from yashdb.room where status>0 And Roomid between 61 and 90 order by roomid");
					while(rs1.next())
					{
						String str  = rs1.getString("roomid");
						s1room.addItem(str);
					}
					}
					
				}
				catch(Exception ep)
				{
					 JOptionPane.showMessageDialog(null,ep.getMessage());
				}
			}
		});
		s1block.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
		s1block.setBounds(249, 360, 246, 25);
		frame.getContentPane().add(s1block);
		
		JComboBox eblock = new JComboBox();
		eblock.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				eroom.removeAllItems();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st  = con.createStatement();
					
					if(eblock.getSelectedItem().toString() == "A")
					{
					ResultSet rs  = st.executeQuery("Select * from yashdb.room where status=0 And Roomid between 1 and 60 order by roomid");
					while(rs.next())
					{
						String str  = rs.getString("roomid");
						eroom.addItem(str);
					}
					}
					if(eblock.getSelectedItem().toString() == "B")
					{
					ResultSet rs1  = st.executeQuery("Select * from yashdb.room where status<2 And Roomid between 61 and 90 order by roomid ");
					while(rs1.next())
					{
						String str  = rs1.getString("roomid");
						eroom.addItem(str);
					}
					}
					JOptionPane.showMessageDialog(null, "Room Shifted.");
				}
				catch(Exception ep)
				{
					 JOptionPane.showMessageDialog(null,ep.getMessage());
				}
			}
		});
		eblock.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
		eblock.setBounds(902, 356, 246, 25);
		frame.getContentPane().add(eblock);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st  = con.createStatement();
					int rs = st.executeUpdate("update YASHDB.STUDENT_DETAILS set block='"+eblock.getSelectedItem().toString()+"',room_no='"+eroom.getSelectedItem().toString()+"' where roll_number='"+s1roll.getText()+"'");
					ResultSet rs2=st.executeQuery("select * from yashdb.room where roomid='"+s1room.getSelectedItem().toString()+"'");
					while(rs2.next())
					{
						if(rs2.getString("roll").equals(s1roll.getText()))
						{
							int rs1  = st.executeUpdate("UPDATE YASHDB.ROOM SET ROLL='"+s1roll.getText()+"',STATUS=1 where Roomid='"+eroom.getSelectedItem().toString()+"'");
						}
						else
						{
							int rs1  = st.executeUpdate("UPDATE YASHDB.ROOM SET ROLL_2='"+s1roll.getText()+"',STATUS=2 where Roomid='"+eroom.getSelectedItem().toString()+"'");
							
						}
					}
					ResultSet rs3=st.executeQuery("select * from yashdb.room where roomid='"+s1room.getSelectedItem().toString()+"'");
					while(rs3.next())
					{
						if(rs3.getString("roll").equals(s1roll.getText()))
						{
							int rs1  = st.executeUpdate("UPDATE YASHDB.ROOM SET ROLL='',STATUS=0 where Roomid='"+s1room.getSelectedItem().toString()+"'");
						}
						else
						{
							int rs1  = st.executeUpdate("UPDATE YASHDB.ROOM SET ROLL_2='',STATUS=1 where Roomid='"+s1room.getSelectedItem().toString()+"'");
							
						}
					}
				}
				catch(Exception ep)
				{
					 JOptionPane.showMessageDialog(null, ep.getMessage());
				}
			}
		});
		btnTransfer.setBounds(592, 513, 89, 23);
		frame.getContentPane().add(btnTransfer);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Main.main(null);
			}
		});
		btnNewButton.setBounds(59, 670, 89, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
			Statement st  = con.createStatement();
			
			if(s1block.getSelectedItem().toString() == "A")
			{
			ResultSet rs  = st.executeQuery("Select * from yashdb.room where status=1 And Roomid between 1 and 60 order by roomid");
			
			while(rs.next())
			{
				String str  = rs.getString("roomid");
				
				s1room.addItem(str);
				
			}
			}
			if(eblock.getSelectedItem().toString() == "A")
			{
				ResultSet rs1  = st.executeQuery("Select * from yashdb.room where status=0 And Roomid between 1 and 60 order by roomid");
				while(rs1.next())
				{
					String str1 = rs1.getString("roomid");
					eroom.addItem(str1);
				}
			}
			
		}
		catch(Exception ep)
		{
			 JOptionPane.showMessageDialog(null,ep.getMessage());
		}
	}
}
