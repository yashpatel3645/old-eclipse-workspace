import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.lang.model.type.ErrorType;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Dashboard {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Dashboard() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 767, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Register.main(null);
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCreateAccount.setBounds(72, 398, 168, 43);
		frame.getContentPane().add(btnCreateAccount);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st  = con.createStatement();
					ResultSet rs = st.executeQuery("Select password from YASHDB.Login where username='"+textField.getText()+"'");
					rs.next();
					if(textField_1.getText().equals(rs.getString(1)))
					{
						frame.setVisible(false);
						Main.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "User Id or Password is Wrong.","Invalid Username or Password.",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e)
				{
					
					JOptionPane.showMessageDialog(null,e.toString());
				}
			}
		});
		btnLogin.setBounds(536, 398, 168, 43);
		frame.getContentPane().add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(272, 136, 234, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(272, 202, 234, 34);
		frame.getContentPane().add(textField_1);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUserName.setBounds(130, 136, 110, 34);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password   :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(130, 202, 110, 34);
		frame.getContentPane().add(lblPassword);
	}
}
