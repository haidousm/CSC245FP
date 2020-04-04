package patient_component;

import java.util.ArrayList;
import general_files.User;
import lab_tech_component.Diseases;
import lab_tech_component.Medication;

public class Patient extends User {

	private ArrayList<Diseases> diseasesList = new ArrayList<>();
	private ArrayList<Medication> medicationsList = new ArrayList<>();
	private int age;
	
	private double weight, height;

	// Two different constructors depending on type of info available
	public Patient(int ID, String firstName, String lastName, int age, double w, double h) {

		super(ID, firstName, lastName);
		this.age = age;
		this.weight = w;
		this.height = h;

	}

	public Patient(int ID, String firstName, String lastName, int age, double w, double h, ArrayList<Medication> meds,
			ArrayList<Diseases> d) {
		super(ID, firstName, lastName);
		this.age = age;
		this.weight = w;
		this.height = h;
		this.diseasesList = d;
		this.medicationsList = meds;
	}

	public ArrayList<Diseases> getDiseasesList() {
		return diseasesList;
	}

	public void setDiseasesList(ArrayList<Diseases> diseasesList) {
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

		return String.format("Patient ID: %d -- Name: %s, %s -- Diseases Contracted:\n%s\nMedications In Use:\n%s",
				this.getID(), this.getLastName(), this.getFirstName(), this.getDiseases(), this.getMeds());
	}

}
