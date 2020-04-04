package lab_tech_component.reports;

import patient_component.Patient;

public class LabReport extends MedicalReport{

	private double HDL;
	private double LDL;
	private double sodium;
	private double glycemia;
	private double hemoglobin;
	private String testDate, Specimen;
	public LabReport(int report_ID, String type, Patient patient, int freqOfTreatment, String dateOfLastVisit,
			double hDL, double lDL, double sodium, double glycemia, double hemoglobin, String testDate,
			String specimen) {
		super(report_ID, type, patient, freqOfTreatment, dateOfLastVisit);
		HDL = hDL;
		LDL = lDL;
		this.sodium = sodium;
		this.glycemia = glycemia;
		this.hemoglobin = hemoglobin;
		this.testDate = testDate;
		Specimen = specimen;
	}
	public double getHDL() {
		return HDL;
	}
	public void setHDL(double hDL) {
		HDL = hDL;
	}
	public double getLDL() {
		return LDL;
	}
	public void setLDL(double lDL) {
		LDL = lDL;
	}
	public double getSodium() {
		return sodium;
	}
	public void setSodium(double sodium) {
		this.sodium = sodium;
	}
	public double getGlycemia() {
		return glycemia;
	}
	public void setGlycemia(double glycemia) {
		this.glycemia = glycemia;
	}
	public double getHemoglobin() {
		return hemoglobin;
	}
	public void setHemoglobin(double hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getSpecimen() {
		return Specimen;
	}
	public void setSpecimen(String specimen) {
		Specimen = specimen;
	}
	
	public void printReport() {
		System.out.println(this.toString());
	}
	public String toString() {
		return String.format("Lab Report #%d\nReport Type: %s\nTest taken: %s\nPatient Info:\n%s\n\nReport:"
				+ "Specimen Taken: %s\nHDL Level: %.2f\nLDL Level: %.2f\nSodium Level: %.2f\nGlycemia: %.2f\nHB Level: %.2f"
				, this.getReport_ID(),this.getType(),this.getTestDate(),this.getPatient().toString(),this.Specimen,
				this.HDL,this.LDL,this.sodium,this.glycemia,this.hemoglobin);
	}
	
	
	
	
	
	

}
