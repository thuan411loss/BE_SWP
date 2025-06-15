package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.TreatmentService;

@Repository
public interface TreatmentServiceRepository extends JpaRepository<TreatmentService, Integer> {
}