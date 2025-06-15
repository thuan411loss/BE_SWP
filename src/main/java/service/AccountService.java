package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.AuthResponse;
import dto.LoginRequest;
import dto.RegisterRequest;
import dto.UserProfileResponse;
import model.Account;
import repository.AccountRepository;
import repository.UserRepository;
import util.JwtUtil;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	public AuthResponse login(LoginRequest request) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

			Account account = accountRepository.findByUsername(request.getUsername())
					.orElseThrow(() -> new BadCredentialsException("Tài khoản không tồn tại"));

			String token = jwtUtil.generateToken(account.getUsername());

			return new AuthResponse(token, account.getUsername(), account.getUser().getFullName(),
					account.getUser().getRole().getRoleName(), account.getUser().getEmail());

		} catch (Exception e) {
			throw new BadCredentialsException("Tên đăng nhập hoặc mật khẩu không đúng");
		}
	}

	@Transactional
	public String register(RegisterRequest request) {
		// Kiểm tra username đã tồn tại
		if (accountRepository.existsByUsername(request.getUsername())) {
			throw new RuntimeException("Username đã tồn tại");
		}

		// Kiểm tra email đã tồn tại
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email đã được sử dụng");
		}

		// Kiểm tra phone nếu có
		if (request.getPhone() != null && userRepository.existsByPhone(request.getPhone())) {
			throw new RuntimeException("Số điện thoại đã được sử dụng");
		}

		// Tạo User
		User user = new User();
		user.setFullName(request.getFullName());
		user.setGender(request.getGender());
		user.setDateOfBirth(request.getDateOfBirth());
		user.setPhone(request.getPhone());
		user.setEmail(request.getEmail());
		user.setAddress(request.getAddress());

		// Set default role
		Role role = new Role();
		role.setRoleId(request.getRoleId());
		user.setRole(role);

		User savedUser = userRepository.save(user);

		// Tạo Account
		Account account = new Account();
		account.setUser(savedUser);
		account.setUsername(request.getUsername());
		account.setPasswordHash(passwordEncoder.encode(request.getPassword()));

		accountRepository.save(account);

		return "Đăng ký thành công";
	}

	public String logout() {
		return "Đăng xuất thành công";
	}

	public UserProfileResponse getCurrentUserProfile() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		Account account = accountRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Tài khoản không tồn tại"));

		UserProfileResponse profile = new UserProfileResponse();
		User user = account.getUser();
		profile.setFullName(user.getFullName());
		profile.setGender(user.getGender());
		profile.setDateOfBirth(user.getDateOfBirth());
		profile.setPhone(user.getPhone());
		profile.setEmail(user.getEmail());
		profile.setAddress(user.getAddress());
		profile.setRole(user.getRole().getRoleName());
		profile.setUsername(account.getUsername());

		return profile;
	}
}
