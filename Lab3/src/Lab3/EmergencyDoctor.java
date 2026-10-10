package Lab3;

public class EmergencyDoctor extends Doctor implements MedicalProfessional, Billable{

	public EmergencyDoctor(int personid, String name, int age, String specialization, double consultationFee) throws InvalidPersonException {
		super(personid, name, age, specialization, consultationFee);
	}
	
	public void handleEmergency() {
		System.out.println( getname() + " is handling a emergency case as " + getspecialization() + " specialist and it costs $" + getConsultationFee());
	}
	
	@Override
	public void prescribeMedication() {
		System.out.println( getname() + " perscribes emergency medication.");
	}
	
	@Override
	public void generateBill() {
		System.out.println("Bill for " + getname() + "'s consultation: $" + getConsultationFee());
	}
	
	@Override 
	public void performDuties() {
		System.out.println( getname() + " is performing duties.");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
