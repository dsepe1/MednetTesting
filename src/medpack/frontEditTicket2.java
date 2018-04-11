package medpack;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class frontEditTicket2 extends JFrame {

	private JPanel contentPane;
	
	public frontEditTicket2(int ticketid, int patientkey, String description) {
		setTitle("Edit Ticket");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 756, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel patientksylabel = new JLabel("Patient Key:");
		patientksylabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		patientksylabel.setBounds(88, 63, 124, 19);
		panel.add(patientksylabel);
		
		JLabel ticketidlabel = new JLabel("Ticket ID:");
		ticketidlabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		ticketidlabel.setBounds(88, 106, 102, 19);
		panel.add(ticketidlabel);
		
		JLabel datecreatedlabel = new JLabel("New Date Created:");
		datecreatedlabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		datecreatedlabel.setBounds(88, 154, 160, 21);
		panel.add(datecreatedlabel);
		
		JLabel descriptionlabel = new JLabel("Description:");
		descriptionlabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		descriptionlabel.setBounds(88, 225, 124, 21);
		panel.add(descriptionlabel);
		
		JLabel label_4 = new JLabel("Edit Ticket");
		label_4.setFont(new Font("Arial", Font.BOLD, 23));
		label_4.setBounds(310, 6, 146, 44);
		panel.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 222, 357, 108);
		panel.add(scrollPane);
		
		JTextArea descriptionArea = new JTextArea();
		descriptionArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		scrollPane.setViewportView(descriptionArea);
		descriptionArea.setLineWrap(true);
		
		descriptionArea.setText(description);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontEditTicket f = new frontEditTicket(patientkey);
				f.setLocationRelativeTo(panel);
				f.setVisible(true);
				f.setResizable(false);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(114, 391, 160, 65);
		panel.add(btnNewButton);
		
		JLabel patientkeyLabel = new JLabel(Integer.toString(patientkey));
		patientkeyLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		patientkeyLabel.setBounds(261, 64, 112, 16);
		panel.add(patientkeyLabel);
		
		JLabel ticketidLabel = new JLabel(Integer.toString(ticketid));
		ticketidLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		ticketidLabel.setBounds(261, 105, 123, 21);
		panel.add(ticketidLabel);
		
		JLabel dateLabel = new JLabel(new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime()));
		dateLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		dateLabel.setBounds(260, 154, 124, 21);
		panel.add(dateLabel);
		
		JButton resubmitbutton = new JButton("Resubmit");
		resubmitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(descriptionArea.getText().length()>=10 && descriptionArea.getText().length()<200) {
					Main.changeTicketDescription( ticketid, descriptionArea.getText() , dateLabel.getText() );
					frontEditTicket f = new frontEditTicket(patientkey);
					f.setLocationRelativeTo(panel);
					f.setVisible(true);
					f.setResizable(false);
					setVisible(false);
				}
				
				if(descriptionArea.getText().length()<10) {
					JOptionPane.showMessageDialog(null, "Description must be at least 10 characters.");
				}
				
				if(descriptionArea.getText().length()>200) {
					JOptionPane.showMessageDialog(null, "Description must be below 200 characters.");
				}
			}
		});
		resubmitbutton.setFont(new Font("Arial", Font.PLAIN, 18));
		resubmitbutton.setBounds(482, 390, 160, 65);
		panel.add(resubmitbutton);
		
	}
}