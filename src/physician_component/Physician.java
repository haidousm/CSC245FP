package physician_component;

import java.util.ArrayList;
import java.util.Iterator;

import general_files.User;
import lab_tech_component.Medication;
import physician_component.interfaces.IPrescribeMedication;

public class Physician extends User implements IPrescribeMedication {

    private ArrayList<User> patientList = new ArrayList<User>();

    private ArrayList<Medication> availableMedicationsList = new ArrayList<Medication>(); // to be supplied by the lab technician

    public Physician(int ID, String firstName, String lastName) {

        super(ID, firstName, lastName);

    }

    public String toString() {

        String string = String.format("Physician ID: %d -- Physician Name: %s, %s -- Patient List:\n", this.getID(), this.getLastName(), this.getFirstName());

        Iterator<User> it = patientList.iterator();

        while(it.hasNext()){

            User currentPatient = it.next();

            string += " " + currentPatient.toString() + "\n";

        }
        
        return string;
    }


    public ArrayList<User> getPatientList() {
        return this.patientList;
    }

    public void setPatientList(ArrayList<User> patientList) {
        this.patientList = patientList;
    }

    public ArrayList<Medication> getAvailableMedicationsList() {
        return this.availableMedicationsList;
    }

    public void setAvailableMedicationsList(ArrayList<Medication> availableMedicationsList) {
        this.availableMedicationsList = availableMedicationsList;
    }

}
