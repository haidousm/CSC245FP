package lab_tech_component.reports;

import patient_component.Patient;
import lab_tech_component.interfaces.IGenerateReport;


public class PhysicalConsultationReport extends MedicalReport implements IGenerateReport {

	public PhysicalConsultationReport(int report_ID, String type, Patient patient, int freqOfTreatment,
			String dateOfLastVisit) {
		super(report_ID, type, patient, freqOfTreatment, dateOfLastVisit);
		
	}
	
	
	public void printReport() {
		System.out.println(this.toString());
	}
	
	

	public String toString() {
		return String.format("\nReport ID:" + getReport_ID() + "\nReport Type: " + getType()
				 + "\nFrequency of Visit: " + getFreqOfTreatment()
				+ "\nLast Visit: " + getDateOfLastVisit() + "\nPatient:\n" + getPatient().toString());
	}


	

	
	

}
