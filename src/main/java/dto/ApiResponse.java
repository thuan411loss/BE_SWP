package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
	private String status;
	private String message;

	public ApiResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}
