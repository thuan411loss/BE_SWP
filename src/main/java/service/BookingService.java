package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Booking;
import repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	public Booking findById(int id) {
		return bookingRepository.findById(id).orElse(null);
	}

	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	public void delete(int id) {
		bookingRepository.deleteById(id);
	}
}
