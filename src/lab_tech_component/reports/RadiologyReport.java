package lab_tech_component.reports;

import patient_component.Patient;

public class RadiologyReport extends MedicalReport {

	private String scanType;
	private String region;
	private String reason;
	
	public RadiologyReport(int report_ID, String type, Patient patient, int freqOfTreatment, String dateOfLastVisit,
			String scanType, String region, String reason) {
		super(report_ID, type, patient, freqOfTreatment, dateOfLastVisit);
		this.scanType = scanType;
		this.region = region;
		this.reason = reason;
	}
	public String getScanType() {
		return scanType;
	}
	public void setScanType(String scanType) {
		this.scanType = scanType;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public void printReport() {
		System.out.println(this.toString());
	}
	
	public String toString() {
		return String.format("\nReport ID:" + getReport_ID() + "\nReport Type: " + getType()
				 + "\nFrequency of Visit: " + getFreqOfTreatment()
				+ "\nLast Visit: " + getDateOfLastVisit() + "\nPatient:\n" + getPatient().toString()+
				"Scan: %s\tRegion Scanned: %s\tReason for Scan: %s",this.getScanType(),this.getRegion(),this.getReason());
		
	}

	
}
