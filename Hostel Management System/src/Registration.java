import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField txtuser;
	private JPasswordField txtpass;
	private JPasswordField txtpass2;
	private JTextField txtans1;
	private JTextField txtans2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
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
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserId.setBounds(64, 89, 116, 14);
		frame.getContentPane().add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(64, 128, 116, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblRePassword = new JLabel("Re Password");
		lblRePassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRePassword.setBounds(64, 165, 116, 14);
		frame.getContentPane().add(lblRePassword);
		
		JLabel lblSequrityQuetion = new JLabel("Security Question 1");
		lblSequrityQuetion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSequrityQuetion.setBounds(64, 202, 116, 14);
		frame.getContentPane().add(lblSequrityQuetion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAnswer.setBounds(64, 241, 116, 14);
		frame.getContentPane().add(lblAnswer);
		
		JLabel lblSequrityQuetion_1 = new JLabel("Security Question 2");
		lblSequrityQuetion_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSequrityQuetion_1.setBounds(64, 281, 116, 14);
		frame.getContentPane().add(lblSequrityQuetion_1);
		
		JLabel lblAnswer_1 = new JLabel("Answer");
		lblAnswer_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAnswer_1.setBounds(64, 316, 116, 14);
		frame.getContentPane().add(lblAnswer_1);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtuser.setBounds(211, 87, 285, 20);
		frame.getContentPane().add(txtuser);
		txtuser.setColumns(10);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(190, 90, 11, 14);
		frame.getContentPane().add(label);
		
		txtpass = new JPasswordField();
		txtpass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpass.setColumns(10);
		txtpass.setBounds(211, 126, 285, 20);
		frame.getContentPane().add(txtpass);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(190, 129, 11, 14);
		frame.getContentPane().add(label_1);
		
		txtpass2 = new JPasswordField();
		txtpass2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpass2.setColumns(10);
		txtpass2.setBounds(211, 163, 285, 20);
		frame.getContentPane().add(txtpass2);
		
		JLabel label_2 = new JLabel(":");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(190, 166, 11, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(":");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(190, 203, 11, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel(":");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(190, 242, 11, 14);
		frame.getContentPane().add(label_4);
		
		txtans1 = new JTextField();
		txtans1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtans1.setColumns(10);
		txtans1.setBounds(211, 239, 285, 20);
		frame.getContentPane().add(txtans1);
		
		JLabel label_5 = new JLabel(":");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(190, 282, 11, 14);
		frame.getContentPane().add(label_5);
		
		txtans2 = new JTextField();
		txtans2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtans2.setColumns(10);
		txtans2.setBounds(211, 314, 285, 20);
		frame.getContentPane().add(txtans2);
		
		JLabel label_6 = new JLabel(":");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(190, 317, 11, 14);
		frame.getContentPane().add(label_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What was your childhood nickname?", "Who is your childhood sports hero?"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(211, 200, 285, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"What is your favorite movie?", "What was your favorite sport in high school?"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(211, 279, 285, 20);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtpass.getText().equals(txtpass2.getText()))
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st = con.createStatement();
					int rs = st.executeUpdate("INSERT INTO YASHDB.LOGIN(USERID,PASSWORD,Q1,A1,Q2,A2) VALUES ('"+txtuser.getText()+"','"+txtpass.getText()+"','"+comboBox.getSelectedItem().toString()+"','"+txtans1.getText()+"','"+comboBox_1.getSelectedItem().toString()+"','"+txtans2.getText()+"')");
					JOptionPane.showMessageDialog(null,"Registraion Successfully");
					txtans1.setText(null);
					txtans2.setText(null);
					txtpass.setText(null);
					txtpass2.setText(null);
					txtuser.setText(null);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Password Not match.");
						txtpass2.setText(null);
						txtpass.setText(null);
					}
				}
				catch(Exception ep)
				{
					JOptionPane.showMessageDialog(null,ep.toString());
					
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSubmit.setBounds(543, 368, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login.main(null);
			}
		});
		btnBack.setBounds(10, 369, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
