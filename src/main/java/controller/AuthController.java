package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.ApiResponse;
import dto.AuthResponse;
import dto.LoginRequest;
import dto.RegisterRequest;
import dto.UserProfileResponse;
import jakarta.validation.Valid;
import service.AccountService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
		try {
			// Debug logging
			System.out.println("=== LOGIN DEBUG ===");
			System.out.println("Received login request:");
			System.out.println("Username: " + request.getUsername());
			System.out.println("Password length: "
					+ (request.getPassword() != null ? ((String) request.getPassword()).length() : "null"));
			System.out.println("Request object: " + request);

			// Kiểm tra null values
			if (request.getUsername() == null || ((String) request.getUsername()).trim().isEmpty()) {
				System.out.println("ERROR: Username is null or empty");
				return ResponseEntity.badRequest().body(new ApiResponse("error", "Username không được để trống"));
			}

			if (request.getPassword() == null || ((String) request.getPassword()).trim().isEmpty()) {
				System.out.println("ERROR: Password is null or empty");
				return ResponseEntity.badRequest().body(new ApiResponse("error", "Password không được để trống"));
			}

			System.out.println("Calling accountService.login()...");
			AuthResponse response = accountService.login(request);
			System.out.println("Login successful for user: " + request.getUsername());

			return ResponseEntity.ok(response);

		} catch (Exception e) {
			System.out.println("LOGIN ERROR:");
			System.out.println("Exception type: " + e.getClass().getSimpleName());
			System.out.println("Error message: " + e.getMessage());
			e.printStackTrace();

			return ResponseEntity.badRequest().body(new ApiResponse("error", e.getMessage()));
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
		try {
			System.out.println("=== REGISTER DEBUG ===");
			System.out.println("Username: " + request.getUsername());
			System.out.println("Email: " + request.getEmail());

			String message = accountService.register(request);
			return ResponseEntity.ok(new ApiResponse("success", message));
		} catch (Exception e) {
			System.out.println("REGISTER ERROR: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse("error", e.getMessage()));
		}
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout() {
		String message = accountService.logout();
		return ResponseEntity.ok(new ApiResponse("success", message));
	}

	@GetMapping("/profile")
	public ResponseEntity<?> getProfile() {
		try {
			UserProfileResponse profile = accountService.getCurrentUserProfile();
			return ResponseEntity.ok(profile);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse("error", e.getMessage()));
		}
	}
}