//package lab_tech_component.reports;
//import patient_component.Patient;
//import java.util.Iterator;
//import lab_tech_component.Medication;
//import lab_tech_component.interfaces.*;
//
//
//public abstract class MedicalReport implements IGenerateReport {
//
//	private int report_ID;
//	private String type;
//	private Patient patient;
//	private int freqOfTreatment;
//	private String dateOfLastVisit;
//	public MedicalReport(int report_ID, String type, Patient patient, int freqOfTreatment, String dateOfLastVisit) {
//		super();
//		this.report_ID = report_ID;
//		this.type = type;
//		this.patient = patient;
//		this.freqOfTreatment = freqOfTreatment;
//		this.dateOfLastVisit = dateOfLastVisit;
//	}
//	public MedicalReport(int report_ID, String type, Patient patient) {
//		super();
//		this.report_ID = report_ID;
//		this.type = type;
//		this.patient = patient;
//	}
//
//
//
//	public int getReport_ID() {
//		return report_ID;
//	}
//	public void setReport_ID(int report_ID) {
//		this.report_ID = report_ID;
//	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public Patient getPatient() {
//		return patient;
//	}
//	public void setPatient(Patient patient) {
//		this.patient = patient;
//	}
//	public int getFreqOfTreatment() {
//		return freqOfTreatment;
//	}
//	public void setFreqOfTreatment(int freqOfTreatment) {
//		this.freqOfTreatment = freqOfTreatment;
//	}
//	public String getDateOfLastVisit() {
//		return dateOfLastVisit;
//	}
//	public void setDateOfLastVisit(String dateOfLastVisit) {
//		this.dateOfLastVisit = dateOfLastVisit;
//	}
//
//	@Override
//	public String toString() {
//		return "MedicalReport [report_ID=" + report_ID + ", type=" + type + ", patient=" + patient
//				+ ", freqOfTreatment=" + freqOfTreatment + ", dateOfLastVisit=" + dateOfLastVisit + "]";
//	}
//
//	public boolean checkMedication(String med) {
//		if(this.getPatient().getMeds().equalsIgnoreCase(med))
//			return true;
//
//		Iterator<Medication> iter = this.getPatient().getMedicationsList().iterator();
//		while(iter.hasNext()) {
//			Medication curr = iter.next();
//			if(curr.getMedicationName().equalsIgnoreCase(med))
//				return true;
//		}
//
//		return false;
//
//	}
//
//
//
//
//}
