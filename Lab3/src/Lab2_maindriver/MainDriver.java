package Lab2_maindriver;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;

import Lab2.Doctor;
import Lab2.EmergencyDoctor;
import Lab2.InvalidPersonException;
import Lab2.Nurse;
import Lab2.Person;
import Lab2.Surgeon;
import java.util.Scanner;
import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Person[] hospitalsystem = new Person[4];
		int count = 0;
		
		System.out.println("====================================");
		System.out.println("     HOSPITAL MANAGEMENT SYSTEM     ");
		System.out.println("====================================");
		
		Person p = null;
		
		while(count < hospitalsystem.length) {
			try {
			
			System.out.println("\n--- Person " + (count + 1) + " ---");
			System.out.print("Enter your name: ");
			String name = sc.nextLine();
			System.out.print("Enter your person ID: ");
			int personid = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter your age: ");
			int age = sc.nextInt();
			sc.nextLine();
			
			
			System.out.println("1, Doctor");
			System.out.println("2, Nurse");
			System.out.println("3, Surgeon");
			System.out.println("4, Emergency Doctor");
			int type = sc.nextInt();
			sc.nextLine();
			
			if (type == 1) {
				System.out.print("Enter your specialization: ");
				String specialization = sc.nextLine();
				System.out.print("Enter consultant Fee: ");
				double consultationFee = sc.nextDouble();
				sc.nextLine();
				
				p = new Doctor(personid, name, age, specialization, consultationFee);
			}
			else if(type == 2) {
				System.out.print("Enter department: ");
				String department = sc.nextLine();
				System.out.print("Enter your shift: ");
				String shift = sc.nextLine();
				
				p = new Nurse(personid, name, age, department, shift);
			}
			else if(type == 3) {
				System.out.print("Enter your specialization: ");
				String specialization = sc.nextLine();
				System.out.print("Enter Consultant Fee: ");
				double consultationFee = sc.nextDouble();
				sc.nextLine();
				System.out.print("Enter surgery type: ");
				String surgeryType = sc.nextLine();
				System.out.print("Enter operating room: ");
				String operatingRoom = sc.nextLine();
				
				p = new Surgeon(personid, name, age, specialization, consultationFee, surgeryType, operatingRoom);
			}
			else if (type == 4) {
				System.out.print("Enter your specialization: ");
				String specialization = sc.nextLine();
				System.out.print("Enter consltant Fee: ");
				double consultationFee = sc.nextDouble();
				sc.nextLine();
				
				p = new EmergencyDoctor(personid, name, age, specialization, consultationFee);
			}
			else {
				System.out.print("Invalid Number. Please choose 1-4");
				continue;
			}
			
			hospitalsystem[count] = p; 
			count++; 
			
			}catch (InvalidPersonException e){
				System.out.println("Error: " + e.getMessage());
			}catch (InputMismatchException e) {
				System.out.println("Please enter a number.");
				sc.nextLine();
			}
		}
		
		System.out.println("\n====== Details of each object ======");
		for (int i = 0; i < count; i++) {
			Person person = hospitalsystem[i];
			System.out.println(person); 

		}
		
		System.out.println("\n====== Specialized Methods ======");
		for (int i = 0; i < count; i++) {
			Person person = hospitalsystem[i];
 
			if (person instanceof EmergencyDoctor) {
				EmergencyDoctor ed = (EmergencyDoctor) person;
				ed.diagnosePatient();
				ed.handleEmergency();
				
				// interface method
				ed.prescribeMedication();
				ed.generateBill();
			}
			else if (person instanceof Surgeon) {
				Surgeon s = (Surgeon) person;
				s.diagnosePatient();
				s.performSurgery();
			}
			else if (person instanceof Doctor) {
				Doctor d = (Doctor) person;
				d.diagnosePatient();
			}
			else if (person instanceof Nurse) {
				Nurse n = (Nurse) person;
				n.assistPatient();
			}
		}
 
		sc.close();
		
		try {
			//Polymorphism
			System.out.println("\n====== Polymorphism with a Person reference ======");
			Person person;
		       person = new Doctor(101, "Dr. Smith", 45, "Cardiology", 200.0);
		       person.performDuties();
		       person = new Nurse(102, "Anna", 30, "ICU", "Night");
		       person.performDuties();
		       person = new Surgeon(103, "Dr. Lee", 50, "Orthopedics", 500.0, "Knee Replacement", "OR-2");
		       person.performDuties();
		       person = new EmergencyDoctor(104, "Dr. Khan", 40, "Trauma", 300.0);
		       person.performDuties();

		} catch(InvalidPersonException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
