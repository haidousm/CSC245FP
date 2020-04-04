package physician_component.interfaces;

import java.util.ArrayList;

import general_files.User;
import lab_tech_component.Medication;

public interface IPrescribeMedication {

    public default boolean prescribeMedication(User patient, ArrayList<Medication> medicationList, Medication newMedication) {

        //TODO: Add default implementation (after creation of patient class)
        return false;

    }

}