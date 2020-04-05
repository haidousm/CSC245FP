package lab_tech_component;

public class Medication {

    private int medicationID;
    private String medicationName;

    private int adverseMedicationID;


    public Medication(int medicationID, String medicationName, int adverseMedicationID) {
        this.setMedicationID(medicationID);
        this.setMedicationName(medicationName);
        this.setAdverseMedicationID(adverseMedicationID);
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

    public int getAdverseMedicationID() {
        return adverseMedicationID;
    }

    public void setAdverseMedicationID(int adverseMedicationID) {
        this.adverseMedicationID = adverseMedicationID;
    }

    public String toString() {

        return String.format("Medication ID: %d -- Medication Name: %s\n", this.getMedicationID(), this.getMedicationName());
    }

}
