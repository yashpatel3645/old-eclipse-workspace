package afterlogin;

import java.awt.EventQueue;

import javax.swing.JFrame;

import bill_1.Tbill;
import shoes.Shoe;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class A_Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Login window = new A_Login();
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
	public A_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewBill = new JButton("New Bill");
		btnNewBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tbill.main(null);
				frame.setVisible(false);
			}
		});
		btnNewBill.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewBill.setBounds(39, 63, 89, 23);
		frame.getContentPane().add(btnNewBill);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shoe.main(null);
				frame.setVisible(false);
			}
		});
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddProduct.setBounds(200, 63, 128, 23);
		frame.getContentPane().add(btnAddProduct);
	}
}
