import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import general_files.User;
import lab_tech_component.Disease;
import lab_tech_component.LabTechnician;
import lab_tech_component.Medication;
import model_component.DataController;
import org.jetbrains.annotations.NotNull;
import patient_component.Patient;
import physician_component.Physician;

import java.io.IOException;
import java.util.*;


public class Main {

    static Gson json = new GsonBuilder().setPrettyPrinting().create();
    static DataController dataController = new DataController();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        dataController.readData();

        init();
        //test();

        dataController.writeData();
        input.close();

    }

    // SignUp/SignIn Menu
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

    // Auth. Menu
    public static void signIn() {


        System.out.print("Please enter your ID: ");
        int ID = input.nextInt();
        User user = dataController.retrieveUserBy(ID);
        if (user != null) {

            authenticate(ID);

        } else {

            System.out.println("Wrong ID! Please try again later.");

        }


    }

    public static void signUp() {

        String phyOrPatient = "Are you a:\n\t1- Patient\n\t2- Physician\n\t3- Lab Technician\n\t0- Exit\n";
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

                int newPatientID = dataController.createPatient(fName, lName, age, gender, weight, height);

                System.out.printf("Thank you for signing up! Your ID is #%d.\nPlease save it since you'll need it to sign in later!\n", newPatientID);
                authenticate(newPatientID);
                break;
            case 2:
                int newPhysicianID = dataController.createPhysician(fName, lName);
                System.out.print("Would you like to add your patients now?\n\t1- Yes\n\t0- No\n");
                key = input.nextInt();

                if (key > 0) {

                    System.out.println("Please enter the number of patient (you can add more later): ");
                    int numOfPatients = input.nextInt();
                    System.out.println("Please enter your patient IDs separated by spaces:");
                    while (numOfPatients > 0) {

                        int patientID = input.nextInt();
                        dataController.addPatientToPhysician(newPhysicianID, patientID);
                        numOfPatients--;
                    }
                }

                System.out.printf("Thank you for signing up! Your ID is #%d.\nPlease save it since you'll need it to sign in later!\n", newPhysicianID);
                authenticate(newPhysicianID);
                break;
            case 3:
                int newLabTechnicianID = dataController.createLabTech(fName, lName);
                System.out.printf("Thank you for signing up! Your ID is #%d.\nPlease save it since you'll need it to sign in later!\n", newLabTechnicianID);
                authenticate(newLabTechnicianID);
                break;
            default:
                break;
        }


    }

    // Main Menu
    public static void authenticate(int userID) {

        User user = dataController.retrieveUserBy(userID);

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

                System.out.println("You currently have no medications saved at ***YourHealth Inc.***\nWould you like to add any?\n\t1- Yes\n\t0- No\n");
                int key = input.nextInt();
                if (key > 0) {
                    addMedicationToPatient(patient);
                }

            }

            if (patient.getDiseasesList().size() == 0) {

                System.out.println("There's no diseases attached to your record. We suggest adding some so that we can aid you better.\nWould you like to?\n\t1- Yes\n\t0- No\n");
                int key = input.nextInt();
                if (key > 0) {
                    addDiseaseToPatient(patient);
                }

            }

            int key = -1;

            while (key != 0) {

                System.out.print("What would you like to do?\n\t1- View Records\n\t2- Add Medications\n\t3- Add Diseases\n\t0- Exit\n");
                key = input.nextInt();

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
            }


        } else if (user instanceof Physician) {

            Physician physician = (Physician) user;

            System.out.printf("Welcome Dr. %s\n", physician.getLastName());

            if (physician.getPatientList().size() == 0) {

                noPatientPrompt(userID);

            }

            int key = -1;

            while (key != 0) {

                System.out.print("What would you like to do?\n\t1- View All Patients\n\t2- View Medication Repository\n\t3- Add Patients\n\t0- Exit\n");

                key = input.nextInt();

                switch (key) {

                    case 1:

                        if (physician.getPatientList().size() != 0) {
                            viewAllPatients(physician);
                            System.out.println("Please choose patient ID for more details or enter 0 to exit: ");
                            int patientID = input.nextInt();

                            if (patientID > 0) {

                                detailRecordOfPatientBy(physician, patientID);

                            }

                        } else {

                            noPatientPrompt(userID);

                        }

                        break;
                    case 2:

                        viewAllMedication();
                        break;
                    case 3:
                        addPatientToPhysician(userID);
                    default:
                        break;


                }

            }

        } else {

            LabTechnician labTechnician = (LabTechnician) user;
            System.out.printf("Welcome MLs. %s\n", labTechnician.getLastName());
            int key = -1;

            while (key != 0) {

                System.out.print("What would you like to do?\n\t1- View Medication Repository\n\t2- View Disease Repository\n\t3- Register New Medication\n\t4- Register New Disease\n\t0- Exit\n");
                key = input.nextInt();
                switch (key) {

                    case 1:
                        viewAllMedication();
                        break;
                    case 2:
                        viewAllDiseases();
                        break;
                    case 3:
                        System.out.print("Please enter Medication Name: ");
                        String newMedicationName = input.next();
                        System.out.print("Please enter adverse medication ID (if does not exist, enter -1): ");
                        int adverseMedicationID = input.nextInt();

                        dataController.addNewMedication(labTechnician.addNewMedication(dataController.getMedicationIDCount(), newMedicationName, adverseMedicationID));
                        System.out.printf("Successfully added %s to the Medication Repository.\n", newMedicationName);

                        break;
                    case 4:

                        System.out.print("Please enter Disease Name: ");
                        String newDiseaseName = input.next();
                        System.out.print("Please enter medication ID (if does not exist, enter -1): ");
                        int medicationID = input.nextInt();

                        dataController.addNewDisease(labTechnician.addNewDisease(dataController.getDiseaseIDCount(), newDiseaseName, medicationID));
                        System.out.printf("Successfully added %s to the Disease Repository.\n", newDiseaseName);

                        break;
                    default:
                        break;

                }

            }


        }


    }

    // Patient Menu
    public static void addMedicationToPatient(Patient patient) {


        System.out.print("Please enter the # of medications you'd like to add: ");
        int numOfMeds = input.nextInt();
        System.out.println("Please enter the medication IDs:");

        while (numOfMeds > 0) {

            int medicationID = input.nextInt();
            Medication medication = dataController.retrieveMedicationBy(medicationID);
            if (medication != null) {

                System.out.printf("Successfully added %s.\n", medication.getMedicationName());
                patient.getMedicationsList().add(medicationID);
            } else {

                System.out.println("This medication has not been added to our repository yet!");

            }

            numOfMeds--;

        }
    }

    public static void addDiseaseToPatient(Patient patient) {

            System.out.print("Please enter the # of diseases you'd like to add: ");
            int numOfDiseases = input.nextInt();
            System.out.println("Please enter the disease IDs:");

            while (numOfDiseases > 0) {

                int diseaseID = input.nextInt();
                Disease disease = dataController.retrieveDiseaseBy(diseaseID);
                if (disease != null) {

                    System.out.printf("Successfully added %s.\n", disease.getName());
                    patient.getDiseasesList().add(diseaseID);

                } else {

                    System.out.println("We have no records of such disease yet!");

                }

                numOfDiseases--;

            }

    }

    public static void viewPatientRecords(@NotNull Patient patient) {

        System.out.printf("Age: %d -- Gender: %d -- Weight: %.1f -- Height: %.1f\n", patient.getAge(), patient.getGender(), patient.getWeight(), patient.getHeight());
        System.out.println("Current medication are:");
        String string = "";
        Iterator<Integer> it = patient.getMedicationsList().iterator();
        while (it.hasNext()) {

            Medication medication = dataController.retrieveMedicationBy(it.next());
            string += medication.toString();

        }
        System.out.println(string);


        System.out.println("Current diseases are:");
        string = "";
        it = patient.getDiseasesList().iterator();
        while (it.hasNext()) {

            Disease disease = dataController.retrieveDiseaseBy(it.next());
            Medication medication = dataController.retrieveMedicationBy(disease.getMedicationID());
            if (medication != null) {

                string += disease.toString() + medication.toString() + "\n";

            } else {

                string += disease.toString() + "No medication currently exists\n";

            }

        }
        System.out.println(string);


    }

    // Physician Menu
    public static void addPatientToPhysician(int phyID) {

        System.out.print("Please enter the number of patients you'd like to add: ");
        int numOfPatients = input.nextInt();
        System.out.println("Please enter your patients' IDs separated by spaces.");
        while (numOfPatients > 0) {

            int patientID = input.nextInt();
            Patient patient = dataController.addPatientToPhysician(phyID, patientID);

            if (patient != null) {

                System.out.printf("Successfully added %s, %s to your records.\n", patient.getLastName(), patient.getFirstName());

            } else {

                System.out.println("We currently have no patient under this ID.\nPlease double check with your patient and try again later.");

            }

            numOfPatients--;

        }

    }

    public static void viewAllPatients(@NotNull Physician physician) {

        System.out.println("Your patients are:");

        ArrayList<Patient> patientList = new ArrayList<>();

        Iterator<Integer> it = physician.getPatientList().iterator();

        while (it.hasNext()) {

            int patientID = it.next();
            Patient patient = (Patient) dataController.retrieveUserBy(patientID);
            patientList.add(patient);
        }

        // sort alphabetically
        Collections.sort(patientList);

        Iterator<Patient> patientIterator = patientList.iterator();

        while (patientIterator.hasNext()) {

            System.out.print("\t" + patientIterator.next().toString());

        }


    }

    public static void detailRecordOfPatientBy(Physician physician, int patientID) {

        Patient patient = (Patient) dataController.retrieveUserBy(patientID);
        viewPatientRecords(patient);
        System.out.print("Would you like to prescribe any medication?\n\t1- Yes\n\t0- No\n");
        int key = input.nextInt();

        if (key > 0) {

            System.out.print("Please enter medication ID: ");
            int medID = input.nextInt();

            Medication medication = dataController.retrieveMedicationBy(medID);

            if (medication != null) {

                ArrayList<Medication> medications = new ArrayList<>();

                Iterator<Integer> it = patient.getMedicationsList().iterator();
                while (it.hasNext()) {

                    medications.add(dataController.retrieveMedicationBy(it.next()));

                }
                if (physician.prescribeMedication(patient, medications, medication)) {

                    System.out.printf("Successfully prescribed %s for Patient %s, %s.\n", medication.getMedicationName(), patient.getLastName(), patient.getFirstName());

                } else {

                    System.out.println("The medication you're prescribing is adverse to one of the patient's medication.");

                }


            } else {

                System.out.println("Please make sure the medication you're prescribing exists in our repository\n");

            }

        }

    }

    public static void noPatientPrompt(int phyID) {

        System.out.print("You currently have no patients in your records.\nWe recommend adding your patients so that you'll be able to assist them.\n");
        System.out.print("Would you like to add your patients?\n\t1- Yes\n\t2- No\n\t0- Exit\n");
        int key = input.nextInt();

        if (key == 1) {

            addPatientToPhysician(phyID);

        }

    }

    //Lab Tech. Menu
    public static void viewAllMedication() {

        System.out.println("Currently Available Medication are:");
        Medication[] medications = dataController.retrieveMedicationArray();

        Arrays.sort(medications);

        for (Medication medication : medications) {

            System.out.print("\t" + medication.toString());

        }

    }

    public static void viewAllDiseases() {

        System.out.println("Currently Registered Diseases are:");
        Disease[] diseases = dataController.retrieveDiseaseArray();

        Arrays.sort(diseases);

        for (Disease disease : diseases) {

            System.out.print("\t" + disease.toString());

        }

    }

    public static void test() throws IOException {

        int patientID1 = dataController.createPatient("C", "C", 18, 0, 80, 175);
        int patientID2 = dataController.createPatient("D", "D", 52, 1, 63.5, 153.5);
        int patientID3 = dataController.createPatient("E", "E", 9, 1, 32.43, 120.75);

        int phyID1 = dataController.createPhysician("A", "A");
        int phyID2 = dataController.createPhysician("B", "B");

        dataController.addPatientToPhysician(phyID1, patientID1);
        dataController.addPatientToPhysician(phyID1, patientID2);
        dataController.addPatientToPhysician(phyID2, patientID3);

        dataController.createMedication("Insulin", 2);
        dataController.createMedication("Valium", 0);
        int hydroxyID = dataController.createMedication("HydroxyChloroquine", -1);

        dataController.createDisease("Malaria", hydroxyID);
        dataController.createDisease("nCovid19", -1);

        dataController.writeData();

    }

}

