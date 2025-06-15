package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.MedicalResults;

@Repository
public interface MedicalResultsRepository extends JpaRepository<MedicalResults, Integer> {
}
