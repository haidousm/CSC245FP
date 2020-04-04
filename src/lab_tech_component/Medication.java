package lab_tech_component;

public class Medication {

    private int medicationID;
    private String medicationName;

    public String toString() {
        
        return String.format("Medication ID: %d -- Medication Name: %s", this.getMedicationID(), this.getMedicationName());
    }

    public int getMedicationID() {
        return this.medicationID;
    }

    public void setMedicationID(int medicationID) {
        this.medicationID = medicationID;
    }

    public String getMedicationName() {
        return this.medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

}