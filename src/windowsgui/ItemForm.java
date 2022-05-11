package windowsgui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Item;
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

public class ItemForm extends JFrame {
	static ItemForm frame;
	private JPanel contentPane;
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
					frame = new ItemForm();
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
	public ItemForm() {
		boolean added= false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddLibrarian = new JLabel("Add Item");
		lblAddLibrarian.setForeground(Color.DARK_GRAY);
		
		lblAddLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblName = new JLabel("Item ID:");
		
		JLabel lblPassword = new JLabel("Name:");
		
		JLabel lblEmail = new JLabel("Category:");
		
		JLabel lblAddress = new JLabel("Price:");
		
		JLabel lblCity = new JLabel("Quantity:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			int id=Integer.parseInt(textField.getText());
			String name=textField_4.getText();
			String category=textField_1.getText();
			int price=Integer.parseInt(textField_2.getText());
			int quantity=Integer.parseInt(textField_3.getText());
			String description = textField_5.getText();
			
			//BACKEND LOGIC
			Store s= new Store();
			Item t = new Item(id, name, category, price,  quantity,  description);
			int i= s.addItem(t);
			
			if(i>0){
				JOptionPane.showMessageDialog(ItemForm.this,"Item added successfully!");
				Landing.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(ItemForm.this,"Sorry, unable to add item!");
			}
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Landing.main(new String[]{});
			frame.dispose();
			}
		});
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(204, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(169))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
							.addComponent(lblName))
						.addComponent(lblEmail, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
						.addComponent(lblCity, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField_4)
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(147))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(166)
					.addComponent(lblAddLibrarian)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddLibrarian)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblName)
							.addGap(18)
							.addComponent(lblPassword))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
