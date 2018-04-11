package medpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class frontLogin extends JFrame{
	private JTextField usernameField;
	private JTextField passwordField;
	
	public frontLogin() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 540);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(58, 21, 685, 449);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel loginLabel = new JLabel("Login Page");
		loginLabel.setBounds(251, 6, 178, 41);
		panel_1.add(loginLabel);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(63, 67, 107, 16);
		panel_1.add(usernameLabel);
		usernameLabel.setFont(new Font("Helvetica", Font.ITALIC, 22));
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(63, 184, 141, 28);
		panel_1.add(passwordLabel);
		passwordLabel.setFont(new Font("Helvetica", Font.ITALIC, 22));
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		usernameField.setBounds(63, 96, 557, 47);
		panel_1.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		passwordField.setBounds(63, 224, 557, 47);
		panel_1.add(passwordField);
		passwordField.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				if(Main.authenticate(username, password)) {
					
					if(Main.check(username, password).equals("0")) {
						patient p = Main.pcheck(username, password);
						frontPatientHome f = new frontPatientHome(p);
						f.setLocationRelativeTo(panel);
						f.setVisible(true);
						f.setResizable(false);
						setVisible(false);
					}
					
					if(Main.check(username, password).equals("1")) {
						doctor d = Main.dcheck(username, password);
						frontDoctorHome f = new frontDoctorHome(d);
						f.setLocationRelativeTo(panel);
						f.setVisible(true);
						f.setResizable(false);
						setVisible(false);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Account not valid!");
				}
				
			}
		});
		
		loginButton.setBounds(107, 307, 201, 59);
		panel_1.add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				user.Register();
			}
		});
		
		registerButton.setBounds(371, 307, 201, 59);
		panel_1.add(registerButton);
		
		JButton forgetButton = new JButton("Forget Password?");
		forgetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.ForgetPassword();
			}
		});
		
		forgetButton.setBounds(273, 378, 141, 21);
		panel_1.add(forgetButton);
		forgetButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	}
}