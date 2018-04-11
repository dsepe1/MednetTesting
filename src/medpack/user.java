package medpack;

import java.awt.Frame;
import java.sql.*;

import javax.swing.JOptionPane;

public class user {
	
	protected String contact, email, firstname, lastname, password, securityanswer, type, username;
	protected int securityint, userkey;
	
	public user(String contact, String email, String firstname, String lastname, String password, String securityanswer, String type, String username, int securityint, int userkey) {
		this.contact = contact;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.securityanswer = securityanswer;
		this.type = type;
		this.username = username;
		this.securityint = securityint;
		this.userkey = userkey;
	}
	
	public static void Register() {
		Register f = new Register();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
	}
	
	public static void Login() {
		try {
			frontLogin frame = new frontLogin();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Logout() {
		frontLogin f = new frontLogin();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
	}
	
	public static void ForgetPassword() {
		frontForgetPassword f = new frontForgetPassword();
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	
//--------------------------------------------------------------------------------------
	
	public String getContact() {
		return contact;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getSecurityAnswer() {
		return securityanswer;
	}
	
	public String getType() {
		return type;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getSecurityInt() {
		return securityint;
	}
	
	public int getUserKey() {
		return userkey;
	}
	
//-------------------------------------------------------------------------------------------
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSecurityAnswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setUsernae(String username) {
		this.username = username;
	}
	
	public void setSecurityInt(int securityint) {
		this.securityint = securityint;
	}
	
	public void setUserKey(int userkey) {
		this.userkey = userkey;
	}

}