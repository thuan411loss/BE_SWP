package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.TreatmentProgress;

@Repository
public interface TreatmentProgressRepository extends JpaRepository<TreatmentProgress, Integer> {
}
