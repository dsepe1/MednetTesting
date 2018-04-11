package medpack;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;

public class frontPatientHome extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public frontPatientHome(patient p) {
		setTitle("Patient Homepage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		nameLabel.setBounds(49, 40, 90, 20);
		panel.add(nameLabel);
		
		JLabel dynamicName = new JLabel();
		dynamicName.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		
		String fname = p.getFirstName();
		fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
		String lname = p.getLastName();
		lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);
		
		dynamicName.setText(fname + " " + lname);
		dynamicName.setBounds(165, 40, 696, 20);
		panel.add(dynamicName);
		
		JButton createButton = new JButton("Create Ticket");
		createButton.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patient.CreateTicket(p.getUserKey());
			}
		});
		createButton.setBounds(92, 473, 174, 65);
		panel.add(createButton);
		
		JButton viewButton = new JButton("Your Doctors");
		viewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patient.ViewDoctorInfo(p);
			}
		});
		viewButton.setBounds(511, 473, 197, 65);
		panel.add(viewButton);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.Logout();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(730, 92, 131, 21);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 92, 616, 345);
		panel.add(scrollPane);
		
		JTextArea txtrDescription = new JTextArea();
		scrollPane.setViewportView(txtrDescription);
		txtrDescription.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtrDescription.setText("Account Information\n\n"+"Contact#: "+p.contact+"\nEmail: "+p.email+"\nUsername: "+p.username+"\nPassword: "+p.password+"\nType: "+p.type+"\nUserkey: "+p.getUserKey()+"\nAllergies: "+p.getAllergy()+"\nAddress: "+p.getAddress());
		txtrDescription.append("\nMedical Conditions: "+p.getMedicalCondition()+"\nAge: "+p.getAge());
		txtrDescription.setEditable(false);
		
		JButton editticketButton = new JButton("Edit Ticket");
		editticketButton.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		editticketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patient.EditTicket(p.getUserKey());
			}
		});
		editticketButton.setBounds(305, 473, 174, 65);
		panel.add(editticketButton);
		
		JButton editaccountButton = new JButton("Edit Account");
		editaccountButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		editaccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontEditPatient f = new frontEditPatient(p);
				f.setLocationRelativeTo(panel);
				f.setVisible(true);
				f.setResizable(false);
				setVisible(false);
			}
		});
		editaccountButton.setBounds(730, 193, 131, 58);
		panel.add(editaccountButton);
	}
}
