package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String fullName;
	private String role;
	private String email;

	public AuthResponse(String token, String username, String fullName, String role, String email) {
		this.token = token;
		this.username = username;
		this.fullName = fullName;
		this.role = role;
		this.email = email;
	}
}
