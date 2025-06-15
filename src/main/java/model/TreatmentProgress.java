package model;

import java.time.LocalDate;

import javax.management.Notification;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "treatment_progress")
public class TreatmentProgress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "progress_id")
	private Integer progressId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id")
	private TreatmentSchedules treatmentSchedule;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "activity", columnDefinition = "TEXT")
	private String activity;

	@Column(name = "doctor_note", columnDefinition = "TEXT")
	private String doctorNote;

	@Column(name = "status", length = 50)
	private String status;

	@OneToMany(mappedBy = "treatmentProgress", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Notification> notifications;

	// Constructors
	public TreatmentProgress() {
	}

	// Getters and Setters
	public Integer getProgressId() {
		return progressId;
	}

	public void setProgressId(Integer progressId) {
		this.progressId = progressId;
	}

	public TreatmentSchedules getTreatmentSchedule() {
		return treatmentSchedule;
	}

	public void setTreatmentSchedule(TreatmentSchedules treatmentSchedule) {
		this.treatmentSchedule = treatmentSchedule;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDoctorNote() {
		return doctorNote;
	}

	public void setDoctorNote(String doctorNote) {
		this.doctorNote = doctorNote;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
}
