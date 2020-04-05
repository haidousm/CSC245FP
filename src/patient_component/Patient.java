package patient_component;

import general_files.User;

import java.util.ArrayList;

public class Patient extends User {

    private ArrayList<Integer> diseasesList = new ArrayList<>();
    private ArrayList<Integer> medicationsList = new ArrayList<>();

    private int age, gender;
    private double weight, height;

    public Patient(int ID, String firstName, String lastName, int age, int gender, double weight, double height) {

        super(ID, firstName, lastName);
        this.setAge(age);
        this.setWeight(weight);
        this.setHeight(height);
        this.setGender(gender);
//		this.setDiseasesList(diseasesList);
//		this.setMedicationsList(medicationsList);
//		, ArrayList<Integer> diseasesList, ArrayList<Integer> medicationsList


    }

    public ArrayList<Integer> getDiseasesList() {
        return diseasesList;
    }

    public void setDiseasesList(ArrayList<Integer> diseasesList) {
        this.diseasesList = diseasesList;
    }

    public ArrayList<Integer> getMedicationsList() {
        return medicationsList;
    }

    public void setMedicationsList(ArrayList<Integer> medicationsList) {
        this.medicationsList = medicationsList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return " ";
    }
}
