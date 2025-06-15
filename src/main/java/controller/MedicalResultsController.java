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

import model.MedicalResults;
import service.MedicalResultsService;

@RestController
@RequestMapping("/api/medical-results")
public class MedicalResultsController {

	@Autowired
	MedicalResultsService service;

	@GetMapping
	public List<MedicalResults> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public MedicalResults get(@PathVariable int id) {
		return service.findById(id);
	}

	@PostMapping
	public MedicalResults create(@RequestBody MedicalResults result) {
		return service.save(result);
	}

	@PutMapping("/{id}")
	public MedicalResults update(@PathVariable int id, @RequestBody MedicalResults result) {
		result.setResultId(id);
		return service.save(result);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
}
