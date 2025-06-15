package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.TreatmentServiceRepository;

@Service
public class TreatmentService {

	@Autowired
	private TreatmentServiceRepository treatmentServiceRepository;

	public List<model.TreatmentService> getAllActiveServices() {
		return treatmentServiceRepository.findByIsActiveTrue();
	}

	public List<service.TreatmentService> searchServices(String keyword) {
		return (List<TreatmentService>) treatmentServiceRepository;
	}
}