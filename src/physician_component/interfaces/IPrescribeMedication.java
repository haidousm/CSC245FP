package physician_component.interfaces;

import lab_tech_component.Medication;
import patient_component.Patient;

import java.util.ArrayList;

public interface IPrescribeMedication {

    default boolean prescribeMedication(Patient patient, ArrayList<Medication> patientMedicationList, Medication newMedication) {

        boolean possible = true;
        for (int i = 0; i < patientMedicationList.size(); i++) {

            if (newMedication.getMedicationID() == patientMedicationList.get(i).getAdverseMedicationID()) {

                possible = false;

            }

        }

        if (possible) {

            patient.getMedicationsList().add(newMedication.getMedicationID());

        }

        return possible;

    }

}