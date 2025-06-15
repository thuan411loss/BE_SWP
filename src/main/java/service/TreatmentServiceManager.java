package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.TreatmentService;
import repository.TreatmentServiceRepository;

@Service
public class TreatmentServiceManager {

	@Autowired
	private TreatmentServiceRepository treatmentServiceRepository;

	public List<TreatmentService> getAllActiveServices() {
		return treatmentServiceRepository.findByIsActiveTrue();
	}

	public List<TreatmentService> searchServices(String keyword) {
		return treatmentServiceRepository.findByServiceNameContainingIgnoreCase(keyword);
	}
}