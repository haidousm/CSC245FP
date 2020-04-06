package model_component;

import lab_tech_component.Disease;
import lab_tech_component.LabTechnician;
import lab_tech_component.Medication;
import patient_component.Patient;
import physician_component.Physician;

import java.util.HashMap;

public class Data {

    protected int userIDCount = 1;
    protected HashMap<Integer, Physician> physicianHashMap = new HashMap<>();
    protected HashMap<Integer, Patient> patientHashMap = new HashMap<>();
    protected HashMap<Integer, LabTechnician> labTechnicianHashMap = new HashMap<>();

    protected int medicationIDCount = 1;
    protected HashMap<Integer, Medication> medicationHashMap = new HashMap<>();

    protected int diseaseIDCount = 1;
    protected HashMap<Integer, Disease> diseaseHashMap = new HashMap<>();


}