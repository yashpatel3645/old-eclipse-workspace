import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class swap {

	private JFrame frame;
	private JTextField s1roll;
	private JTextField s2roll;
	private JComboBox s2block;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swap window = new swap();
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
	public swap() {
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
		
		JLabel lblStudemt = new JLabel("Student 1");
		lblStudemt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStudemt.setBounds(183, 267, 121, 51);
		frame.getContentPane().add(lblStudemt);
		
		JLabel lblBlock = new JLabel("Block");
		lblBlock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBlock.setBounds(77, 355, 86, 26);
		frame.getContentPane().add(lblBlock);
		
		JLabel lblRoomNo = new JLabel("Room No.");
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRoomNo.setBounds(77, 392, 86, 26);
		frame.getContentPane().add(lblRoomNo);
		
		JLabel lblRoolNo = new JLabel("Roll No.");
		lblRoolNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRoolNo.setBounds(77, 429, 86, 26);
		frame.getContentPane().add(lblRoolNo);
		
		JComboBox s1room = new JComboBox();
		s1room.setBackground(Color.WHITE);
		s1room.setFont(new Font("Tahoma", Font.PLAIN, 15));
		s1room.setBounds(173, 392, 246, 25);
		frame.getContentPane().add(s1room);
		
		JComboBox s1block = new JComboBox();
		s1block.setBackground(Color.WHITE);
		s1block.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
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
		s1block.setFont(new Font("Tahoma", Font.PLAIN, 15));
		s1block.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
		s1block.setBounds(173, 355, 246, 25);
		frame.getContentPane().add(s1block);
		
		
		
		s1roll = new JTextField();
		s1roll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		s1roll.setBounds(173, 429, 246, 25);
		frame.getContentPane().add(s1roll);
		s1roll.setColumns(10);
		
		JLabel lblStudent = new JLabel("Student 2");
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStudent.setBounds(830, 267, 121, 51);
		frame.getContentPane().add(lblStudent);
		
		JLabel label_1 = new JLabel("Block");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(724, 355, 86, 26);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Room No.");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(724, 392, 86, 26);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Roll No.");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(724, 429, 86, 26);
		frame.getContentPane().add(label_3);
		
		s2roll = new JTextField();
		s2roll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		s2roll.setColumns(10);
		s2roll.setBounds(820, 429, 246, 25);
		frame.getContentPane().add(s2roll);
		
		JComboBox s2room = new JComboBox();
		s2room.setBackground(Color.WHITE);
		s2room.setFont(new Font("Tahoma", Font.PLAIN, 15));
		s2room.setBounds(820, 392, 246, 25);
		frame.getContentPane().add(s2room);
		
		s2block = new JComboBox();
		s2block.setBackground(Color.WHITE);
		s2block.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
		s2block.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				s2room.removeAllItems();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st  = con.createStatement();
					
					if(s2block.getSelectedItem().toString() == "A")
					{
					ResultSet rs  = st.executeQuery("Select * from yashdb.room where status=1 And Roomid between 1 and 60 order by roomid");
					while(rs.next())
					{
						String str  = rs.getString("roomid");
						s2room.addItem(str);
					}
					}
					if(s2block.getSelectedItem().toString() == "B")
					{
					ResultSet rs1  = st.executeQuery("Select * from yashdb.room where status>0 And Roomid between 61 and 90 order by roomid");
					while(rs1.next())
					{
						String str  = rs1.getString("roomid");
						s2room.addItem(str);
					}
					}
					
				}
				catch(Exception ep)
				{
					 JOptionPane.showMessageDialog(null,ep.getMessage());
				}
			}
		});
		s2block.setFont(new Font("Tahoma", Font.PLAIN, 15));
		s2block.setBounds(820, 355, 246, 25);
		frame.getContentPane().add(s2block);
		
		JLabel lblSwapRooms = new JLabel("SWAP ROOMS");
		lblSwapRooms.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblSwapRooms.setBounds(473, 117, 246, 105);
		frame.getContentPane().add(lblSwapRooms);
		
		JButton btnSwap = new JButton("Swap");
		btnSwap.setBackground(Color.WHITE);
		btnSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
				Statement st  = con.createStatement();
			//	int rs = st.executeUpdate("Update yashdb.student_details set block='"+s2block.getSelectedItem().toString()+"',room_no='"+s2room.getSelectedItem().toString()+"' where roll_number='"+s1roll.getText()+"'");
			//	int rs1 = st.executeUpdate("Update yashdb.student_details set block='"+s1block.getSelectedItem().toString()+"', room_no='"+s1room.getSelectedItem().toString()+"' where roll_number='"+s2roll.getText()+"'");
			//	ResultSet rs2 = st.executeQuery("Select * from yashdb.Room where roomid='"+s1room.getSelectedItem().toString()+"'");
			//	ResultSet rs3 = st.executeQuery("Select * from yashdb.Room where roomid='"+s2room.getSelectedItem().toString()+"'");
				
				ResultSet rs66 = st.executeQuery("select * from yashdb.room");
				while(rs66.next())
				{
					ResultSet rs35 = st.executeQuery("select * from yashdb.room");
					while(rs35.next())
					{
						String s1=s1roll.getText();
						String s2=s2roll.getText();
						if(s1block.getSelectedItem().toString() == "A")
						{
							if(s2block.getSelectedItem().toString() == "A")
							{
								int rs4 = st.executeUpdate("update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
								int rs5 = st.executeUpdate("update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll='"+s1roll.getText()+"'where roomid='"+s2room.getSelectedItem().toString()+"'");
							}
							else if(s2block.getSelectedItem().toString() == "B")
							{
								if(rs35.getString("roll").equals(s2))
								{
									int rs6 = st.executeUpdate("update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
									int rs7 = st.executeUpdate("update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll='"+s1roll.getText()+"'where roomid='"+s2room.getSelectedItem().toString()+"'");
									JOptionPane.showMessageDialog(null, "hello1");
								}
								else
								{
									int rs25 = st.executeUpdate("update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll_2='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
									int rs26 = st.executeUpdate("update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll='"+s1roll.getText()+"'where roomid='"+s2room.getSelectedItem().toString()+"'");
									JOptionPane.showMessageDialog(null, "hello");
								}
							}
						}
						if(s1block.getSelectedItem().toString() == "B")
						{
							if(s2block.getSelectedItem().toString() == "A")
							{
								if(rs66.getString("roll").equals(s1roll.getText()))
								{
									int rs8 = st.executeUpdate("update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
									int rs9 = st.executeUpdate("update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll='"+s1roll.getText()+"'where roomid='"+s2room.getSelectedItem().toString()+"'");
								}
								if(rs66.getString("roll_2").equals(s1roll.getText()))
								{
									int rs10 = st.executeUpdate("update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
									int rs11 = st.executeUpdate("update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll_2='"+s1roll.getText()+"'where roomid='"+s2room.getSelectedItem().toString()+"'");
								}
							}
							if(s2block.getSelectedItem().toString() == "B")
							{
								if(rs66.getString("roll").equals(s1roll.getText()))
								{
									if(rs35.getString("roll_2").equals(s2roll.getText()))
									{
										int rs12 = st.executeUpdate("update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll_1='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
										int rs13 = st.executeUpdate("update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll='"+s1roll.getText()+"'where roomid='"+s2room.getSelectedItem().toString()+"'");
									}
									if(rs35.getString("roll").equals(s2roll.getText()))
									{
										int rs13 = st.executeUpdate("update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
										int rs14 = st.executeUpdate("update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll='"+s1roll.getText()+"'where roomid='"+s2room.getSelectedItem().toString()+"'");
									}
								}
								if(rs66.getString("roll_2").equals(s1roll.getText()))
								{
									if(rs35.getString("roll_2").equals(s2roll.getText()))
									{
										int rs15 = st.executeUpdate("update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll_1='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
										int rs16 = st.executeUpdate("update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll_1='"+s1roll.getText()+"'where roomid='"+s2room.getSelectedItem().toString()+"'");
									}
									if(rs35.getString("roll").equals(s2roll.getText()))
									{
										int rs17 = st.executeUpdate("update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll_1='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
										int rs18 = st.executeUpdate("update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll='"+s1roll.getText()+"'where roomid='"+s2room.getSelectedItem().toString()+"'");
									}
								}
							}
						}
					}
				}
				
				/*while(rs2.next())
				{
					while(rs11.next()) {
					String a = s1roll.getText(); 
					String s1=s2roll.getText();
					if(rs2.getString("roll").equals(a))
					{
						
						if(rs11.getString("roll_2").equals(s1))
						{
							int rs3 = st.executeUpdate("Update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll_2='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
							int rs14 = st.executeUpdate("Update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll='"+s1roll.getText()+"' where roomid='"+s2room.getSelectedItem().toString()+"'");
						}
						else
						{
						int rs3 = st.executeUpdate("Update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
						int rs14 = st.executeUpdate("Update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll='"+s1roll.getText()+"' where roomid='"+s2room.getSelectedItem().toString()+"'");
						}
						
					}
					else
					{
						
					}
					if(rs11.getString("roll_2").equals(a))
					{
						
						if(rs2.getString("roll").equals(s1))
						{
						int rs6 = st.executeUpdate("Update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll_2='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
						int rs7 = st.executeUpdate("Update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll_2='"+s1roll.getText()+"' where roomid='"+s2room.getSelectedItem().toString()+"'");
						}
						else
						{
							int rs5 = st.executeUpdate("Update yashdb.room set block='"+s2block.getSelectedItem().toString()+"',roll='"+s2roll.getText()+"' where roomid='"+s1room.getSelectedItem().toString()+"'");
							int rs4 = st.executeUpdate("Update yashdb.room set block='"+s1block.getSelectedItem().toString()+"',roll_2='"+s1roll.getText()+"' where roomid='"+s2room.getSelectedItem().toString()+"'");
						}
					}
				}
				}*/
				JOptionPane.showMessageDialog(null, "Swap Successfully");
				}
				catch(Exception ep)
				{
					// JOptionPane.showMessageDialog(null,ep.getMessage());
					ep.printStackTrace();
				}
			}
			});
		btnSwap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSwap.setBounds(524, 539, 103, 37);
		frame.getContentPane().add(btnSwap);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Main.main(null);
			}
		});
		btnBack.setBounds(52, 650, 103, 37);
		frame.getContentPane().add(btnBack);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
			Statement st  = con.createStatement();
			
			if(s1block.getSelectedItem().toString() == "A"&&s2block.getSelectedItem().toString() == "A")
			{
			ResultSet rs  = st.executeQuery("Select * from yashdb.room where status=1 And Roomid between 1 and 60 order by roomid");
			while(rs.next())
			{
				String str  = rs.getString("roomid");
				s1room.addItem(str);
				s2room.addItem(str);
			}
			}
			
		}
		catch(Exception ep)
		{
			 JOptionPane.showMessageDialog(null,ep.getMessage());
		}
		
		
	}

}
