package medpack;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class frontForgetPassword extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;

	public frontForgetPassword() {
		setTitle("Forget Password");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel enterEmailLabel = new JLabel("Enter username:");
		enterEmailLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		enterEmailLabel.setBounds(51, 73, 512, 56);
		panel.add(enterEmailLabel);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		emailField.setBounds(51, 153, 513, 56);
		panel.add(emailField);
		emailField.setColumns(10);
		
		JButton btnGetSecurityQuestion = new JButton("Get Security Question");
		btnGetSecurityQuestion.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnGetSecurityQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emailField.getText()!=null) {
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
						Statement stmt = con.createStatement();
						ResultSet res = stmt.executeQuery("select * from userTable");
						Boolean temp=true;
						while(res.next()) {
							if( (emailField.getText() ).equals(res.getString("username") ) ) {
								frontForgetQuestion frame = new frontForgetQuestion(res.getInt("securityint"), res.getString("securityanswer"), res.getString("password"));
								frame.setLocationRelativeTo(panel);
								frame.setVisible(true);
								frame.setResizable(false);
								setVisible(false);
								temp=false;
							}
						}
						if(temp) {
						JOptionPane.showMessageDialog(null, "Try again!");
						}
						
					}
					catch(Exception exc) {
						System.out.println("Error(frontForgetPassword)");
						exc.printStackTrace();
					}
				}
			}
		});
		btnGetSecurityQuestion.setBounds(194, 253, 209, 56);
		panel.add(btnGetSecurityQuestion);
	}
}
