# Electronic Medical Record System
## LAU CSC245 Final Project

---

This project will consist of 4 main components:

    - Physician Component
    - Patient Component
    - Lab Technician Component
    - Model Component
  
Moreover, we'll achieve data persistence throughout this project in the form of JSON files.

### General Files

    - [X] Create abstract User class that includes all the basic properties (ID, first name, last name, etc..)

### Physician Component

    - [X] Create IPrescribeMedication that 
        - [X] allows physicians to check current medication repository if the wanted medication is found.
        - [X] check against any adverse medication the patient might have.
    - [X] Create Physician class that extends the User class, implements IPrescribeMedication interface and includes two extra properties, *current patients list*, and the *current medication repository*.
  

### Patient Component

    - [X] Create Patient that contains general information about patient's diseases and medication. 
  
### Lab Technician Component

    - [X] Create Lab Technician class that extends User.
    - [X] Create IAddNewDisease interface that permits the lab tech. to add new diseases to the repository.
    - [X] Create IAddNewMedication interface that permits the lab tech. to add new medication to the repository.
    - [X] Create Medication class that includes the *medication ID*, *medication name*.
    - [X] Create Disease class that includes the disease name along with any possible medication / treatment.

### Model Component
    
    Will take care of all data-related functionality in the project and contains:
        
        - [X] Data class. It is the model data class (please find below model data file design)
        - [X] DataController class. It permits all other components to transmit and recieve data
        - [X] data.json file that stores all the data as json
 
### Data Model Design

    
  ```json
        {
          "userIDCount": 4, // maintains next ID to be used
          "physicianHashMap": {
            "2": {
              "patientList": [ // patients stored as IDs instead of fully fledged objects to maintain flatness of json file
                2,              //efficient retrieval, and smaller file size (avoids duplicates)
              ],
              "ID": 4,
              "firstName": "A",
              "lastName": "A"
            }
          },
          "patientHashMap": {
            "1": {
              "diseasesList": [1, 2],
              "medicationsList": [2, 3],
              "age": 18,
              "gender": 0,
              "weight": 80.0,
              "height": 175.0,
              "ID": 1,
              "firstName": "C",
              "lastName": "C"
            }
          },
          "labTechnicianHashMap": {
            "3": {
              "ID": 6,
              "firstName": "L",
              "lastName": "L"
            }
          },
          "medicationIDCount": 4,
          "medicationHashMap": {
            "1": {
              "medicationID": 1,
              "medicationName": "Insulin",
              "adverseMedicationID": 2
            },
            "2": {
              "medicationID": 2,
              "medicationName": "Valium",
              "adverseMedicationID": 1
            },
            "3": {
              "medicationID": 3,
              "medicationName": "HydroxyChloroquine",
              "adverseMedicationID": -1 // -1 is no adverse medication
            }
          },
          "diseaseIDCount": 3,
          "diseaseHashMap": {
            "1": {
              "ID": 1,
              "name": "Malaria",
              "medicationID": 3
            },
            "2": {
              "ID": 2,
              "name": "nCovid19",
              "medicationID": -1 // -1 is no medication found
            }
          }
        }
   ```
