package IPA15;
import java.util.*;

class Phone{
	int phoneId;
	String os;
	String brand;
	int price;
	Phone(int id,String os,String brand,int price){
		this.phoneId=id;
		this.os=os;
		this.brand=brand;
		this.price=price;
	}
	public int getId() {return this.phoneId;}
	public String getOs() {return this.os;}
	public String getBrand() {return this.brand;}
	public int getPrice() {return this.price;}
}

public class Solution {
	static int findPriceForGivenBrand(List<Phone> lists,String brand) {
		int sum=0;
		for(Phone list:lists) {
			if(list.getBrand().equalsIgnoreCase(brand))
				sum+=list.getPrice();
		}
		return sum;
	}
	static Phone getPhoneIdBasedOnOs(List<Phone> lists,String os) {
		for(Phone list:lists) {
			if(list.getOs().equalsIgnoreCase(os) && list.getPrice()>=50000)
				return list;
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Phone> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String os=scan.nextLine();
			String brand=scan.nextLine();
			int price=scan.nextInt();scan.nextLine();
			lists.add(new Phone(id,os,brand,price));
		}
		String brand=scan.nextLine();
		String os=scan.nextLine();
		
		int result=findPriceForGivenBrand(lists,brand);
		
		if(result==0)
			System.out.println("The given Brand is not available");
		else
			System.out.println(result);
		
		Phone phone=getPhoneIdBasedOnOs(lists,os);
		if(phone==null)
			System.out.println("No phones are available with specified os and price range");
		else
			System.out.println(phone.getId());
		
		scan.close();
	}

}
