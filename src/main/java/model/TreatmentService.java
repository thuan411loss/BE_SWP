package model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TreatmentService")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
	private Integer serviceId;

	@Column(name = "service_name", nullable = false)
	private String serviceName;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "duration_minutes")
	private Integer durationMinutes;

	@Column(name = "is_active")
	private Boolean isActive = true;
}
