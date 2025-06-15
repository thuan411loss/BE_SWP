package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}
}
