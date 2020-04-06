package lab_tech_component;

import general_files.User;
import lab_tech_component.interfaces.IAddNewMedication;

public class LabTechnician extends User implements IAddNewMedication {

    public LabTechnician(int ID, String firstName, String lastName) {
        super(ID, firstName, lastName);
    }

    @Override
    public String toString() {
        return String.format("ID: %d -- %s, %s", this.getLastName(), this.getFirstName());
    }
}
