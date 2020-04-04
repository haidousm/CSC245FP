# LAU CSC245 Final Project

## Electronic Medical Record System

---

This project will consist of 3 main components:

    - Physician Component
    - Patient Component
    - Lab Technician Component
  
Moreover, the data for this project will be supplied as JSON files. *Might hook it up to a database later on (either relational or non-relational).*

This project will also include a **Graphical User Interface**.

### General Files

    - [X] Create abstract User class that includes all the basic properties (ID, first name, last name, etc..)
    - [X] Create Medication class that includes the *medication ID*, *medication name*, and any possible adverse medications.

### Physician Component

    - [ ] Create IPrescribeMedication that 
        - [ ] allows physicians to check current medication repository if the wanted medication is found
        - [ ] check against any adverse medication the patient might have
    - [X] Create Physician class that extends the User class, implements IPrescribeMedication interface and includes two extra properties, *current patients list*, and the *current medication repository*.
    - [X] Create a General Practitioner class that extends the generic Physician class and contains job-specific functions.
    - [X] Create a Radiologist class that extends the generic Physician class and contains job-specific functions.
    - [X] Create a Cardiologist class that extends the generic Physician class and contains job-specific functions.

### Patient Component

    - [X] Create Patient that contains general information about patient's Diseases and list of Medications 
  
#### Lab Technician Component

    - [X] Create TestLab class that allows lab to enter and generate lab reports

### Reports

    - ConsultationPhysicalReport
    
    Includes a history of the present illness, past medical history, social history, and family medical history. Smoking can go under the heading of either Social History or Habits. There is usually a review of systems and a complete physical examination from head to toe. The report usually ends with an admission diagnosis and a plan for the patient treatment.

    - Radiology Report
This report is dictated by the radiologist upon completion of a diagnostic procedure and includes the radiologist’s findings and impression. Examples of radiology reports are x-rays, CT scans, MRI scans, nuclear medicine procedures and fluoroscopic studies.

    - Laboratory reports
This report describes findings of examinations of bodily fluids such as blood levels and urinalysis. Laboratory reports are rarely dictated separately but are often included inside the H&P, consultation or discharge summary.

    - [X] Create report classes

### GUI

    - [ ] allow new user creation as any of the possible components.
    - [ ] allow physicians to view all their patients' data & prescribe them medication.
    - [ ] allow patients read-only access (view their medications & data)
    - [ ] allow lab technicians to add medications to the repository in addition to modify patient data (BP, lab values..)
