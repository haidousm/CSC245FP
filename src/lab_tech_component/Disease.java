package lab_tech_component;

import java.util.*;

public class Disease {

	private String name;
	private ArrayList<Medication> treatment = new ArrayList<>();
	private Medication med;

	// If Disease has an associated med
	public Disease(String name, Medication med) {
		this.name = name;
		this.med = med;
	}

	// If Disease has an associated treatment
	public Disease(String name, ArrayList<Medication> treatment) {
		this.name = name;
		this.treatment = treatment;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Medication> getTreatment() {
		return treatment;
	}

	public void setTreatment(ArrayList<Medication> treatment) {
		this.treatment = treatment;
	}

	public Medication getMed() {
		return med;
	}

	public void setMed(Medication med) {
		this.med = med;
	}

	public String toString() {
		return this.getName() + "\n";
	}

	
}
