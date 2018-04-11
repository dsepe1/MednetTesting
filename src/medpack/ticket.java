package medpack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ticket {
	
	protected int ticketID;
	private String datecreated;
	private String description;
	public int patientkey, doctorkey;
	
	public ticket(int ticketID, String datecreated, String description, int patientkey, int doctorkey) {
		this.ticketID = ticketID;
		this.datecreated = datecreated;
		this.description = description;
		this.patientkey = patientkey;
		this.doctorkey = doctorkey;
	}
	
	public static void ResolveTicket(int ticketid) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9229419", "sql9229419" , "SJtMZMKmYd");
			PreparedStatement stmt = con.prepareStatement("delete from ticketTable where ticketid = ?");
			stmt.setInt(1, ticketid);
			stmt.executeUpdate();
			stmt.close();
			con.close();
		}
		catch(Exception exc) {
			System.out.println("ERRORRR");
			exc.printStackTrace();
		}
	}
	
//------------------------------------------------------------------------------------
	
	public int getTicketID() {
		return ticketID;
	}
	
	public String getDateCreated() {
		return datecreated;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getPatientKey() {
		return patientkey;
	}
	
	public int getDoctorKey() {
		return doctorkey;
	}
	
//----------------------------------------------------------------------------------------
	
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
	public void setDateCreated(String datecreated) {
		this.datecreated = datecreated;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setPatientKey(int patientkey) {
		this.patientkey = patientkey;
	}
	
	public void setDoctorKey(int doctorkey) {
		this.doctorkey = doctorkey;
	}

}
