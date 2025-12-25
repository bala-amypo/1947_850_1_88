package com.example.demo.service.impl;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.service.BookingLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository bookingLogRepository;

    public BookingLogServiceImpl(BookingLogRepository bookingLogRepository) {
        this.bookingLogRepository = bookingLogRepository;
    }

    @Override
    public BookingLog addLog(Booking booking, String message) {
        BookingLog log = new BookingLog();
        log.setBooking(booking);
        log.setLogMessage(message);
        log.setLoggedAt(LocalDateTime.now()); // ensure BookingLog entity has this field
        return bookingLogRepository.save(log);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Booking booking) {
        return bookingLogRepository.findByBookingOrderByLoggedAtAsc(booking);
    }
}
