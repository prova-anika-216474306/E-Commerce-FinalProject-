package windowsgui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Admin;
import backend.Manager;
import dao.AdminDao;
import dao.ManagerDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ManagerLogin extends JFrame {
	static ManagerLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ManagerLogin();
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
	public ManagerLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblManagerForm = new JLabel("Manager Login");
		lblManagerForm.setForeground(Color.GRAY);
		lblManagerForm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEnterName = new JLabel("Enter Email:");
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String email=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			
			//BACKEND LOGIC
			Admin dao = new Admin();
			if(ManagerDao.validate(email, password)){
				Admin admin = new Admin();
				Manager m = admin.getManager(email);
				m.isLoggedIn= true;
				
				ManagerSuccess.main(new String[]{});
				System.out.print(m.isLoggedIn);
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(ManagerLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			} 
			}
		});
		
		passwordField = new JPasswordField();
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Landing.main(new String[]{});
				frame.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterName)
								.addComponent(lblEnterPassword))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(lblManagerForm)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(166)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLogin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblManagerForm)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
