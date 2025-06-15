package dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserProfileResponse {
	private String fullName;
	private String gender;
	private LocalDate dateOfBirth;
	private String phone;
	private String email;
	private String address;
	private String role;
	private String username;

	public UserProfileResponse(String fullName, String gender, LocalDate dateOfBirth, String phone, String email,
			String address, String role, String username) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.role = role;
		this.username = username;
	}

	public void setUsername(String username2) {
		// TODO Auto-generated method stub

	}

}