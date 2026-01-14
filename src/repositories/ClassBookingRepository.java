package repositories;
import java.util.List;
import entities.ClassBooking;

public interface ClassBookingRepository {
    void save(ClassBooking classBooking);
    List<ClassBooking> findAll();
}
