import java.sql.*;

public class ReportManager {

    public static void showAllBookings() {
        String query = "SELECT * FROM booking_history";

        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\n--- All Booking History ---");
            while (rs.next()) {
                System.out.printf("ID: %d | User: %s | Room: %d | In: %s | Out: %s\n",
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("room_number"),
                        rs.getTimestamp("check_in"),
                        rs.getTimestamp("check_out"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching booking history: " + e.getMessage());
        }
    }

    public static void showBookingsByUser(String username) {
        String query = "SELECT * FROM booking_history WHERE username = ?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\n--- Bookings for " + username + " ---");
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.printf("Room: %d | In: %s | Out: %s\n",
                            rs.getInt("room_number"),
                            rs.getTimestamp("check_in"),
                            rs.getTimestamp("check_out"));
                }
                if (!found) {
                    System.out.println("No bookings found for this user.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching user history: " + e.getMessage());
        }
    }
}
