package windowsgui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Admin;
import backend.Customer;
import backend.Manager;
import backend.Store;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class CustomerSignUp extends JFrame {
	static CustomerSignUp frame;
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CustomerSignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerSignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddManager = new JLabel("Sign Up");
		lblAddManager.setForeground(Color.DARK_GRAY);
		lblAddManager.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblPassword = new JLabel("Password:");
		
		JLabel lblEmail = new JLabel("Email:");
		
		JLabel lblAddress = new JLabel("Location:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			String email=textField_4.getText();
			String location=textField_2.getText();
	
			Random rand = new Random();
			int i = rand.nextInt(100);
			Customer c = new Customer(i, name, email, password, location);
			c.signUp();
			
			if(i>0){
				JOptionPane.showMessageDialog(CustomerSignUp.this,"WELCOME TO SHOPPERS INC!");
				CustomerLogin.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(CustomerSignUp.this,"Sorry, try again!");
			}
			}
	
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CustomerLogin.main(new String[]{});
			frame.dispose();
			}
		});
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblName)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addGap(23))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(passwordField)
									.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
									.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
								.addGap(84))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(btnBack)
								.addGap(175)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(141))))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(142)
					.addComponent(lblAddManager, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(142, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddManager, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(79)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBack)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
