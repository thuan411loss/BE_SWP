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

@Entity
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

	// Constructors
	public MedicalResults() {
	}

	// Getters and Setters
	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public LocalDate getResultDate() {
		return resultDate;
	}

	public void setResultDate(LocalDate resultDate) {
		this.resultDate = resultDate;
	}

	public User getStaff() {
		return staff;
	}

	public void setStaff(User staff) {
		this.staff = staff;
	}

	// Additional getters and setters for relationships...
}
