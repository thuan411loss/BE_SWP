package model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Examination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer exam_id;

	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;

	private LocalDateTime exam_date;

	@Column(columnDefinition = "TEXT")
	private String diagnosis;

	@Column(columnDefinition = "TEXT")
	private String recommendation;

}
