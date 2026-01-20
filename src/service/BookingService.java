package service;

import entities.ClassBooking;
import entities.FitnessClass;
import entities.Member;
import exception.BookingAlreadyExistsException;
import exception.ClassFullException;
import exception.MembershipExpiredException;
import repositories.ClassBookingRepository;

public class BookingService {
    private final ClassBookingRepository bookingRepository;
    public BookingService(ClassBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    public void bookClass(Member member, FitnessClass fitnessClass){

        if (member.isExpired()) throw new MembershipExpiredException();
        if (bookingRepository.exists(member.getId(), fitnessClass.getId())) {
            throw new BookingAlreadyExistsException();
        }
        int bookedCount =
                bookingRepository.countByFitnessClassId(fitnessClass.getId());

        if (bookedCount >= fitnessClass.getMaxPlaces()){
            throw new ClassFullException();
        }
        ClassBooking booking = new ClassBooking(member, fitnessClass);

        bookingRepository.save(booking);
    }
}
