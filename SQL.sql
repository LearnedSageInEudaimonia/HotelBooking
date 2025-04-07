CREATE DATABASE hotel_booking;

USE hotel_booking;

Create table booking_history(
	id INT PRIMARY KEY auto_increment,
    username varchar(100),
    room_number INt,
    check_in TimeStamp,
    check_out timestamp
    );