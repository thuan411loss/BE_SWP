package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.MedicalResults;
import repository.MedicalResultsRepository;

@Service
public class MedicalResultsService {

	@Autowired
	MedicalResultsRepository medicalResultsRepository;

	public List<MedicalResults> findAll() {
		return medicalResultsRepository.findAll();
	}

	public MedicalResults findById(int id) {
		return medicalResultsRepository.findById(id).orElse(null);
	}

	public MedicalResults save(MedicalResults result) {
		return medicalResultsRepository.save(result);
	}

	public void delete(int id) {
		medicalResultsRepository.deleteById(id);
	}
}
