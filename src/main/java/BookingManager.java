import java.time.LocalDateTime;

public class BookingManager {
    private final Hotel hotel;

    public BookingManager(Hotel hotel) {
        this.hotel = hotel;
    }

    public void bookRoom(String userName){
        Room room = hotel.bookRoom();
        if(room != null){
            System.out.println(userName + " Successfully booked Room " + room.getRoomNumber());
            LocalDateTime checkIn = LocalDateTime.now();
            LocalDateTime checkOut = checkIn.plusDays(1);
            BookingHistoryDAO.insertBooking(userName,room.getRoomNumber(),checkIn,checkOut);
        }else{
            System.out.println(userName + " failed to book a room- no availability.");
        }
    }
}
