package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;

import java.util.List;

public interface BookingLogService {

    BookingLog addLog(Long bookingId, String message);
    
    BookingLog addLog(Booking booking, String message);

    List<BookingLog> getLogsByBooking(Long bookingId);
}
