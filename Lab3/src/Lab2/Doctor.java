package Lab2;

public class Doctor extends Person{

	//Fields
	private String specialization;
	private double consultationFee;
	
	//constructor
	public Doctor(int personid, String name, int age, String specialization, double consultationFee) throws InvalidPersonException {
		
		if(specialization == null || specialization.trim().isEmpty()) {
			throw new InvalidPersonException("Specialization cannot be empty and blank");
		}
		if(consultationFee < 0) {
			throw new InvalidPersonException("Consultation Fee cannot be negative.");
		}
		
		super(personid, name, age);
		this.specialization = specialization;
		this.consultationFee = consultationFee;
	}
	
	//Method
	public void diagnosePatient() {
		System.out.println( getname() +" doctor diagnoses patients as " + getspecialization() + " specialist and it costs $" + getConsultationFee());
	}
	
	//Override
	@Override
	public void performDuties() {	
		System.out.println( getname() + " is performing duties.");
	}
	
	public String getspecialization() {
		return specialization;
	}

	public double getConsultationFee() {
		return consultationFee;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Specialization: " + specialization + ", Consultation Fee: " + consultationFee;
	}
}
