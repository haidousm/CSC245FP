package lab_tech_component;

import org.jetbrains.annotations.NotNull;

public class Disease implements Comparable<Disease> {

    private int ID;
    private String name;
    //private ArrayList<Medication> treatment = new ArrayList<>();
    private int medicationID;

    public Disease(int ID, String name, int medicationID) {
        this.setID(ID);
        this.setName(name);
        this.setMedicationID(medicationID);
    }

    @Override
    public int compareTo(@NotNull Disease anotherUser) {
        return anotherUser.getName().compareTo(this.getName()) * -1;
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
        return String.format("ID: %d -- Name: %s\n", this.getID(), this.getName());
    }


}
