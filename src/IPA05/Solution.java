package IPA05;
import java.util.*;

class Motel{
	int motelId;
	String motelName;
	String dateOfBooking;
	int noOfRoomsBooked;
	String cabFacility;
	double totalBill;
	Motel(int id,String name,String date,int rooms,String cab,double bill){
		this.motelId=id;
		this.motelName=name;
		this.dateOfBooking=date;
		this.noOfRoomsBooked=rooms;
		this.cabFacility=cab;
		this.totalBill=bill;
	}
	public int getNoOfBookedRooms() {return this.noOfRoomsBooked;}
	public String getName() {return this.motelName;}
	public String getCabFacility() {return this.cabFacility;}
}

public class Solution {
	static int totalNoOfRoomsBooked(List<Motel> motels,String cabFacility) {
		int count=0;
		for(Motel motel:motels) {
			if(motel.getCabFacility().equals(cabFacility) && motel.getNoOfBookedRooms()>5) {
				count+=motel.getNoOfBookedRooms();
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Motel> list=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			String date=scan.nextLine();
			int roomsBooked=scan.nextInt();scan.nextLine();
			String cab=scan.nextLine();
			int bill=scan.nextInt();
			list.add(new Motel(id,name,date,roomsBooked,cab,bill));
		}
		scan.nextLine();
		
		String cabFacility=scan.nextLine();
		int totalRoomsBooked=totalNoOfRoomsBooked(list,cabFacility);
		if(totalRoomsBooked==0)
			System.out.println("No such rooms booked");
		else
			System.out.println(totalRoomsBooked);
				
		scan.close();
	}

}
