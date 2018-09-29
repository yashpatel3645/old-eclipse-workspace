package first;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSpinner;

public class Yash {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JLabel textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yash window = new Yash();
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
	public Yash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblShoePalace = new JLabel("Shoe Palace");
		lblShoePalace.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblShoePalace.setBounds(10, 0, 1274, 54);
		frame.getContentPane().add(lblShoePalace);
		
		JLabel lblAddressAbc = new JLabel("Address: Abc");
		lblAddressAbc.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAddressAbc.setBounds(10, 50, 394, 33);
		frame.getContentPane().add(lblAddressAbc);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(10, 120, 394, 20);
		frame.getContentPane().add(lblProductName);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setBounds(408, 120, 62, 20);
		frame.getContentPane().add(lblQty);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(475, 120, 81, 20);
		frame.getContentPane().add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(10, 151, 394, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(470, 151, 86, 27);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total Price: ");
		lblTotal.setBounds(408, 189, 72, 20);
		frame.getContentPane().add(lblTotal);
		
		textField_3 = new JLabel();
		textField_3.setBounds(480, 189, 86, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_3.setText(textField_2.getText());
			}
		});
		btnSubmit.setBounds(357, 290, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(404, 151, 66, 27);
		frame.getContentPane().add(spinner);
	}
}
