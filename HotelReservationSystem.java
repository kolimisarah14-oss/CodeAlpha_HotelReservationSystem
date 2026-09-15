import java.util.Scanner;
import java.util.ArrayList;
import java.util.FileWriter;
import java.util.IOException;

//room class
class Room{
int RoomNumber;
String category;
double price;
boolean available;

Room(int roomAvailable , String category , double price){
this.roomNumber  = roomNumber;
this.category = category;
this.price = price;
this.available = true;
   }
}
//reservation class
class Reservation{
 String customerName;
 String phone;
 int roomNumber;
 String category;
 double amount;

Reservation(String customerName , String phone , int roomNumber , String category , double amount){
this.phone  = phone;
this.roomNumber = roomNumber;
this.category = category;
this.amount = amount;
}

void displayDetails(){
System.out.println("\n---------Booking Details---------");
System.out.println("Customer name : "+customerName);
System.out.println("Phone Number: "+phone);
System.out.println("Room Number: "+roomNumber);
System.out.println("Room Category: "+category);
System.out.println("Amount :"+amount);
System.out.println("\n--------------------------------------------");

//main class
public class HotelReservationSystem{
Scanner sc = new Scanner(System.in);
ArrayList<Room>rooms = new ArrayList<>();
ArrayList<Reservation>reservations = new ArrayList<>();

//Adding Rooms
static void createRooms(){
rooms.add(new Room(1,"standard",1500));
rooms.add(new Room(2,"standard",1500));
rooms.add(new Room(3,"Deluxe",2500));
rooms.add(new Room(4,"Deluxe",2500));
rooms.add(new Room(5,"Suite",4000));
 }
//search available rooms
static void searchRooms(){
System.out.println("\nAvailable Rooms :");
boolean found = false;
for(Room room : rooms){
if(room.available) {
System.out.println("Room" + room.roomNumber + "|" + room.category + "|Rs." +room.price);
 found = true ;
 }
}
if(!found) {
System.out.println("no rooms are available");
}
}
//book rooms









