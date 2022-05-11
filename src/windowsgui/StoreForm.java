package windowsgui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import backend.Admin;
import backend.Store;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_1_2;
	private JButton btnNewButton_1;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreForm window = new StoreForm();
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
	public StoreForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(189, 11, 115, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Store Name:");
		lblNewLabel.setBounds(64, 11, 104, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Opening Hour:");
		lblNewLabel_1.setBounds(64, 37, 104, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Location:");
		lblNewLabel_1_1.setBounds(64, 105, 104, 39);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 45, 115, 23);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(189, 148, 115, 23);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Add Store");
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			int i = 0;
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String opening=textField_1.getText();
			String location=textField_2.getText();
			String closing=textField_3.getText();
			String address=textField_4.getText();
			
			
			Admin admin = new Admin();
			Store store = new Store(name, opening, closing, location);
			admin.addStore(store);
			
			
			if(name.equals("") || opening.equals("") || closing.equals("") || location.equals("") ) {
				i=0;
				JOptionPane.showMessageDialog(btnNewButton, StoreForm.this,"Sorry, unable to add Store!", 0);
				StoreForm.main(new String[]{});
				frame.dispose();
			}
				
			else{
				JOptionPane.showMessageDialog(btnNewButton, StoreForm.this,"Store added successfully!", 1);
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}
			}
		});
		btnNewButton.setBounds(164, 214, 115, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(189, 79, 115, 23);
		frame.getContentPane().add(textField_3);
		
		lblNewLabel_1_2 = new JLabel("Closing Hour:");
		lblNewLabel_1_2.setBounds(64, 74, 104, 33);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(361, 232, 67, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address:");
		lblNewLabel_1_1_1.setBounds(64, 140, 104, 39);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(189, 114, 115, 23);
		frame.getContentPane().add(textField_4);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}
		});
	}
}
