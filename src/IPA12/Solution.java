package IPA12;
import java.util.*;

class Medicine{
	String medicineName;
	String batch;
	String disease;
	int price;
	Medicine(String name,String batch,String disease,int price){
		this.medicineName=name;
		this.batch=batch;
		this.disease=disease;
		this.price=price;
	}
	public String getName() {return this.medicineName;}
	public String getBatch() {return this.batch;}
	public String getDisease() {return this.disease;}
	public int getPrice() {return this.price;}
}

public class Solution {
	static List<Medicine> getPriceByDisease(List<Medicine> medicines,String disease) {
		List<Medicine> list=new ArrayList<>();
		for(Medicine med:medicines) {
			if(med.getDisease().equalsIgnoreCase(disease)) {
				list.add(med);
			}
		}
		if(list.size()==0)
			return null;
		Collections.sort(list,(a,b)->{return a.getPrice()-b.getPrice();});
		return list;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Medicine> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			String name=scan.nextLine();
			String batch=scan.nextLine();
			String disease=scan.nextLine();
			int price=scan.nextInt();scan.nextLine();
			lists.add(new Medicine(name,batch,disease,price));
		}
		String disease=scan.nextLine();
		lists=getPriceByDisease(lists,disease);
		for(Medicine med:lists) {
			System.out.println(med.getPrice());
		}
		scan.close();
	}

}
