package model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "treatment_schedules")
public class TreatmentSchedules {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private Integer scheduleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "result_id")
	private MedicalResults medicalResults;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "status", length = 50)
	private String status;

	@Column(name = "notes", columnDefinition = "TEXT")
	private String notes;

	@OneToMany(mappedBy = "treatmentSchedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TreatmentProgress> treatmentProgresses;

	// Constructors
	public TreatmentSchedules() {
	}

	// Getters and Setters
	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public MedicalResults getMedicalResult() {
		return medicalResults;
	}

	public void setMedicalResult(MedicalResults medicalResults) {
		this.medicalResults = medicalResults;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<TreatmentProgress> getTreatmentProgresses() {
		return treatmentProgresses;
	}

	public void setTreatmentProgresses(List<TreatmentProgress> treatmentProgresses) {
		this.treatmentProgresses = treatmentProgresses;
	}
}