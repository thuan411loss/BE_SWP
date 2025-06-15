package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Booking;
import service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@GetMapping
	public List<Booking> getAll() {
		return bookingService.findAll();
	}

	@GetMapping("/{id}")
	public Booking get(@PathVariable int id) {
		return bookingService.findById(id);
	}

	@PostMapping
	public Booking create(@RequestBody Booking booking) {
		return bookingService.save(booking);
	}

	@PutMapping("/{id}")
	public Booking update(@PathVariable int id, @RequestBody Booking booking) {
		booking.setBookingId(id);
		return bookingService.save(booking);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		bookingService.delete(id);
	}
}
