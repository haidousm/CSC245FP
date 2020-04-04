package general_files;
public abstract class User {

    private int ID;
    private String firstName;
    private String lastName;

    public User(int ID, String firstName, String lastName){

        this.setID(ID);
        this.setFirstName(firstName);
        this.setLastName(lastName);

    }   

    public abstract String toString();

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
