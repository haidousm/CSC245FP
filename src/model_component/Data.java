package model_component;

import lab_tech_component.Disease;
import lab_tech_component.Medication;
import patient_component.Patient;
import physician_component.Physician;

import java.util.HashMap;

public class Data {

    protected int userIDCount = 1;
    protected HashMap<Integer, Physician> physicianDict = new HashMap<>();
    HashMap<Integer, Patient> patientDict = new HashMap<>();

    protected int medicationIDCount = 1;
    HashMap<Integer, Medication> medicationDict = new HashMap<>();

    protected int diseaseIDCount = 1;
    protected HashMap<Integer, Disease> diseaseDict = new HashMap<>();


}