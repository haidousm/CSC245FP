package model_component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import general_files.User;
import lab_tech_component.Disease;
import lab_tech_component.Medication;
import patient_component.Patient;
import physician_component.Physician;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataController {

    static Gson json = new GsonBuilder().setPrettyPrinting().create();
    Data data = new Data();

    public int createPhysician(String firstName, String lastName) {

        data.physicianDict.put(data.userIDCount, new Physician(data.userIDCount, firstName, lastName));
        data.userIDCount++;
        return data.userIDCount - 1;

    }

    public int createPatient(String firstName, String lastName, int age, int gender, double weight, double height) {

        data.patientDict.put(data.userIDCount, new Patient(data.userIDCount, firstName, lastName, age, gender, weight, height));
        data.userIDCount++;
        return data.userIDCount - 1;

    }

    public int createMedication(String medicationName, int adverseMedicationID) {

        data.medicationDict.put(data.medicationIDCount, new Medication(data.medicationIDCount, medicationName, adverseMedicationID));
        data.medicationIDCount++;
        return data.medicationIDCount - 1;
    }

    public int createDisease(String name, int medicationID) {

        data.diseaseDict.put(data.diseaseIDCount, new Disease(data.diseaseIDCount, name, medicationID));
        data.diseaseIDCount++;
        return data.diseaseIDCount - 1;

    }

    public Patient addPatientToPhysician(int phyID, int patientID) {

        Patient patient = data.patientDict.get(patientID);

        if (patient != null) {

            data.physicianDict.get(phyID).getPatientList().add(patientID);

        }

        return patient;

    }

    public Medication retrieveMedicationBy(int ID) {

        return data.medicationDict.get(ID);

    }

    public Medication[] retrieveMedicationArray() {

        Medication[] medications = new Medication[data.medicationIDCount - 1];

        for (int i = 0; i < data.medicationIDCount - 1; i++) {

            medications[i] = retrieveMedicationBy(i + 1);

        }

        return medications;

    }

    public Disease retrieveDiseaseBy(int ID) {

        return data.diseaseDict.get(ID);

    }

    public User retrieveUserBy(int ID) {

        User physician = data.physicianDict.get(ID);

        if (physician == null) {

            User patient = data.patientDict.get(ID);
            if (patient != null) {

                return patient;

            }

        }

        return physician;

    }

    // IO
    public void readData() throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File("src/model_component/data.json")).useDelimiter("\\Z");
        String currentJSONData = fileScanner.next();
        data = json.fromJson(currentJSONData, Data.class);

        fileScanner.close();

    }

    public void writeData() throws IOException {

        FileWriter writer = new FileWriter("src/model_component/data.json");
        writer.write(json.toJson(data));
        writer.close();
    }

}
