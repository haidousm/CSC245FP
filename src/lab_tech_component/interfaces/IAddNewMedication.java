package lab_tech_component.interfaces;

import lab_tech_component.Medication;

public interface IAddNewMedication {

    default Medication addNewMedication(int medicationID, String medicationName, int adverseMedicationID) {

        boolean possible = true;

        Medication newMedication = new Medication(medicationID, medicationName, adverseMedicationID);

        return newMedication;


    }

}
