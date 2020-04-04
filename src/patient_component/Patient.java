package patient_component;

import java.util.ArrayList;
import general_files.User;
import lab_tech_component.Diseases;
import lab_tech_component.Medication;

public class Patient extends User{
	
	private ArrayList<Diseases> list_d = new ArrayList<>();
	private ArrayList<Medication> list_m = new ArrayList<>();
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
		this.list_d = d;
		this.list_m = meds;
	}
	
	// GETTERS & SETTERS
	public ArrayList<Diseases> getList_d() {
		return list_d;
	}

	public void setList_d(ArrayList<Diseases> list_d) {
		this.list_d = list_d;
	}

	public ArrayList<Medication> getList_m() {
		return list_m;
	}

	public void setList_m(ArrayList<Medication> list_m) {
		this.list_m = list_m;
	}

	public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
     
   public String getALLMeds() {
	   String s="";
	   for (int i = 0; i < this.list_m.size(); i++) {
		s+=list_m.toString()+"\n";
	}
	   return s;
   }
   
   public String getALLDiseases() {
	   String s="";
	   for (int i = 0; i < this.list_d.size(); i++) {
		s+=list_m.toString()+"\n";
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
