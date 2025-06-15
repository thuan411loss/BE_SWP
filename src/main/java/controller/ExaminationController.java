package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Examination;
import service.ExaminationService;

@RestController
@RequestMapping("/api/examinations")
public class ExaminationController {

	@Autowired
	ExaminationService examinationService;

	@GetMapping
	public List<Examination> getAll() {
		return examinationService.findAll();
	}

	@GetMapping("/{id}")
	public Examination get(@PathVariable int id) {
		return examinationService.findById(id);
	}

	@PostMapping
	public Examination create(@RequestBody Examination examination) {
		return examinationService.save(examination);
	}

	@PutMapping("/{id}")
	public Examination update(@PathVariable int id, @RequestBody Examination examination) {
		examination.setExamId(id);
		return examinationService.save(examination);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		examinationService.delete(id);
	}
}
