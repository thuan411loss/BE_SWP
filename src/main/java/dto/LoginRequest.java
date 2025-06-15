package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
	@NotBlank(message = "Username không được để trống")
	private String username;

	@NotBlank(message = "Password không được để trống")
	private String password;

	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
