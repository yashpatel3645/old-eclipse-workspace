package bill_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import shoes.Shoe;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import afterlogin.A_Login;
import javax.swing.SpinnerNumberModel;

public class Tbill {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tbill window = new Tbill();
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
	public Tbill() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductName.setBounds(10, 11, 284, 21);
		frame.getContentPane().add(lblProductName);
		
		JLabel lblQty = new JLabel("QTY");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQty.setBounds(296, 11, 46, 21);
		frame.getContentPane().add(lblQty);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice.setBounds(352, 11, 169, 21);
		frame.getContentPane().add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(10, 107, 284, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner.setBounds(296, 107, 46, 21);
		frame.getContentPane().add(spinner);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(352, 107, 68, 21);
		frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 139, 284, 21);
		frame.getContentPane().add(textField_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner_1.setBounds(296, 139, 46, 21);
		frame.getContentPane().add(spinner_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(352, 139, 68, 21);
		frame.getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 171, 284, 21);
		frame.getContentPane().add(textField_2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner_2.setBounds(296, 171, 46, 21);
		frame.getContentPane().add(spinner_2);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(352, 171, 68, 21);
		frame.getContentPane().add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 203, 284, 21);
		frame.getContentPane().add(textField_3);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner_3.setBounds(296, 203, 46, 21);
		frame.getContentPane().add(spinner_3);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(352, 203, 68, 21);
		frame.getContentPane().add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 43, 284, 21);
		frame.getContentPane().add(textField_4);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner_4.setBounds(296, 43, 46, 21);
		frame.getContentPane().add(spinner_4);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(352, 43, 68, 21);
		frame.getContentPane().add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 75, 284, 21);
		frame.getContentPane().add(textField_5);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner_5.setBounds(296, 75, 46, 21);
		frame.getContentPane().add(spinner_5);
		
		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(352, 75, 68, 21);
		frame.getContentPane().add(label_5);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalPrice.setBounds(274, 252, 68, 21);
		frame.getContentPane().add(lblTotalPrice);
		
		JLabel label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(352, 252, 68, 21);
		frame.getContentPane().add(label_6);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiscount.setBounds(274, 287, 68, 21);
		frame.getContentPane().add(lblDiscount);
		
		JLabel label_7 = new JLabel("8%");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(352, 287, 68, 21);
		frame.getContentPane().add(label_7);
		
		JLabel lblPaidPrice = new JLabel("Paid Price");
		lblPaidPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPaidPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPaidPrice.setBounds(274, 319, 68, 21);
		frame.getContentPane().add(lblPaidPrice);
		
		JLabel label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(352, 319, 68, 21);
		frame.getContentPane().add(label_8);
		
		JButton btnGetTotal = new JButton("Get Total");
		btnGetTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGetTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGetTotal.setBounds(352, 413, 89, 23);
		frame.getContentPane().add(btnGetTotal);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrint.setBounds(533, 413, 89, 23);
		frame.getContentPane().add(btnPrint);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A_Login.main(null);
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(26, 412, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
