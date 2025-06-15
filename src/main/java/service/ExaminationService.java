package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Examination;
import repository.ExaminationRepository;

@Service
public class ExaminationService {

	@Autowired
	ExaminationRepository examinationRepository;

	public List<Examination> findAll() {
		return examinationRepository.findAll();
	}

	public Examination findById(int id) {
		return examinationRepository.findById(id).orElse(null);
	}

	public Examination save(Examination examination) {
		return examinationRepository.save(examination);
	}

	public void delete(int id) {
		examinationRepository.deleteById(id);
	}
}
