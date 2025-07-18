package model;

import java.time.LocalDate;
import java.util.List;

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
@Table(name = "medical_results")
public class MedicalResults {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "result_id")
	private Integer resultId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exam_id", nullable = false)
	private Examination examination;

	@Column(name = "test_name", length = 100)
	private String testName;

	@Column(name = "result_value")
	private String resultValue;

	@Column(name = "result_date")
	private LocalDate resultDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	private User staff;

	@OneToMany(mappedBy = "medicalResult", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TreatmentSchedules> treatmentSchedules;

	@OneToMany(mappedBy = "medicalResult", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Prescription> prescriptions;

	@OneToMany(mappedBy = "medicalResult", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TreatmentRecord> treatmentRecords;

}
