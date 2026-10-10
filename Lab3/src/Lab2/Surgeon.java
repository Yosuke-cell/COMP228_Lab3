package Lab2;

public class Surgeon extends Doctor{

	//Fields
	private String surgeryType;
	private String operatingRoom;
	
	//constructor
	public Surgeon(int personid, String name, int age, String specialization, double consultationFee, String surgeryType, String operatingRoom) throws InvalidPersonException {
		
		if(surgeryType == null || surgeryType.trim().isEmpty()) {
			throw new InvalidPersonException("Surgery type cannot be empty.");
		}
		if(surgeryType == null || operatingRoom.trim().isEmpty()) {
			throw new InvalidPersonException("Operating Room cannot be empty.");
		}
		super(personid, name, age, specialization, consultationFee);
		this.surgeryType = surgeryType;
		this.operatingRoom = operatingRoom;
	}
	
	public void performSurgery() {
		System.out.println( getname() + " takes plan on " + getsurgeryType() + "surgery in " + getoperatingRoom() + " room.");
	}
	
	@Override
	public void performDuties() {
		System.out.println( getname() + " is performing duties.");
	}
	
	public String getsurgeryType() {
		return surgeryType;
	}
	
	public String getoperatingRoom() {
		return operatingRoom;
	}
	
	@Override 
	public String toString() {
		return super.toString() + ", Surgery Type: " + surgeryType + ", Operating Room: " + operatingRoom;
	}
}
