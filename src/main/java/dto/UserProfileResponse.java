package dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {
	private String fullName;
	private String gender;
	private LocalDate dateOfBirth;
	private String phone;
	private String email;
	private String address;
	private String role;
	private String username;

}