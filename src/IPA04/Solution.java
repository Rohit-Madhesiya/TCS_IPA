package IPA04;
import java.util.*;

class College{
	int id;
	String name;
	int contactNo;
	String address;
	int pincode;
	College(int id,String name,int contact,String addr,int pin){
		this.id=id;
		this.name=name;
		this.contactNo=contact;
		this.address=addr;
		this.pincode=pin;
	}
	public String getName() {return this.name;}
	public int getContact() {return this.contactNo;}
	public String getAddress() {return this.address;}
	public int getPincode() {return this.pincode;}
	
	public String toString() {
		return "id-"+this.id+",\n name-"+this.name+",\n contactNo-"+this.contactNo+",\n address-"+this.address+",\n pincode-"+this.pincode;
	}
}

public class Solution {
	static College findCollegeWithMaximumPincode(List<College> colleges) {
		College cllg=null;
		for(College college:colleges) {
			if(cllg==null) {
				cllg=college;
			}else if(cllg.getPincode()<college.getPincode())
				cllg=college;
		}
		return cllg;	
	}
	static College searchCollegebyAddress(List<College> colleges,String address) {
		for(College college:colleges) {
			if(college.getAddress().equalsIgnoreCase(address))
				return college;
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<College> list=new ArrayList<>();
		int num=scan.nextInt();
		for(int i=0;i<num;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			int contact=scan.nextInt();scan.nextLine();
			String addr=scan.nextLine();
			int pin=scan.nextInt();
			list.add(new College(id,name,contact,addr,pin));
		}
		scan.nextLine();
		String addr=scan.nextLine();
		College clg=findCollegeWithMaximumPincode(list);
		if(clg==null)
			System.out.println("No college found with mentioned attribute");
		else
			System.out.println(clg.toString());
		clg=searchCollegebyAddress(list,addr);
		if(clg==null)
			System.out.println("No college found with mentioned attribute");
		else
			System.out.println(clg);
		
		scan.close();
	}
}
