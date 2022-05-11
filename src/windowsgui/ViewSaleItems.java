package windowsgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import backend.Admin;
import backend.Customer;
import backend.Item;
import backend.Store;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class ViewSaleItems {

	private JFrame frame;
	private JTextField textField;
	public JList JList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSaleItems window = new ViewSaleItems();
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
	public ViewSaleItems() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(45, 86, 344, 120);
		frame.getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Go Back!");
		btnNewButton.setBounds(339, 232, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Recommended Items: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 35, 173, 40);
		frame.getContentPane().add(lblNewLabel);
		
		ArrayList<Item> items = new ArrayList<Item>();
		for(Item t: Store.items) {
			if(t.isSaleItem()) {
				items.add(t);
			}
		}
		String [] s = Store.itemlisttoString(items);
		JList = new JList(s);
		scrollPane.setViewportView(JList);
		
		
		
	
	}
}
