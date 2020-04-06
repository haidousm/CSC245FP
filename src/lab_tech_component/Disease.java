package lab_tech_component;

public class Disease {

    private int ID;
    private String name;
    //private ArrayList<Medication> treatment = new ArrayList<>();
    private int medicationID;

    public Disease(int ID, String name, int medicationID) {
        this.setID(ID);
        this.setName(name);
        this.setMedicationID(medicationID);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMedicationID() {
        return medicationID;
    }

    public void setMedicationID(int medicationID) {
        this.medicationID = medicationID;
    }

    public String toString() {
        return String.format("ID: %d -- Disease Name: %s\n\t", this.getID(), this.getName());
    }


}
