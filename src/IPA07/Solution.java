package IPA07;
import java.util.*;

class Sim{
	int simId;
	String customerName;
	double balance;
	double ratePerSecond;
	String circle;
	Sim(int id,String name,double bal,double rate,String circle){
		this.simId=id;
		this.customerName=name;
		this.balance=bal;
		this.ratePerSecond=rate;
		this.circle=circle;
	}
	public String getCircle() {return this.circle;}
	public void setCircle(String cr) {
		this.circle=cr;
	}
	public double getRate() {return this.ratePerSecond;}
	public String toString() {
		return simId+" "+customerName+" "+circle+" "+ratePerSecond;
	}
}

public class Solution {
	static List<Sim> transferCustomerCircle(List<Sim> lists,String fromCircle,String toCircle) {
		List<Sim> sims=new ArrayList<>();
		for(Sim sim:lists) {
			if(sim.getCircle().equals(fromCircle)) {
				sim.setCircle(toCircle);
				sims.add(sim);
			}
		}
//		TODO: sorting is not working properly
		Collections.sort(sims,(a,b)->{return (int)(b.getRate()-a.getRate());});
		return sims;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Sim> lists=new ArrayList<>();
		for(int i=0;i<5;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			double bal=scan.nextDouble();scan.nextLine();
			double rate=scan.nextDouble();scan.nextLine();
			String circle=scan.nextLine();
			lists.add(new Sim(id,name,bal,rate,circle));
		}
		String fromCircle=scan.nextLine();
		String toCircle=scan.nextLine();
		lists=transferCustomerCircle(lists,fromCircle,toCircle);
		for(Sim sim:lists) {
			System.out.println(sim);
		}
	}

}
