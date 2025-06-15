package dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
	@NotBlank(message = "Họ tên không được để trống")
	private String fullName;

	private String gender;

	private LocalDate dateOfBirth;

	@Pattern(regexp = "^[0-9+\\-\\s]{10,15}$", message = "Số điện thoại không hợp lệ")
	private String phone;

	@Email(message = "Email không hợp lệ")
	@NotBlank(message = "Email không được để trống")
	private String email;

	private String address;

	@NotBlank(message = "Username không được để trống")
	@Size(min = 3, max = 50, message = "Username phải từ 3-50 ký tự")
	private String username;

	@NotBlank(message = "Password không được để trống")
	@Size(min = 6, message = "Password phải ít nhất 6 ký tự")
	private String password;

	private Integer roleId = 3; // Default role USER

}