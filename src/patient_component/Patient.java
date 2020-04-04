package patient_component;

import java.util.ArrayList;
import general_files.User;
import lab_tech_component.Diseases;
import lab_tech_component.Medication;

public class Patient extends User{
	
	private ArrayList<Diseases> diseasesList = new ArrayList<>();
	private ArrayList<Medication> medicationsList = new ArrayList<>();
	private int age;
	private double weight , height;
	
	//Two different constructors depending on type of info available
	public Patient(int ID, String firstName, String lastName, int age, double w, double h) {

		super(ID, firstName, lastName);
		this.age = age;
		this.weight = w;
		this.height = h;
	
	}

	public Patient(int ID, String firstName, String lastName, int age,double w, double h, ArrayList<Medication> meds, ArrayList<Diseases> d) {
		super(ID, firstName, lastName);
		this.age = age;
		this.weight = w;
		this.height = h;
		this.diseasesList = d;
		this.medicationsList = meds;
	}
	
	// GETTERS & SETTERS
	public ArrayList<Diseases> getdiseasesList() {
		return diseasesList;
	}

	public void setdiseasesList(ArrayList<Diseases> diseasesList) {
		this.diseasesList = diseasesList;
	}

	public ArrayList<Medication> getmedicationsList() {
		return medicationsList;
	}

	public void setmedicationsList(ArrayList<Medication> medicationsList) {
		this.medicationsList = medicationsList;
	}

	public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
     
   public String getALLMeds() {
	   String s="";
	   for (int i = 0; i < this.medicationsList.size(); i++) {
		s+=medicationsList.toString()+"\n";
	}
	   return s;
   }
   
   public String getALLDiseases() {
	   String s="";
	   for (int i = 0; i < this.diseasesList.size(); i++) {
		s+=medicationsList.toString()+"\n";
	}
	   return s;
   }
    
	@Override
	public String toString() {
		return "Patient ID: " + super.getID() + "\nName: "+super.getFirstName()+" "+super.getLastName()+
				"\n\tDiseases Contracted: "+this.getALLDiseases()
				+"\n\tMedication Currently Being Taken: "+ this.getALLMeds();
	}
	

}
