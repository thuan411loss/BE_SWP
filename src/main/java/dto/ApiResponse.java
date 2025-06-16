package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ApiResponse {
	private String status;
	private String message;

	public ApiResponse(String status) {
		this.status = status;
		this.message = null; // Default message is null
	}

}
