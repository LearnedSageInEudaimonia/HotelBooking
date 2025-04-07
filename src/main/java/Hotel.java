import java.util.List;

public class Hotel {
    private final List<Room> rooms;

    public Hotel(List<Room> rooms) {
        this.rooms = rooms;
    }

    public synchronized Room bookRoom(){
        for(Room room : rooms){
            if(!room.isBooked()){
                room.setBooked(true);
                FileHandler.saveRooms(rooms);
                return room;
            }
        }
        return null;
    }

    public List<Room> getRooms(){
        return rooms;
    }
}
