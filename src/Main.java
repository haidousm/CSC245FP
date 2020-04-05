import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import general_files.Data;
import general_files.User;
import lab_tech_component.Disease;
import lab_tech_component.Medication;
import patient_component.Patient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

    static Gson json = new GsonBuilder().setPrettyPrinting().create();
    static Data data = new Data();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        readData();

        init();

        writeData();

        input.close();

    }

    public static void init() {


        String menu = "Hello, Welcome to ***YourHealth Inc.***!\nPress any of the following:\n\t1- Sign Up\n\t2- Sign In\n\t0- Exit\n";
        System.out.print(menu);
        int key = input.nextInt();

        switch (key) {

            case 1:

                signUp();
                break;
            case 2:

                signIn();
                break;
            default:
                break;

        }


    }

    public static void authenticate(int userID) {

        User user = data.retrieveUserBy(userID);

        if (user == null) {

            return;

        }

        if (user instanceof Patient) {

            Patient patient = (Patient) user;

            if (patient.getGender() > 0) {

                System.out.printf("Welcome Ms. %s!\n", patient.getLastName());

            } else {

                System.out.printf("Welcome Mr. %s\n", patient.getLastName());

            }

            if (patient.getMedicationsList().size() == 0) {

                System.out.println("You currently have no medications saved at ***YourHealth Inc.***\nWould you like some?\n\t1- Yes\n\t0- No\n");
                addMedicationToPatient(patient);

            }

            if (patient.getDiseasesList().size() == 0) {

                System.out.println("There's no diseases attached to your record. We suggest adding some so that we can aid you better.\nWould you like to?\n\t1- Yes\n\t0- No\n");
                addDiseaseToPatient(patient);

            }

            System.out.println("What would you like to do?\n\t1- View Records\n\t2- Add Medications\n\t3- Add Diseases\n\t0- Exit");
            int key = input.nextInt();

            switch (key) {

                case 1:
                    viewPatientRecords(patient);
                    break;
                case 2:
                    addMedicationToPatient(patient);
                    break;
                case 3:
                    addDiseaseToPatient(patient);
                    break;
                default:
                    break;

            }


        } else {

            System.out.println("You're a Physician!");

        }


    }

    public static void signIn() {


        System.out.print("Please enter your ID: ");
        int ID = input.nextInt();
        User user = data.retrieveUserBy(ID);
        if (user != null) {

            authenticate(ID);

        } else {

            System.out.println("Wrong ID! Please try again later.");

        }


    }

    public static void signUp() {


        String phyOrPatient = "Are you a:\n\t1- Patient\n\t2- Physician\n\t0- Exit\n";
        System.out.print(phyOrPatient);
        int key = input.nextInt();

        System.out.print("Welcome! Please enter your first name: ");
        String fName = input.next();
        System.out.println();

        System.out.print("Last Name: ");
        String lName = input.next();
        System.out.println();

        switch (key) {
            case 1:

                System.out.println("Age | Gender (0 for male, 1 for female) | Weight | Height (Separated by spaces please!)");
                int age = input.nextInt();
                int gender = input.nextInt();

                double weight = input.nextDouble();
                double height = input.nextDouble();

                int newPatientID = data.createPatient(fName, lName, age, gender, weight, height);

                System.out.printf("Thank you for signing up! Your ID is #%d.\nPlease save it since you'll need it to sign in later!\n", newPatientID);
                authenticate(newPatientID);
                break;
            case 2:
                int newPhysicianID = data.createPhysician(fName, lName);
                System.out.print("Would you like to add your patients now?\n\t1- Yes\n\t0-No\n");
                key = input.nextInt();

                if (key > 0) {

                    System.out.println("Please enter the number of patient (you can add more later): ");
                    int numOfPatients = input.nextInt();
                    System.out.println("Please enter your patient IDs separated by spaces:");
                    while (numOfPatients > 0) {

                        int patientID = input.nextInt();
                        data.addPatient(newPhysicianID, patientID);
                        numOfPatients--;
                    }
                }

                System.out.printf("Thank you for signing up! Your ID is #%d.\nPlease save it since you'll need it to sign in later!\n", newPhysicianID);
                authenticate(newPhysicianID);
                break;
            default:
                break;
        }


    }

    public static void addMedicationToPatient(Patient patient) {

        int key = input.nextInt();

        if (key == 1) {
            System.out.print("Please enter the # of medications you'd like to add: ");
            int numOfMeds = input.nextInt();
            System.out.println("Please enter the medication IDs:");

            while (numOfMeds > 0) {

                int medicationID = input.nextInt();
                Medication medication = data.retrieveMedicationBy(medicationID);
                if (medication != null) {

                    System.out.printf("Successfully added %s.\n", medication.getMedicationName());
                    patient.getMedicationsList().add(medicationID);
                } else {

                    System.out.println("This medication has not been added to our repository yet!");

                }

                numOfMeds--;

            }
        }


    }

    public static void addDiseaseToPatient(Patient patient) {


        int key = input.nextInt();

        if (key == 1) {
            System.out.print("Please enter the # of diseases you'd like to add: ");
            int numOfDiseases = input.nextInt();
            System.out.println("Please enter the disease IDs:");

            while (numOfDiseases > 0) {

                int diseaseID = input.nextInt();
                Disease disease = data.retrieveDiseaseBy(diseaseID);
                if (disease != null) {

                    System.out.printf("Successfully added %s\n", disease.getName());
                    patient.getDiseasesList().add(diseaseID);

                } else {

                    System.out.println("We have no records of such disease yet!");

                }

                numOfDiseases--;

            }
        }


    }

    public static void viewPatientRecords(Patient patient) {

        System.out.println("Your current medication are:");
        String string = "";
        Iterator<Integer> it = patient.getMedicationsList().iterator();
        while (it.hasNext()) {

            Medication medication = data.retrieveMedicationBy(it.next());
            string += medication.toString();

        }
        System.out.println(string);


        System.out.println("Your current diseases are:");
        string = "";
        it = patient.getDiseasesList().iterator();
        while (it.hasNext()) {

            Medication disease = data.retrieveMedicationBy(it.next());
            string += disease.toString();

        }
        System.out.println(string);


    }

    public static void readData() throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File("src/data.json")).useDelimiter("\\Z");
        String currentJSONData = fileScanner.next();
        data = json.fromJson(currentJSONData, Data.class);

        fileScanner.close();

    }

    public static void writeData() throws IOException {

        FileWriter writer = new FileWriter("src/data.json");
        writer.write(json.toJson(data));
        writer.close();
    }

    public void test() throws IOException {

        int patientID1 = data.createPatient("C", "C", 18, 0, 80, 175);
        int patientID2 = data.createPatient("D", "D", 52, 1, 63.5, 153.5);
        int patientID3 = data.createPatient("E", "E", 9, 1, 32.43, 120.75);

        int phyID1 = data.createPhysician("A", "A");
        int phyID2 = data.createPhysician("B", "B");

        data.addPatient(phyID1, patientID1);
        data.addPatient(phyID1, patientID2);
        data.addPatient(phyID2, patientID3);

        data.createMedication("Insulin", 2);
        data.createMedication("Valium", 0);
        int hydroxyID = data.createMedication("HydroxyChloroquine", -1);

        data.createDisease("Malaria", hydroxyID);
        data.createDisease("nCovid19", -1);

        writeData();

    }

}

