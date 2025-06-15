package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.TreatmentService;

@Repository
public interface TreatmentServiceRepository extends JpaRepository<TreatmentService, Integer> {
    List<TreatmentService> findByIsActiveTrue();

    List<TreatmentService> findByServiceNameContainingIgnoreCase(String keyword);
}