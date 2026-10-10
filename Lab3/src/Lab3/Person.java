package Lab3;

public class Person {

	//Fields
	private int personid;
	private String name;
	private int age;
	
	//constructor
	public Person(int personid, String name, int age) throws InvalidPersonException {
		
		if(personid == 0) {
			throw new InvalidPersonException("person ID cannot be 0.");
		}
		if(name == null || name.trim().isEmpty()) {
			throw new InvalidPersonException("Name cannot be 0 or empty.");
		}
		if(age == 0 || age <0 ) {
			throw new InvalidPersonException("Age cannot be 0 or negative.");
		}
		this.personid = personid;
		this.name = name;
		this.age = age;
	}
	
	//Method
	public void performDuties(){
		System.out.println("The person is performing duties in the hospital.");
	}
	
	public int getpersonalid() {
		return personid;
	}
	
	public String getname() {
		return name;
	}
	
	public int getage() {
		return age;
	}
	
	@Override
	public String toString() {
		return "ID: "+ personid + ", Name: " + name + ", Age: " + age; 
	}
}
