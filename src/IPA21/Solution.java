package IPA21;
import java.util.*;

class Fruit{
	int fruitId;
	String fruitName;
	int price;
	int rating;
	Fruit(int id,String name,int price,int rating){
		this.fruitId=id;
		this.fruitName=name;
		this.price=price;
		this.rating=rating;
	}
	public int getId() {return this.fruitId;}
	public String getName() {return this.fruitName;}
	public int getPrice() {return this.price;}
	public int getRating() {return this.rating;}
}

public class Solution {
	static Fruit findMaximumPriceByRating(List<Fruit> lists,int rating) {
		Fruit fruit=null;
		for(Fruit list:lists) {
			if(list.getRating()>rating) {
				if(fruit==null)
					fruit=list;
				else if(fruit.getPrice()<list.getPrice())
					fruit=list;
			}
		}
		return fruit;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Fruit> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			int price=scan.nextInt();scan.nextLine();
			int rating=scan.nextInt();scan.nextLine();
			lists.add(new Fruit(id,name,price,rating));
		}
		int rating=scan.nextInt();
		Fruit fruit=findMaximumPriceByRating(lists,rating);
		if(fruit==null)
			System.out.println("No such Fruit");
		else
			System.out.println(fruit.getId());
		scan.close();
	}

}
