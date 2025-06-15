package model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private User customer;

	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false)
	private TreatmentService service;

	@ManyToOne
	@JoinColumn(name = "work_id", nullable = false)
	private WorkSchedule work;

	@Column(name = "booking_date")
	private LocalDateTime bookingDate = LocalDateTime.now();

	@Column(name = "status", length = 20)
	private String status = "PENDING";

	@Column(columnDefinition = "TEXT")
	private String note;

}
