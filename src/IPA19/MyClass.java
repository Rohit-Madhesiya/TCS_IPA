package IPA19;
import java.util.*;

class Flower{
	int flowerId;
	String flowerName;
	int price;
	int rating;
	String type;
	Flower(int id,String name,int price,int rating,String type){
		this.flowerId=id;
		this.flowerName=name;
		this.price=price;
		this.rating=rating;
		this.type=type;
	}
	public int getId() {return this.flowerId;}
	public String getName() {return this.flowerName;}
	public int getPrice() {return this.price;}
	public int getRating() {return this.rating;}
	public String getType() {return this.type;}
}

public class MyClass {
	static Flower findMinPriceByType(List<Flower> lists,String type) {
		Flower flower=null;
		for(Flower list:lists) {
			if(list.getType().equalsIgnoreCase(type)&&list.getRating()>3) {
				if(flower==null)
					flower=list;
				else if(flower.getPrice()>list.getPrice())
					flower=list;
			}
		}
		return flower;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Flower> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			int price=scan.nextInt();scan.nextLine();
			int rating=scan.nextInt();scan.nextLine();
			String type=scan.nextLine();
			lists.add(new Flower(id,name,price,rating,type));
		}
		String type=scan.nextLine();
		
		Flower flower=findMinPriceByType(lists,type);
		if(flower==null)
			System.out.println("There is no flower with given type");
		else
			System.out.println(flower.getId());
		
		scan.close();
	}

}
