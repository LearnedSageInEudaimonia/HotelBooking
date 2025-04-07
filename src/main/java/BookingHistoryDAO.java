import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Timestamp;

public class BookingHistoryDAO {
    public static void insertBooking(String username, int roomNumber, LocalDateTime checkIn, LocalDateTime checkOut) {
        String sql = "INSERT INTO booking_history (username, room_number, check_in, check_out) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setInt(2, roomNumber);
            stmt.setTimestamp(3, Timestamp.valueOf(checkIn));
            stmt.setTimestamp(4, Timestamp.valueOf(checkOut));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting booking: " + e.getMessage());
        }
    }
}
