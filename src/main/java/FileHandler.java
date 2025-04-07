import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "rooms.txt";

    public static List<Room> loadRooms(){
        List<Room> rooms = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                rooms.add(Room.fromString(line));
            }
        }catch (IOException e){
            System.out.println("Error loading rooms : " + e.getMessage());
        }
        return rooms;
    }
    public static void saveRooms(List<Room> rooms){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(Room room : rooms){
                writer.write(room.toString());
                writer.newLine();
            }
        }catch (IOException e){
            System.out.println("Error saying rooms : " + e.getMessage());
        }
    }
}
