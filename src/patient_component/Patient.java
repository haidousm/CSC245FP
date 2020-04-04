package patient_component;

import java.util.ArrayList;

import general_files.User;
import lab_tech_component.Disease;
import lab_tech_component.Medication;

public class Patient extends User {

	private ArrayList<Disease> diseasesList = new ArrayList<>();
	private ArrayList<Medication> medicationsList = new ArrayList<>();
	private int age,ssn;
	private double weight, height;
	private String gender;
	

	// Two different constructors depending on type of info available
	public Patient(int ID,int ssn, String firstName, String lastName, int age, String gender, double w, double h) {

		super(ID, firstName, lastName);
		this.age = age;
		this.ssn =  ssn;
		this.gender = gender;
		this.weight = w;
		this.height = h;

	}

	public Patient(int ID, String firstName, String lastName, int age, double w, double h, ArrayList<Medication> meds,
			ArrayList<Disease> d) {
		super(ID, firstName, lastName);
		this.age = age;
		this.weight = w;
		this.height = h;
		this.diseasesList = d;
		this.medicationsList = meds;
	}

	public ArrayList<Disease> getDiseasesList() {
		return diseasesList;
	}

	public void setDiseasesList(ArrayList<Disease> diseasesList) {
		this.diseasesList = diseasesList;
	}

	public ArrayList<Medication> getMedicationsList() {
		return medicationsList;
	}

	public void setMedicationsList(ArrayList<Medication> medicationsList) {
		this.medicationsList = medicationsList;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSSN() {
		return ssn;
	}

	public void setSSN(int ssn) {
		this.ssn = ssn;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMeds() {

		String string = "";
		for (int i = 0; i < this.medicationsList.size(); i++) {

			string += medicationsList.get(i).toString();

		}

		return string;
	}

	public String getDiseases() {
		String string = "";

		for (int i = 0; i < this.diseasesList.size(); i++) {

			string += diseasesList.get(i).toString();

		}

		return string;
	}

	@Override
	public String toString() {

		return String.format("Patient ID: %d -- SSN: %s -- Name: %s, %s\nAge: %d -- Gender: %s --"
				+ " Weight: %.2f -- Height: %.2f\nDiseases Contracted:\n%s\nMedications In Use:\n%s",
				this.getID(),this.getSSN(), this.getAge(),this.getGender(),this.getWeight()
				,this.getHeight(),this.getLastName(), this.getFirstName(), this.getDiseases(), this.getMeds());
	}

}
