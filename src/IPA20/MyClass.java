package IPA20;
import java.util.*;

class Engine{
	int engineId;
	String engineName;
	String engineType;
	double enginePrice;
	Engine(int id, String name, String type, double price){
		this.engineId=id;
		this.engineName=name;
		this.engineType=type;
		this.enginePrice=price;
	}
	public int getId() {return this.engineId;}
	public String getName() {return this.engineName;}
	public String getType() {return this.engineType;}
	public double getPrice() {return this.enginePrice;}
}

public class MyClass {
	static int findAvgEnginePriceByType(List<Engine> lists,String type) {
		int sum=0;
		int count=0;
		for(Engine eng:lists) {
			if(eng.getType().equalsIgnoreCase(type)) {
				sum+=eng.getPrice();
				++count;
			}
		}
		return (int)(sum/count);
	}

	static List<Engine> searchEngineByName(List<Engine> lists,String name) {
		List<Engine> engines=new ArrayList<>();
		for(Engine eng:lists) {
			if(eng.getName().equalsIgnoreCase(name)) {
				engines.add(eng);
			}
		}
		if(engines.size()==0)
			return null;
		Collections.sort(engines,(a,b)->{return a.getId()-b.getId();});
		return engines;
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Engine> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			String type=scan.nextLine();
			double price=scan.nextDouble();scan.nextLine();
			lists.add(new Engine(id,name,type,price));
		}
		String type=scan.nextLine();
		String name=scan.nextLine();
		
		int avg=findAvgEnginePriceByType(lists,type);
		if(avg==0)
			System.out.println("There are no engine with the given type");
		else
			System.out.println(avg);
		
		List<Engine> list=searchEngineByName(lists,name);
		if(list==null)
			System.out.println("There are no engine with the given name");
		else {
			for(Engine eng:list)
				System.out.println(eng.getId());
		}
		
		scan.close();
	}

}
