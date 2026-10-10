package Lab2;

public class Nurse extends Person{

	//Fields
	private String department;
	private String shift;
	
	//constructor
	public Nurse(int personid, String name, int age, String department, String shift) throws InvalidPersonException {
		// TODO Auto-generated constructor stub
		
		if (department == null || department.trim().isEmpty() ) {
			throw new InvalidPersonException("Department cannot be empty.");
		}
		if (shift == null || shift.trim().isEmpty()) {
			throw new InvalidPersonException("Shift cannot be empty.");
		}
		super(personid, name, age);
		this.department = department;
		this.shift = shift;
	}

	public void assistPatient() {
		System.out.println( getname() + " nurse takes care of patients from " + getdepartment() + " at " + getshift() + " shift.");
	}

	@Override
	public void performDuties() {
		System.out.println(getname() + " is performing duties.");
	}
	
	public String getdepartment() {
		return department;
	}
	
	public String getshift() {
		return shift;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Dpartment: " + department + ", Shift: " + shift;
	}
}
