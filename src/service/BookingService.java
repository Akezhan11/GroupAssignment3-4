package service;

import entities.ClassBooking;
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
    public void bookClass(Member member, ClassBooking booking){
        if (member.isExpired()) throw new MembershipExpiredException();
        if (!booking.hasFreePlaces()) throw new ClassFullException();
        for (ClassBooking b : bookingRepository.findAll()) {
            if (b.equals(booking)) {
                throw new BookingAlreadyExistsException();
            }
        }
        booking.bookPlace();
        bookingRepository.save(booking);
    }
}
