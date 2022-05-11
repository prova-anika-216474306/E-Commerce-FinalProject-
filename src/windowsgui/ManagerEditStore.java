package windowsgui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backend.Admin;
import backend.Manager;

import javax.swing.JButton;

public class ManagerEditStore {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerEditStore window = new ManagerEditStore();
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
	public ManagerEditStore() {
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
		
		
		Admin admin = new Admin();
		Object[] objectList = admin.toStringStoreNames();
		
		JLabel lblNewLabel = new JLabel("Opening Hour");
		lblNewLabel.setBounds(81, 80, 84, 19);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblClosingHour = new JLabel("Closing Hour");
		lblClosingHour.setBounds(81, 110, 84, 25);
		frame.getContentPane().add(lblClosingHour);
		
		
		textField = new JTextField();
		textField.setBounds(175, 77, 116, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(175, 110, 116, 25);
		frame.getContentPane().add(textField_1);
		
		
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(162, 178, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opening = textField.getText(); 
				String closing = textField_1.getText(); 
				
				String currentStore = null;
				int i =0;
				for(Manager m: admin.managers) {
					if(m.isLoggedIn()) {
						currentStore = m.getShop().getName();
						m.changeHours(opening, closing);
						JOptionPane.showMessageDialog(null, "Store editted successfully!");
						
					}
				}
		}
	
				
			
		});
		
		JLabel lblNewLabel_1 = new JLabel("You are Managing Store:");
		lblNewLabel_1.setBounds(74, 19, 141, 30);
		
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(223, 19, 105, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		String currentStore = "";
		for(Manager m: admin.managers) {
			if(m.isLoggedIn) {
				currentStore = m.getShop().getName();
			}
			
		}
		
		lblNewLabel_1_1.setText(currentStore);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(339, 232, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		

		
		
	}
}
