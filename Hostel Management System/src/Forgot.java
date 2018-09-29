import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.plaf.PanelUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.*;

public class Forgot {

	private JFrame frame;
	private JTextField txtuser;
	private JTextField txtans1;
	private JTextField txtans2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot window = new Forgot();
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
	public Forgot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 681, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 35, 607, 336);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel label_10 = new JLabel("Password");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_10.setBounds(65, 112, 116, 14);
		panel.add(label_10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setColumns(10);
		passwordField.setBounds(212, 110, 285, 20);
		panel.add(passwordField);
		
		JLabel label_11 = new JLabel(":");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_11.setBounds(191, 113, 11, 14);
		panel.add(label_11);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField_1.setColumns(10);
		passwordField_1.setBounds(212, 147, 285, 20);
		panel.add(passwordField_1);
		
		JLabel label_12 = new JLabel(":");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_12.setBounds(191, 150, 11, 14);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("Re Password");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_13.setBounds(65, 149, 116, 14);
		panel.add(label_13);
		
		JLabel label = new JLabel("User ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(68, 57, 116, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Security Question 1");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(68, 97, 116, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Answer");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(68, 136, 116, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Security Question 2");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(68, 176, 116, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Answer");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(68, 211, 116, 14);
		frame.getContentPane().add(label_4);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtuser.setColumns(10);
		txtuser.setBounds(215, 55, 285, 20);
		frame.getContentPane().add(txtuser);
		
		JLabel label_5 = new JLabel(":");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(194, 58, 11, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel(":");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(194, 98, 11, 14);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel(":");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(194, 137, 11, 14);
		frame.getContentPane().add(label_7);
		
		txtans1 = new JTextField();
		txtans1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtans1.setColumns(10);
		txtans1.setBounds(215, 134, 285, 20);
		frame.getContentPane().add(txtans1);
		
		JLabel label_8 = new JLabel(":");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(194, 177, 11, 14);
		frame.getContentPane().add(label_8);
		
		txtans2 = new JTextField();
		txtans2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtans2.setColumns(10);
		txtans2.setBounds(215, 209, 285, 20);
		frame.getContentPane().add(txtans2);
		
		JLabel label_9 = new JLabel(":");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_9.setBounds(194, 212, 11, 14);
		frame.getContentPane().add(label_9);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What was your childhood nickname?", "Who is your childhood sports hero?"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(215, 95, 285, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"What is your favorite movie?", "What was your favorite sport in high school?"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setBounds(215, 174, 285, 20);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnSubmit2 = new JButton("Submit");
		btnSubmit2.setBounds(540, 345, 89, 23);
		frame.getContentPane().add(btnSubmit2);
		btnSubmit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("SELECT userid,a1,a2 FROM YASHDB.LOGIN WHERE USERID='"+txtuser.getText()+"'");
					rs.next();
					{
						if(txtuser.getText().equals(rs.getString("userid")))
						{
							if(txtans1.getText().equals(rs.getString("a1")))
							{
								if(txtans2.getText().equals(rs.getString("a2")))
								{
									panel.setVisible(true);
								}
							}
						}
					}
				}
				catch(Exception ep)
				{
					JOptionPane.showMessageDialog(null, ep.toString());
				}
			}
		});
	
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(passwordField.getText().equals(passwordField_1.getText()))
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st = con.createStatement();
					int rs = st.executeUpdate("UPDATE YASHDB.LOGIN SET PASSWORD='"+passwordField.getText()+"'");
					JOptionPane.showMessageDialog(null, "Password Changed.");
					panel.setVisible(false);
					passwordField.setText(null);
					passwordField_1.setText(null);
					txtans1.setText(null);
					txtans2.setText(null);
					txtuser.setText(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Password Not Match.");
						passwordField.setText(null);
						passwordField_1.setText(null);
					}
				}
				catch(Exception ep)
				{
					JOptionPane.showMessageDialog(null, ep.toString());
				}
			}
		});
		btnSubmit_1.setBounds(446, 240, 89, 23);
		panel.add(btnSubmit_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login.main(null);
			}
		});
		btnBack.setBounds(10, 388, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
