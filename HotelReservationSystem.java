import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

//room class
class Room{
int roomNumber;
String category;
double price;
boolean available;

Room(int roomNumber , String category , double price){
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
this.customerName  = customerName;
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
}
}
//main class
public class HotelReservationSystem{
static Scanner sc = new Scanner(System.in);
static ArrayList<Room>rooms = new ArrayList<>();
static ArrayList<Reservation>reservations = new ArrayList<>();

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
   static void bookRoom() {
      searchRooms();
      System.out.print("enter room number to book");
      int roomNumber = sc.nextInt();
      sc.nextLine();
      Room selectedRoom = null;
         for(Room room :rooms){
            if(room.roomNumber == roomNumber && room.available ){
               selectedRoom = room;
               break;
            }
         }
      if(selectedRoom == null){
         System.out.println("Invalid roomm or room already booked");
         return;
      }
       System.out.println("Enter Customer Name");
      String name = sc.nextLine();
       System.out.println("Enter phone number");
      String phone = sc.nextLine();
       System.out.println("Room Price : RS ."+ selectedRoom.price);
      System.out.println("Proceed to payment? (yes/no): ");
      String choice = sc.nextLine();

      if(choice . equalsIgnoreCase("yes")){
                System.out.println("Payment Successful");

         selectedRoom.available = false;
      Reservation reservation = new Reservation(name , phone , selectedRoom.roomNumber , selectedRoom.category , selectedRoom.price);
         reservations.add(reservation);
         System.out.println("room booked Successfully");
         saveBooking(reservation);
      }else{
         System.out.println("Booking Cancelledd");
      }
   }
   //cancel reservation
   static void cancelReservation(){
      System.out.println("enter room number to cancel :");
      int roomNumber = sc.nextInt();
      sc.nextLine();
      Reservation foundReservation = null ;
      for(Reservation reservation : reservations) {
         if(reservation.roomNumber == roomNumber){
            foundReservation = reservation;
            break;
         }
      }
   if(foundReservation == null){
      System.out.println("no reservatiion found");
      return;
   }
      for(Room room : rooms){
         if(room.roomNumber == roomNumber){
            room.available = true;
            break;
         }
      }
       reservations.remove(foundReservation);

      System.out.println("Reservation cancelled successfully");
   }

   //Display all bookings
   static void displayBookings(){
      if(reservations.isEmpty()){
         System.out.println("No bookings available");
         return;
      }
      for(Reservation reservation : reservations){
         reservation.displayDetails();
      }
   }
   //save booking to file
   static void saveBooking(Reservation reservation){
      try{
         FileWriter writer = new FileWriter("bookings.txt",true);
          writer.write(reservation.customerName + "," + reservation.phone + "," + reservation.roomNumber + "," + reservation.category + "," + reservation.amount + "\n");
         writer.close();
      }catch (IOException e ){
         System.out.println("ERROR saving bookings");
      }
   }

   public static void main(String args[]){
      createRooms();
      int choice;
      do{
         System.out.println("==========================================================================");
         System.out.println("HOTEL RESERVATION SYSTEM");
         System.out.println("==========================================================================");
         System.out.println("1.Search Available Rooms\n 2.Book a Room\n 3.Cancel Reservation\n 4.view Booking Details\n 5.Exit");
         System.out.println("Enter your choice");
         choice  = sc.nextInt();
         sc.nextLine();
         switch(choice){
            case 1: searchRooms();
                     break;
            case 2: bookRoom();
                     break;
            case 3: cancelReservation();
                    break;
            case 4: displayBookings();
                    break;
            case 5:
               System.out.println("Thankyou for using hotel reservation system");
               break;
            default : System.out.println("Invalid Choice");
         }
      } while (choice != 5);
         sc.close();
    }
}

      










