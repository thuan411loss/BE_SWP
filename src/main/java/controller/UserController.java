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

import model.User;
import service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getAll() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public User get(@PathVariable int id) {
		return userService.findById(id);
	}

	@PostMapping
	public User create(@RequestBody User user) {
		return userService.save(user);
	}

	@PutMapping("/{id}")
	public User update(@PathVariable int id, @RequestBody User user) {
		user.setUserId(id);
		return userService.save(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		userService.delete(id);
	}
}
