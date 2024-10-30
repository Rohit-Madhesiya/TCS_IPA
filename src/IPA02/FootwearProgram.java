package IPA02;
import java.util.*;

class Footwear{
	int footwearId;
	String footwearName;
	String footwearType;
	int price;
	Footwear(int id,String name,String type,int price){
		this.footwearId=id;
		this.footwearName=name;
		this.footwearType=type;
		this.price=price;
	}
	public int getId() {return this.footwearId;}
	public String getName() {return this.footwearName;}
	public String getType() {return this.footwearType;}
	public int getPrice() {return this.price;}
}
public class FootwearProgram {
	static int getCountByType(List<Footwear> list,String footwearType) {
		int count=0;
		for(Footwear fw:list) {
			if(fw.getType().equalsIgnoreCase(footwearType))
				count++;
		}
		return count;
	}
	
	static Footwear getSecondHighestPriceByBrand(List<Footwear> list,String footwearName) {
		Footwear highest=null,second_highest=null;
		for(Footwear fw:list) {
			if(fw.getName().equalsIgnoreCase(footwearName)) {
				int price=fw.getPrice();
				if(highest==null) {
					highest=fw;
					second_highest=fw;
				}else if(highest.getPrice()<price) {
					second_highest=highest;
					highest=fw;
				}else if(second_highest.getPrice()<price)
					second_highest=fw;
			}
		}
		return second_highest;
	}
	
	

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Footwear> footwears=new ArrayList<>();
		for(int i=0;i<5;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			String type=scan.nextLine();
			int price=scan.nextInt();scan.nextLine();
			footwears.add(new Footwear(id,name,type,price));
		}
		String fType=scan.nextLine();
		String fName=scan.nextLine();
		
		int count=getCountByType(footwears,fType);
		if(count==0)
			System.out.println("Footwear not available");
		else
			System.out.println(count);
		
		Footwear fw=getSecondHighestPriceByBrand(footwears,fName);
		if(fw==null)
			System.out.println("Brand not available");
		else
			System.out.println("FootwearId: "+fw.getId()+", Type: "+fw.getType()+", Price: "+fw.getPrice());
		
		
		scan.close();
	}

}
