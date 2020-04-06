package general_files;

import lab_tech_component.Disease;
import lab_tech_component.Medication;
import patient_component.Patient;
import physician_component.Physician;

import java.util.HashMap;

public class Data {

    int userID = 1;
    HashMap<Integer, Physician> physicianDict = new HashMap<>();
    HashMap<Integer, Patient> patientDict = new HashMap<>();

    int medicationIDCount = 1;
    HashMap<Integer, Medication> medicationDict = new HashMap<>();

    int diseaseIDCount = 1;
    HashMap<Integer, Disease> diseaseDict = new HashMap<>();

    public int createPhysician(String firstName, String lastName) {

        physicianDict.put(userID, new Physician(userID, firstName, lastName));
        userID++;
        return userID - 1;

    }

    public int createPatient(String firstName, String lastName, int age, int gender, double weight, double height) {

        patientDict.put(userID, new Patient(userID, firstName, lastName, age, gender, weight, height));
        userID++;
        return userID - 1;

    }

    public int createMedication(String medicationName, int adverseMedicationID) {

        medicationDict.put(medicationIDCount, new Medication(medicationIDCount, medicationName, adverseMedicationID));
        medicationIDCount++;
        return medicationIDCount - 1;
    }

    public int createDisease(String name, int medicationID) {

        diseaseDict.put(diseaseIDCount, new Disease(diseaseIDCount, name, medicationID));
        diseaseIDCount++;
        return diseaseIDCount - 1;

    }

    public Patient addPatient(int phyID, int patientID) {

        Patient patient = patientDict.get(patientID);

        if (patient != null) {

            physicianDict.get(phyID).getPatientList().add(patientID);

        }

        return patient;

    }

    public Medication retrieveMedicationBy(int ID) {

        return medicationDict.get(ID);

    }

    public Medication[] retrieveMedicationArray() {

        Medication[] medications = new Medication[medicationIDCount - 1];

        for (int i = 0; i < medicationIDCount - 1; i++) {

            medications[i] = retrieveMedicationBy(i + 1);

        }

        return medications;

    }

    public Disease retrieveDiseaseBy(int ID) {

        return diseaseDict.get(ID);

    }

    public User retrieveUserBy(int ID) {

        User physician = physicianDict.get(ID);

        if (physician == null) {

            User patient = patientDict.get(ID);
            if (patient != null) {

                return patient;

            }

        }

        return physician;

    }

}