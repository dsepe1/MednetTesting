package medpack;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class frontEditTicket extends JFrame {

	private JPanel contentPane;

	public frontEditTicket(int patientkey) {
		setTitle("Your Tickets");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 764, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 85, 561, 314);
		panel.add(scrollPane);
		
		JList list = new JList(Main.editticketlist(patientkey));
		list.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		scrollPane.setViewportView(list);
		
		JButton chooseButton = new JButton("Choose to edit");
		chooseButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing is selected!");
				}else {
					String ticketstring = list.getSelectedValue().toString().substring(11,16);
					int ticketid = Integer.parseInt(ticketstring);
					String patientstring = list.getSelectedValue().toString().substring(31,36);
					int patientkey = Integer.parseInt(patientstring);
					String description = list.getSelectedValue().toString().substring(51);
					frontEditTicket2 f = new frontEditTicket2(ticketid, patientkey, description);
					f.setLocationRelativeTo(panel);
					f.setVisible(true);
					f.setResizable(false);
					setVisible(false);
				}
			}
		});
		chooseButton.setBounds(515, 423, 157, 53);
		panel.add(chooseButton);
		
		JLabel lblNewLabel = new JLabel("Your current tickets");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(54, 34, 192, 21);
		panel.add(lblNewLabel);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing is selected!");
				}else {
					String ticketstring = list.getSelectedValue().toString().substring(11,16);
					int ticketid = Integer.parseInt(ticketstring);
					ticket.ResolveTicket(ticketid);
					frontEditTicket f = new frontEditTicket(patientkey);
					f.setLocationRelativeTo(panel);
					f.setResizable(false);
					f.setVisible(true);
					setVisible(false);
				}
			}
		});
		deleteButton.setBounds(54, 423, 167, 53);
		panel.add(deleteButton);
		
	}

	public frontEditTicket() {
		// TODO Auto-generated constructor stub
	}
}