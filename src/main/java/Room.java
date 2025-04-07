public class Room {
    private final int roomNumber;
    private boolean isBooked;

    public Room(int roomNumber, boolean isBooked){
        this.roomNumber = roomNumber;
        this.isBooked = isBooked;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked(){
        return isBooked;
    }

    public void setBooked(boolean booked){
        isBooked = booked;
    }
    @Override
    public String toString(){
        return roomNumber + "," + isBooked;
    }

    public static Room fromString(String line){
        String[] parts = line.split(",");
        return new Room(Integer.parseInt(parts[0]),Boolean.parseBoolean(parts[1]));
    }


}
