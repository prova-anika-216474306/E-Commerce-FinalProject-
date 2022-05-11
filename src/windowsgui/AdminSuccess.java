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

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.*;
public class AdminSuccess extends JFrame {
	static AdminSuccess frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminSuccess();
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
	public AdminSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAdminSection = new JLabel("Administrator Section");
		lblAdminSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAdminSection.setForeground(Color.GRAY);
		
		JButton btnNewManager = new JButton("Add Manager");
		btnNewManager.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ManagerForm.main(new String[]{});
			frame.dispose();
			}
		});
		
		
		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ItemDelete.main(new String[]{});
			}
		});
		btnDeleteItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ItemForm.main(new String[]{}); 
			}
		});
		btnAddItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
	
		JButton btnEditSaleItem = new JButton("Edit Store");
		btnEditSaleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminEditStore.main(new String[]{});
			frame.dispose();
			}
		});
		btnEditSaleItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Landing.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
	
		
		JButton btnDeleteManager = new JButton("Delete Manager");
		btnDeleteManager.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteManager.main(new String[]{});
			frame.dispose();
			}
		});
		
		btnDeleteManager.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnAddStore = new JButton("Add Store");
		btnAddStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreForm.main(new String[]{});
				frame.dispose();
			}
		});
		btnAddStore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnDeleteStore = new JButton("Delete Store");
		btnDeleteStore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			StoreDelete.main(new String[]{});
			frame.dispose();
			}
		});
		
		btnDeleteStore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnEditSaleItem_1 = new JButton("Edit Items");
		btnEditSaleItem_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditSaleItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditItems.main(new String[]{});
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnAddItem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewManager, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnDeleteManager, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDeleteItem, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
							.addContainerGap(48, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
							.addGap(96))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEditSaleItem, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(btnAddStore, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDeleteStore, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditSaleItem_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
					.addGap(46))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(161)
					.addComponent(btnLogout)
					.addContainerGap(190, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewManager, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteManager, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnDeleteItem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddItem, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnDeleteStore, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddStore, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditSaleItem, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditSaleItem_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
