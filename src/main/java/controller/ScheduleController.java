package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

	@GetMapping("/available")
	public ResponseEntity<?> getAvailableSchedules() {
		return ResponseEntity.ok("Lịch trống");
	}

	@PostMapping("/book")
	public ResponseEntity<?> bookSchedule(@RequestBody Object request) {
		return ResponseEntity.ok("Đặt lịch thành công");
	}
}