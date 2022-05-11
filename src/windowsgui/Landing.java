package windowsgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class Landing {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Landing window = new Landing();
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
	public Landing() {
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
		
		
		JButton buttonAdministratorLogin = new JButton("Administrator Login");
		buttonAdministratorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		}); 
		buttonAdministratorLogin.setBounds(123, 52, 150, 54);
		frame.getContentPane().add(buttonAdministratorLogin);
		
		buttonAdministratorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin.main(new String[]{});
			frame.dispose();
			}
		});
		
	
		JButton buttonManagerLogin = new JButton("Manager Login");
		buttonManagerLogin.setBounds(123, 121, 150, 55);
		frame.getContentPane().add(buttonManagerLogin);
		
		 buttonManagerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ManagerLogin.main(new String[]{});
			frame.dispose();
			}
		
		});
		
		 
		JButton buttonCustomerLogin = new JButton("Customer Login");
		buttonCustomerLogin.setBounds(123, 187, 150, 54);
		frame.getContentPane().add(buttonCustomerLogin);
		
		buttonCustomerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CustomerLogin.main(new String[]{});
			frame.dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("ShoppersLand Inc.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(123, 11, 150, 30);
		frame.getContentPane().add(lblNewLabel);
	}
}
