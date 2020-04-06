package lab_tech_component.interfaces;

import lab_tech_component.Disease;

public interface IAddNewDisease {

    default Disease addNewDisease(int diseaseID, String diseaseName, int medicationID) {

        boolean possible = true;

        Disease newDisease = new Disease(diseaseID, diseaseName, medicationID);

        return newDisease;

    }

}
