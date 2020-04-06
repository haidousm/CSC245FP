package physician_component;

import general_files.User;
import physician_component.interfaces.IPrescribeMedication;

import java.util.ArrayList;

public class Physician extends User implements IPrescribeMedication {

    private ArrayList<Integer> patientList = new ArrayList<>();

    public Physician(int ID, String firstName, String lastName) {

        super(ID, firstName, lastName);

    }

    public ArrayList<Integer> getPatientList() {
        return this.patientList;
    }

    @Override
    public String toString() {
        return String.format("ID: %d -- %s, %s", this.getID(), this.getLastName(), this.getFirstName());
    }
}
