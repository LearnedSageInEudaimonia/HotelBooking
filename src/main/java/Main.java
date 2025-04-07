import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Room> rooms = FileHandler.loadRooms();

        RoomReset.resetRoomsIfCheckoutPassed(rooms);
        FileHandler.saveRooms(rooms);

        if (rooms.isEmpty()) {
            for (int i = 1; i <= 5; i++) {
                rooms.add(new Room(i, false));
            }
            FileHandler.saveRooms(rooms);
        }

        Hotel hotel = new Hotel(rooms);
        BookingManager manager = new BookingManager(hotel);

        while (true) {
            System.out.println("\n------ Hotel Booking System ------");
            System.out.println("1. Book Room");
            System.out.println("2. View Booking History");
            System.out.println("3. View Booking History by Username");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter your name: ");
                    String name = capitalizeFullName(scanner.nextLine());

                    if(!name.matches("[a-zA-Z ]+")){
                        System.out.println("Invalid Name");
                        break;
                    }
                    Thread t = new Thread(new BookingWorker(manager, name));
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> ReportManager.showAllBookings();
                case 3 -> {
                    System.out.print("Enter username: ");
                    String user = capitalizeFullName(scanner.nextLine());
                    if(!user.matches("[a-zA-Z ]+")){
                        System.out.println("Invalid Name");
                        break;
                    }
                    ReportManager.showBookingsByUser(user);
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static String capitalizeFullName(String name) {
        String[] parts = name.trim().toLowerCase().split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (String part : parts) {
            if (!part.isEmpty()) {
                capitalized.append(Character.toUpperCase(part.charAt(0)))
                        .append(part.substring(1))
                        .append(" ");
            }
        }

        return capitalized.toString().trim();
    }
}
