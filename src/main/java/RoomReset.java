
import java.sql.*;
        import java.time.LocalDateTime;
import java.util.List;

public class RoomReset {

    public static void resetRoomsIfCheckoutPassed(List<Room> rooms) {
        String query = "SELECT room_number, check_out FROM booking_history";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int roomNo = rs.getInt("room_number");
                Timestamp checkout = rs.getTimestamp("check_out");

                if (checkout != null && checkout.toLocalDateTime().isBefore(LocalDateTime.now())) {
                    for (Room room : rooms) {
                        if (room.getRoomNumber() == roomNo) {
                            room.setBooked(false);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error during room reset: " + e.getMessage());
        }
    }
}
