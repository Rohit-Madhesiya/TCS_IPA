package IPA08;
import java.util.*;

class Hotel{
	int hotelId;
	String hotelName;
	String dateOfBooking;
	int noOfRoomsBooked;
	String wifiFacility;
	double totalBill;
	Hotel(int id,String name,String date,int bookedRooms,String wifi,double bill){
		this.hotelId=id;
		this.hotelName=name;
		this.dateOfBooking=date;
		this.noOfRoomsBooked=bookedRooms;
		this.wifiFacility=wifi;
		this.totalBill=bill;
	}
	public int getId() {return this.hotelId;}
	public int getBookedRooms() {return this.noOfRoomsBooked;}
	public String getDate() {return this.dateOfBooking;}
	public double getTotalBill() {return this.totalBill;}
	public String getWifi() {return this.wifiFacility;}
}

public class Solution {

	static int noOfRoomsBookedInGivenMonth(List<Hotel> hotels,String month) {
		int count=0;
		for(Hotel hotel:hotels) {
			String mon=hotel.getDate().substring(3,6);
			if(mon.equals(month)) {
				count+=hotel.getBookedRooms();
			}
		}
		return count;
	}
	static Hotel searchHotelByWifiOption(List<Hotel> hotels,String wifi) {
		Hotel highest=null,second_highest=null;
		for(Hotel ht:hotels) {
			if(ht.getWifi().equals(wifi)) {
				if(highest==null) {
					highest=ht;
				}else if(highest.getTotalBill()<ht.getTotalBill()) {
					second_highest=highest;
					highest=ht;
				}else if(second_highest==null) {
					second_highest=ht;
				}else if(second_highest.getTotalBill()<ht.getTotalBill())
					second_highest=ht;
			}
		}
		return second_highest;	
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Hotel> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			String date=scan.nextLine();
			int noOfRooms=scan.nextInt();scan.nextLine();
			String wifi=scan.nextLine();
			double bill=scan.nextDouble();scan.nextLine();
			lists.add(new Hotel(id,name,date,noOfRooms,wifi,bill));
		}
		String month=scan.nextLine();
		String wifi=scan.nextLine();
		
		int noOfRoomsInMonth=noOfRoomsBookedInGivenMonth(lists,month);
		if(noOfRoomsInMonth==0) {
			System.out.println("No rooms booked in the given month");
		}else {
			System.out.println(noOfRoomsInMonth);
		}
		
		Hotel hotel=searchHotelByWifiOption(lists,wifi);
		if(hotel==null) {
			System.out.println("No such option available");
		}else {
			System.out.println(hotel.getId());
		}

	}

}
