package medpack;

public class doctor extends user{
	
	private String insurance, specialty, workstart, workend;
	private int userkey;
	
	public doctor(String contact, String email, String firstname, String lastname, String password, String securityanswer, String type, String username, int securityint, int userkey, String insurance, String specialty, String workstart, String workend){
		super(contact, email, firstname, lastname, password, securityanswer, type, username, securityint, userkey);
		this.insurance = insurance;
		this.specialty = specialty;
		this.workstart = workstart;
		this.workend = workend;
		this.userkey = userkey;
	}
	
	
	public static void ChooseTicket(doctor d) {
		frontDoctorChoose f = new frontDoctorChoose(d);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
	}
	
	public static void ViewChosenTicket(doctor d) {
		frontViewTicket f = new frontViewTicket(d);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
		
	}
	
//-------------------------------------------------------------------------------
	
	public String getInsurance() {
		return insurance;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public String getWorkStart() {
		return workstart;
	}
	
	public String getWorkEnd() {
		return workend;
	}
	
	public int getUserKey() {
		return userkey;
	}
	
//-------------------------------------------------------------------------------
	
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	public void setWorkStart(String workstart) {
		this.workstart = workstart;
	}
	
	public void setWorkEnd(String workend) {
		this.workend = workend;
	}
	
	public void setUserKey(int userkey) {
		this.userkey = userkey;
	}
	

}