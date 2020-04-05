package physician_component;

import general_files.User;
import physician_component.interfaces.IPrescribeMedication;

import java.util.ArrayList;

public class Physician extends User implements IPrescribeMedication {

    private ArrayList<Integer> patientList = new ArrayList<>();

    public Physician(int ID, String firstName, String lastName) {

        super(ID, firstName, lastName);

    }

    public String toString() {

//        String string = String.format("Physician ID: %d -- Physician Name: %s, %s -- Patient List:\n", this.getID(), this.getLastName(), this.getFirstName());
//
//        Iterator<Integer> it = patientList.iterator();
//
//        while(it.hasNext()){
//
//            User currentPatient = it.next();
//
//            string += " " + currentPatient.toString() + "\n";
//
//        }
//
//        return string;

        return " ";
    }


    public ArrayList<Integer> getPatientList() {
        return this.patientList;
    }

    public void setPatientList(ArrayList<Integer> patientList) {
        this.patientList = patientList;
    }

}
