package windowsgui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Admin;
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
import java.awt.event.ActionEvent;

public class ManagerForm extends JFrame {
	static ManagerForm frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ManagerForm();
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
	public ManagerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddManager = new JLabel("Add Manager");
		lblAddManager.setForeground(Color.DARK_GRAY);
		lblAddManager.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblPassword = new JLabel("Password:");
		
		JLabel lblEmail = new JLabel("Email:");
		
		JLabel lblAddress = new JLabel("Location:");
		
		JLabel lblShop = new JLabel("Shop:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnNewButton = new JButton("Add Manager");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			String email=textField_1.getText();
			String location=textField_2.getText();
			String shop=textField_4.getText();
			String ManagerID=textField_3.getText(); 
			
			
			Admin admin = new Admin();
			Manager m = new Manager(Integer.valueOf(ManagerID), name, email, password, location, Admin.getStore(textField_4.getText()));
			int i = admin.addManager(m);
			
			if(i>0){
				JOptionPane.showMessageDialog(ManagerForm.this,"Manager added successfully!");
				AdminSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(ManagerForm.this,"Sorry, unable to save!");
			} 
			}
	
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminSuccess.main(new String[]{});
			frame.dispose();
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblManagerId = new JLabel("ManagerID:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addComponent(lblName)
						.addComponent(lblAddress)
						.addComponent(lblShop, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblManagerId, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textField_4)
							.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addComponent(passwordField, Alignment.LEADING)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(158, Short.MAX_VALUE)
					.addComponent(lblAddManager, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(127))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(166, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(132))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(203, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(171))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddManager, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddress))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblShop, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblManagerId))
					.addGap(34)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnBack)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
