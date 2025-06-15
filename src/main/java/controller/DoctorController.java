package controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import repository.UserRepository;

@RestController
@RequestMapping("/api/doctors")
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorController {
	private final UserRepository userRepository;

	public DoctorController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping
	public List<User> getDoctors() {
		return userRepository.findByRoleRoleName("DOCTOR");
	}
}
