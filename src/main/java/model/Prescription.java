package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "prescription")
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prescription_id")
	private Integer prescriptionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "result_id")
	private MedicalResults medicalResults;

	@Column(name = "medicine_name")
	private String medicineName;

	@Column(name = "dosage", length = 100)
	private String dosage;

	@Column(name = "usage_instruction", columnDefinition = "TEXT")
	private String usageInstruction;

	// Constructors
	public Prescription() {
	}

	// Getters and Setters
	public Integer getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public MedicalResults getMedicalResult() {
		return medicalResults;
	}

	public void setMedicalResult(MedicalResults medicalResults) {
		this.medicalResults = medicalResults;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getUsageInstruction() {
		return usageInstruction;
	}

	public void setUsageInstruction(String usageInstruction) {
		this.usageInstruction = usageInstruction;
	}
}
