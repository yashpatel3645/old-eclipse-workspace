import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Make_Request {

	private JFrame frame;
	private JTextField name;
	private JTextField contect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Make_Request window = new Make_Request();
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
	public Make_Request() {
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
		
		JLabel lblMakeARequest = new JLabel("Make A Request For Room");
		lblMakeARequest.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblMakeARequest.setBounds(428, 118, 438, 54);
		frame.getContentPane().add(lblMakeARequest);
		
		JLabel lblBlock = new JLabel("Block");
		lblBlock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBlock.setBounds(253, 253, 72, 25);
		frame.getContentPane().add(lblBlock);
		
		JComboBox block = new JComboBox();
		block.setFont(new Font("Tahoma", Font.PLAIN, 15));
		block.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
		block.setBounds(359, 253, 259, 25);
		frame.getContentPane().add(block);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(253, 316, 72, 25);
		frame.getContentPane().add(lblName);
		
		name = new JTextField();
		name.setBounds(359, 313, 259, 25);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblContect = new JLabel("Contect");
		lblContect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContect.setBounds(253, 370, 72, 25);
		frame.getContentPane().add(lblContect);
		
		contect = new JTextField();
		contect.setBounds(359, 374, 259, 25);
		frame.getContentPane().add(contect);
		contect.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st  = con.createStatement();
					ResultSet rs1 = st.executeQuery("select * from yashdb.request");
					int c = 0;
					while(rs1.next())
					{
						c++;
					}
					c +=1;
					int rs = st.executeUpdate("insert into yashdb.request(Request_no,block,name,contect) values('"+c+"','"+block.getSelectedItem().toString()+"','"+name.getText()+"','"+contect.getText()+"')");
					JOptionPane.showMessageDialog(null, "Request Submited.");
				}
				catch(Exception ep)
				{
					 JOptionPane.showMessageDialog(null,ep.getMessage());
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(703, 492, 107, 39);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Main.main(null);
			}
		});
		btnBack.setBounds(86, 646, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
