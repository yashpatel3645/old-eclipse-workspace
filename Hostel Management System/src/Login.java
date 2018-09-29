import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login {

	private JFrame frame;
	private JTextField txtuser;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.setBounds(100, 100, 681, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID ");
		lblUserId.setBackground(new Color(128, 128, 128));
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUserId.setBounds(178, 143, 81, 27);
		frame.getContentPane().add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBackground(new Color(128, 128, 128));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(178, 203, 97, 27);
		frame.getContentPane().add(lblPassword);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(303, 152, 10, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(303, 212, 10, 14);
		frame.getContentPane().add(label_1);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtuser.setBounds(323, 143, 207, 27);
		frame.getContentPane().add(txtuser);
		txtuser.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpass.setBounds(323, 203, 207, 27);
		frame.getContentPane().add(txtpass);
			
		JButton Register = new JButton("Register");
		Register.setBackground(Color.WHITE);
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Registration.main(null);
			}
		});
		Register.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Register.setBounds(82, 304, 97, 42);
		frame.getContentPane().add(Register);
		
		JButton Forgot_pass = new JButton("Forgot Password");
		Forgot_pass.setBackground(Color.WHITE);
		Forgot_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Forgot.main(null);
			}
		});
		Forgot_pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Forgot_pass.setBounds(245, 304, 148, 42);
		frame.getContentPane().add(Forgot_pass);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBackground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(558, 11, 97, 42);
		frame.getContentPane().add(btnExit);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","yash");
					Statement st  = con.createStatement();
					ResultSet rs = st.executeQuery("Select password from YASHDB.Login where userid='"+txtuser.getText()+"'");
					rs.next();
					if(txtpass.getText().equals(rs.getString(1)))
					{
						frame.setVisible(false);
						Main.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "User Id or Password is Wrong.","Invalid Username or Password.",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception ep)
				{
					JOptionPane.showMessageDialog(null,ep.toString());
				}
			}
		});
		btnLogin.setBounds(461, 304, 97, 42);
		frame.getContentPane().add(btnLogin);
	}
}
