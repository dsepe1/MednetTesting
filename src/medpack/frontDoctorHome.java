package medpack;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class frontDoctorHome extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public frontDoctorHome(doctor d) {
		setTitle("Doctor Homepage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Choose Ticket");
		btnNewButton.setBounds(242, 468, 185, 81);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctor.ChooseTicket(d);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 22));
		
		JButton btnNewButton_1 = new JButton("View Ticket");
		btnNewButton_1.setBounds(467, 468, 198, 81);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctor.ViewChosenTicket(d);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 22));
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(687, 93, 145, 21);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.Logout();
				setVisible(false);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 89, 549, 340);
		
		JLabel lblName = new JLabel("Name:");
		
		lblName.setBounds(76, 31, 89, 27);
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		
		String fname = d.getFirstName();
		fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
		String lname = d.getLastName();
		lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);
				
		JLabel nameLabel = new JLabel(fname+" "+lname);
		nameLabel.setBounds(189, 31, 643, 27);
		nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		
		JButton editacountButton = new JButton("Edit Account");
		editacountButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		editacountButton.setBounds(687, 164, 145, 71);
		editacountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontEditDoctor f = new frontEditDoctor(d);
				f.setLocationRelativeTo(panel);
				f.setVisible(true);
				f.setResizable(false);
				setVisible(false);
			}
		});
		
		JTextArea txtrK = new JTextArea();
		txtrK.setText("k");
		txtrK.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtrK.setText("Account Information\n\n"+"Contact#: "+d.contact+"\nEmail: "+d.email+"\nUsername: "+d.username+"\nPassword: "+d.password+"\nType: "+d.type+"\nUserkey: "+d.getUserKey()+"\nInsurances: "+d.getInsurance()+"\nSpecialty: "+d.getSpecialty());
		txtrK.append("\nWorkstart: "+d.getWorkStart()+"\nWorkend: "+d.getWorkEnd());
		scrollPane.setViewportView(txtrK);
		txtrK.setEditable(false);
		panel.setLayout(null);
		panel.add(btnNewButton);
		panel.add(btnNewButton_1);
		panel.add(lblName);
		panel.add(nameLabel);
		panel.add(scrollPane);
		panel.add(editacountButton);
		panel.add(btnLogOut);
	}
}