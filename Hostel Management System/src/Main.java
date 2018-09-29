import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;


public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 191, 255));
		frame.setBounds(100, 100, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		
		JLabel lblBoysHostel = new JLabel("Boys Hostel");
		lblBoysHostel.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblBoysHostel.setBounds(543, 11, 450, 125);
		frame.getContentPane().add(lblBoysHostel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(64, 141, 1233, 57);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBlock = new JLabel("Block");
		lblBlock.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblBlock.setBounds(10, 11, 111, 35);
		panel.add(lblBlock);
		
		JLabel lblABlock = new JLabel("A Block");
		lblABlock.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblABlock.setBounds(296, 11, 102, 35);
		panel.add(lblABlock);
		
		JLabel lblBBlock = new JLabel("B Block");
		lblBBlock.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblBBlock.setBounds(651, 11, 102, 35);
		panel.add(lblBBlock);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblTotal.setBounds(968, 11, 111, 35);
		panel.add(lblTotal);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(128, 128, 128));
		panel2.setBounds(64, 198, 1233, 214);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel lblEmptySingleSeats = new JLabel("Empty Single Seats");
		lblEmptySingleSeats.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmptySingleSeats.setBounds(10, 11, 176, 39);
		panel2.add(lblEmptySingleSeats);
		
		JLabel lblEmptyDoubleSeats = new JLabel("Empty Double Seats");
		lblEmptyDoubleSeats.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmptyDoubleSeats.setBounds(10, 85, 176, 39);
		panel2.add(lblEmptyDoubleSeats);
		
		JLabel lblRequests = new JLabel("Requests");
		lblRequests.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRequests.setBounds(10, 153, 176, 39);
		panel2.add(lblRequests);
		
		JLabel asingle = new JLabel("");
		asingle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		asingle.setBounds(296, 11, 194, 39);
		panel2.add(asingle);
		
		JLabel adouble = new JLabel("-");
		adouble.setFont(new Font("Tahoma", Font.PLAIN, 18));
		adouble.setBounds(296, 85, 194, 39);
		panel2.add(adouble);
		
		JLabel arequest = new JLabel("");
		arequest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		arequest.setBounds(296, 153, 194, 39);
		panel2.add(arequest);
		
		JLabel brequest = new JLabel("");
		brequest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		brequest.setBounds(651, 153, 194, 39);
		panel2.add(brequest);
		
		JLabel bdouble = new JLabel("");
		bdouble.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bdouble.setBounds(651, 85, 194, 39);
		panel2.add(bdouble);
		
		JLabel bsingle = new JLabel("-");
		bsingle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bsingle.setBounds(651, 11, 194, 39);
		panel2.add(bsingle);
		
		JLabel tsingle = new JLabel("");
		tsingle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tsingle.setBounds(975, 11, 194, 39);
		panel2.add(tsingle);
		
		JLabel tdouble = new JLabel("");
		tdouble.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tdouble.setBounds(975, 85, 194, 39);
		panel2.add(tdouble);
		
		JLabel trequest = new JLabel("");
		trequest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		trequest.setBounds(975, 153, 194, 39);
		panel2.add(trequest);
		
		JButton btnAllotNewSeat = new JButton("Allot New Seat");
		btnAllotNewSeat.setBackground(Color.WHITE);
		btnAllotNewSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				AllotNewSeat.main(null);
			}
		});
		btnAllotNewSeat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAllotNewSeat.setBounds(64, 453, 322, 57);
		frame.getContentPane().add(btnAllotNewSeat);
		
		JButton btnSwapSeats = new JButton("Swap Seats");
		btnSwapSeats.setBackground(Color.WHITE);
		btnSwapSeats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				swap.main(null);
			}
		});
		btnSwapSeats.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSwapSeats.setBounds(975, 453, 322, 57);
		frame.getContentPane().add(btnSwapSeats);
		
		JButton btnShiftToEmpty = new JButton("Shift to Empty Seats");
		btnShiftToEmpty.setBackground(Color.WHITE);
		btnShiftToEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				shift_empty.main(null);
			}
		});
		btnShiftToEmpty.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnShiftToEmpty.setBounds(64, 543, 322, 57);
		frame.getContentPane().add(btnShiftToEmpty);
		
		JButton btnMakeRequestFor = new JButton("Make Request For Room");
		btnMakeRequestFor.setBackground(Color.WHITE);
		btnMakeRequestFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Make_Request.main(null);
			}
		});
		btnMakeRequestFor.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMakeRequestFor.setBounds(523, 542, 322, 57);
		frame.getContentPane().add(btnMakeRequestFor);
		
		JButton btnPendingRequests = new JButton("Pending Requests");
		btnPendingRequests.setBackground(Color.WHITE);
		btnPendingRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Show_request.main(null);
			}
		});
		btnPendingRequests.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPendingRequests.setBounds(975, 543, 322, 57);
		frame.getContentPane().add(btnPendingRequests);
		
		JButton btnSearchStudent = new JButton("Search Student");
		btnSearchStudent.setBackground(Color.WHITE);
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Search_student.main(null);
			}
		});
		btnSearchStudent.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearchStudent.setBounds(523, 453, 322, 57);
		frame.getContentPane().add(btnSearchStudent);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
			Statement st  = con.createStatement();
			ResultSet rs  = st.executeQuery("Select Status from yashdb.room where status=0 And Roomid between 1 and 60");
			int c = 0; 
			while(rs.next())
			{
				c++;
			}
			asingle.setText(String.valueOf(c));
			tsingle.setText(String.valueOf(c));
			
			ResultSet rs1  = st.executeQuery("Select Status from yashdb.room where status<2 And Roomid between 61 and 90");
			int b = 0; 
			while(rs1.next())
			{
				b++;
			}
			bdouble.setText(String.valueOf(b));
			tdouble.setText(String.valueOf(b));
			
			ResultSet rs3 = st.executeQuery("select *from yashdb.request");
			int ap=0,ac=0;
			while(rs3.next())
			{
				if(rs3.getString("block").equals("A"))
				{
					ap++;	
				}
				if(rs3.getString("block").equals("B"))
				{
					ac++;	
				}
			}
			int as = ap+ac;
			arequest.setText(String.valueOf(ap));
			brequest.setText(String.valueOf(ac));
			trequest.setText(String.valueOf(as));
		}
		catch(Exception ep)
		{
			 JOptionPane.showMessageDialog(null,ep.getMessage());
		}
	}
}
