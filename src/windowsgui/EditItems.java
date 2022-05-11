package windowsgui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import backend.Admin;
import backend.Item;
import backend.Store;
import dao.StoreDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class EditItems {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditItems window = new EditItems();
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
	public EditItems() {
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
		
Store store = new Store();
Object[] objectList = store.itemIdInteger();

		
		
		
		JLabel lblNewLabel = new JLabel("Select Item ID:");
		lblNewLabel.setBounds(74, 28, 98, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item Name");
		lblNewLabel_1.setBounds(74, 103, 71, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Category");
		lblNewLabel_1_1.setBounds(74, 130, 71, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setBounds(74, 155, 71, 17);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Quantity");
		lblNewLabel_1_2_1.setBounds(74, 183, 71, 11);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Description");
		lblNewLabel_1_3.setBounds(74, 205, 71, 19);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(148, 101, 134, 18);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 129, 134, 16);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(148, 153, 134, 16);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(148, 183, 134, 16);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(148, 208, 134, 16);
		frame.getContentPane().add(textField_4);
		
		JComboBox comboBox = new JComboBox(objectList);
		comboBox.setBounds(182, 24, 134, 32);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(303, 165, 101, 24);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText(); 
				String category = textField_1.getText();
				int price = Integer.parseInt(textField_2.getText());
				int quantity = Integer.parseInt(textField_3.getText());
				String description = textField_4.getText();
				
				Store s= new Store();
				Integer id= (Integer) comboBox.getSelectedItem();
				Item t = s.getItem(id);  
				t.UpdateItem(name, category, price, quantity, description);
				JOptionPane.showMessageDialog(null, "Item: " +comboBox.getSelectedItem()+ " editted successfully!");
			}
		});
		
		JButton btnAddToSale = new JButton("Add to Sale");
		btnAddToSale.setBounds(303, 126, 101, 24);
		frame.getContentPane().add(btnAddToSale);
		btnAddToSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Store s= new Store();
				Integer id= (Integer) comboBox.getSelectedItem();
				Item t = s.getItem(id);  
				s.addtoSale(t);
				 
				JOptionPane.showMessageDialog(null, "Item: " +comboBox.getSelectedItem()+ " listed for Sales!");
			}
		});
	}
}
