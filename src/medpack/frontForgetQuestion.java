package medpack;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class frontForgetQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField answerField;

	public frontForgetQuestion(int question, String answer, String password) {
		setTitle("Get Password");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		String temp="";
		if(question==1) {
			temp="What is your favorite food?";
		}else if(question==2) {
			temp="What is your mother's maiden name?";
		}else {
			temp="What was your highschool mascot?";
		}
		JLabel questionLabel = new JLabel(temp);
		questionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		questionLabel.setVerticalAlignment(SwingConstants.TOP);
		questionLabel.setBounds(57, 96, 532, 73);
		panel.add(questionLabel);
		
		answerField = new JTextField();
		answerField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		answerField.setBounds(57, 196, 532, 47);
		panel.add(answerField);
		answerField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((answerField.getText()).equals(answer)) {
					questionLabel.setText("Your password is: "+ password);
				}else {
					JOptionPane.showMessageDialog(null, "Try again!");
				}
			}
		});
		btnNewButton.setBounds(255, 297, 138, 61);
		panel.add(btnNewButton);
	}

}