package model;

import java.time.LocalDate;
import java.util.List;

import javax.management.Notification;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
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

}
