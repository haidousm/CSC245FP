package general_files;

import org.jetbrains.annotations.NotNull;

public abstract class User implements Comparable<User> {

    private int ID;
    private String firstName;
    private String lastName;

    public User(int ID, String firstName, String lastName) {

        this.setID(ID);
        this.setFirstName(firstName);
        this.setLastName(lastName);

    }

    @Override
    public int compareTo(@NotNull User anotherUser) {
        return anotherUser.getLastName().compareTo(this.lastName) * -1;
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
