# Hotel Booking System (Java + Multithreading + JDBC)

A command-line based Hotel Booking System implemented in Java.  
It simulates a multi-user environment using multithreading, supports file-based room management, and integrates with MySQL to store and report user booking history.

---

## Features

- CLI interface for live booking interaction
- Multithreaded room booking with real-time concurrency
- File-based room status tracking (`rooms.txt`)
- MySQL + JDBC integration for booking history
- Auto-reset rooms after check-out
- Booking reports by user and full history

---

##  Project Structure

HotelBookingSystem/  
├── src/  
│   ├── Main.java → CLI menu and app entry point  
│   ├── Room.java → Room data model  
│   ├── Hotel.java → Manages list of rooms  
│   ├── BookingManager.java → Handles synchronized room booking  
│   ├── BookingWorker.java → Thread for simulating user booking  
│   ├── FileHandler.java → Loads/saves room data from rooms.txt  
│   ├── DBConnection.java → Manages JDBC connection to MySQL  
│   ├── DBHelper.java → Inserts booking records into database  
│   ├── ReportManager.java → Generates user + full booking reports  
│   └──  RoomResetter.java → Auto-resets rooms based on checkout time  
├── rooms.txt → Stores current booking status of rooms (true/false)  
├── SQL.sql → Database schema file  
└── pom.xml → Maven config & dependencies 


---

## Tech Stack

- Java 17
- MySQL (JDBC)
- Maven
- File Handling (`BufferedReader`, `BufferedWriter`)
- Multithreading
- CLI


