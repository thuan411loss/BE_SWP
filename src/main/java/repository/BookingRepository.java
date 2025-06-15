package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
