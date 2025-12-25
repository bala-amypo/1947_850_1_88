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
        log.setLoggedAt(LocalDateTime.now()); // make sure your entity has this field
        return bookingLogRepository.save(log);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Booking booking) {
        return bookingLogRepository.findByBookingOrderByLoggedAtAsc(booking);
    }
}
