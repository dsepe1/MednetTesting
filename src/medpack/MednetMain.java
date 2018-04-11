package medpack;

public class MednetMain {

	public static void main(String[] args) {
//		frontForgetPassword frame = new frontForgetPassword();
//		frame.setVisible(true);
// TESTABLE?		frontEditTicket frame2 = new frontEditTicket(23069);
//		frame2.setVisible(true);
		doctor d = new doctor("0000000000", "doctor@email.com", "Dr. Wizard", "of Oz", "password", "pizza", "1", "Oz", 1, 88888, "StateFarm", "Dentist", "1000", "1700");
		frontDoctorHome frame3 = new frontDoctorHome(d);
		frame3.setVisible(true);
	}
}
