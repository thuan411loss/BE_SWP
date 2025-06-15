package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String fullName;
	private String role;
	private String email;

	public AuthResponse(String token, String type, String username, String fullName, String role, String email) {
		super();
		this.token = token;
		this.type = type;
		this.username = username;
		this.fullName = fullName;
		this.role = role;
		this.email = email;
	}

}
