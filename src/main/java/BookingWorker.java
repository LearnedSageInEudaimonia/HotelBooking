public class BookingWorker implements Runnable{
    private final BookingManager manager;
    private final String userName;

    public BookingWorker(BookingManager manager, String userName) {
        this.manager = manager;
        this.userName = userName;
    }

    @Override
    public void run(){
        manager.bookRoom(userName);
    }
}
