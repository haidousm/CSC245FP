package lab_tech_component;

import java.util.*;

public class Diseases {

	private String name;
	private ArrayList<Medication> treatment = new ArrayList<>();
	private Medication med;

	// If Disease has an associated med
	public Diseases(String name, Medication med) {
		super();
		this.name = name;
		this.med = med;
	}

	// If Disease has an associated treatment
	public Diseases(String name, ArrayList<Medication> treatment, Medication med) {
		super();
		this.name = name;
		this.treatment = treatment;
		this.med = med;
	}

	// GETTERS & SETTERS
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
		return "Disease Name: " + this.name;
	}

}
