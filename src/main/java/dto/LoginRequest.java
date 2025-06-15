package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class LoginRequest {
	@NotBlank(message = "Username không được để trống")
	private String username;

	@NotBlank(message = "Password không được để trống")
	private String password;

}
