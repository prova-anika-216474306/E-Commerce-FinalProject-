package windowsgui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Admin;
import backend.Manager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.*;

public class ManagerSuccess extends JFrame {
	static ManagerSuccess frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ManagerSuccess();
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
	public ManagerSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblManagerSection = new JLabel("Manager Section");
		lblManagerSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblManagerSection.setForeground(Color.GRAY);
		
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
		
	
		JButton btnEditSaleItem = new JButton("Edit Items");
		btnEditSaleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			EditItems.main(new String[]{});
			
			}
		});
		btnEditSaleItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Manager m: Admin.managers) {
					if(m.isLoggedIn==true) {
						m.isLoggedIn = false; 
					}
				}
				ManagerLogin.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		JButton btnEditStoreHours = new JButton("Edit Store Hours");
		btnEditStoreHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerEditStore.main(new String[]{});
				
			}
		});
		
		btnEditStoreHours.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnEditStoreHours, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnEditSaleItem, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAddItem, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnDeleteItem, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(113)
							.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(128, Short.MAX_VALUE)
					.addComponent(lblManagerSection, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addGap(85))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblManagerSection, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddItem, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteItem, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditSaleItem, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditStoreHours, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
