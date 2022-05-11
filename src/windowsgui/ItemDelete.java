package windowsgui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Admin;
import backend.Item;
import backend.Store;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemDelete extends JFrame {
	static ItemDelete frame;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ItemDelete();
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
	public ItemDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterId = new JLabel("Enter Item Id:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=textField.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(ItemDelete.this,"Id can't be blank");
				}else{
					//BACKEND LOGIC
					int id=Integer.parseInt(sid);
					
					Store store = new Store();
					int i=store.removeItem(id);
					if(i>0){
						JOptionPane.showMessageDialog(ItemDelete.this,"Item deleted successfully!");
					}else{
						JOptionPane.showMessageDialog(ItemDelete.this,"Unable to delete given id!");
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Landing.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(lblEnterId, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(179, Short.MAX_VALUE)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(140))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(326, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		); 
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterId, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(btnNewButton)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
