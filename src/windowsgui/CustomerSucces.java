package windowsgui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dao.ItemDao;
import dao.StoreDao;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;

import backend.Admin;
import backend.Customer;
import backend.Item;
import backend.Store;

public class CustomerSucces {

	private JFrame frame;
	public ArrayList<Item> Items;
	public String[] listItems = new String[] { "Select your search preference" };;
	public int i = 0;
	public JList JList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSucces window = new CustomerSucces();
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
	public CustomerSucces() {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 556, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// setting location name to the scroll down list
		Object[] locations = StoreDao.storelocations().toArray();
		JComboBox comboBox = new JComboBox(locations);
		comboBox.setBounds(10, 7, 117, 27);
		frame.getContentPane().add(comboBox);

		// Suggest store to the shopper
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(295, 11, 225, 27);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_2 = new JButton("Nearest Store:");
		btnNewButton_2.setBounds(143, 9, 122, 25);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String location = comboBox.getSelectedItem().toString();
				String store = StoreDao.getStoreName(location);
				lblNewLabel_1.setText(store);
				for (Customer c : Admin.customers) {
					if (c.isLoggedIn) {
						c.setPreferredStore(store);
					}
				}

			}
		});

		JRadioButton btncategory = new JRadioButton("Category");
		btncategory.setBounds(6, 57, 82, 23);
		frame.getContentPane().add(btncategory);

		JRadioButton btnname = new JRadioButton("Item name");
		btnname.setBounds(175, 57, 109, 23);
		frame.getContentPane().add(btnname);

		JRadioButton btnall = new JRadioButton("Show All");
		btnall.setBounds(338, 57, 82, 27);
		frame.getContentPane().add(btnall);

		ButtonGroup G = new ButtonGroup();
		G.add(btnall);
		G.add(btnname);
		G.add(btncategory);

		JLabel lblNewLabel_2 = new JLabel("Search Item by:");
		lblNewLabel_2.setBounds(10, 45, 109, 14);
		frame.getContentPane().add(lblNewLabel_2);

		// category selection
		Object[] categories = ItemDao.itemCategories().toArray();
		JComboBox categoryScroll = new JComboBox(categories);
		categoryScroll.setBounds(10, 87, 103, 27);
		frame.getContentPane().add(categoryScroll);

		// by name selection
		JTextField textField = new JTextField();
		textField.setBounds(161, 87, 104, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// creating the scrollPane and JList

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(58, 135, 275, 135);
		frame.getContentPane().add(scrollPane);

		JList = new JList(listItems);
		scrollPane.setViewportView(JList);

		// Array variables to load

		// Now Go!
		JButton btnGo = new JButton("Go!");
		btnGo.setBounds(424, 57, 69, 23);
		frame.getContentPane().add(btnGo);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// List of Items
				if (btncategory.isSelected()) {

					Items = Store.itemlistCategory(categoryScroll.getSelectedItem().toString());
					listItems = ItemDao.toStringItemDetailCategory(categoryScroll.getSelectedItem().toString());
					JList.setListData(listItems);
					i = 1;

				} else if (btnname.isSelected()) {

					Items = Store.itemlistName(textField.getText());
					listItems = ItemDao.toStringItemDetailName(textField.getText());
					JList.setListData(listItems);
 
					i = 2;

				} else if (btnall.isSelected()) {

					Items = Store.items;
					listItems = Store.itemlisttoString(Items);
					JList.setListData(listItems);
					i = 3;

				}

			}
		});

		JButton btnNewButton = new JButton("Suggested Items");
		btnNewButton.setBounds(360, 133, 160, 27);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewSaleItems.main(new String[] {}); 
				//frame.dispose();
			}
		});
		

		// LOGOUT BUTTON
		JButton btnNewButton_1 = new JButton("logout");
		btnNewButton_1.setBounds(392, 256, 82, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Customer c : Admin.customers) {
					if (c.isLoggedIn) {
						c.isLoggedIn = false;
					}
				}
				CustomerLogin.main(new String[] {}); 
				frame.dispose();
			}
		});
		// VIEW SHOPPING LIST
		JButton btnNewButton_3 = new JButton("View Shopping List");
		btnNewButton_3.setBounds(360, 167, 160, 27);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewShoppingList.main(new String[] {});
			}
		});

		// ADD TO CART BUTTON
		JButton btnNewButton_4 = new JButton("Add to Cart");
		btnNewButton_4.setBounds(360, 205, 160, 27);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				int index = JList.getSelectedIndex();
				Item t = Items.get(index);
				for (Customer c : Admin.customers) {
					if (c.isLoggedIn) {
						c.addtoCart(t);
						
					}
				}
				JOptionPane.showMessageDialog(null, "Item: " + t.getName() + " added to your shopping list!");

			}
		});

	}
}
