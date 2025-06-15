package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.TreatmentSchedules;

@Repository
public interface TreatmentSchedulesRepository extends JpaRepository<TreatmentSchedules, Integer> {
}
