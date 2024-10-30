package IPA18;
import java.util.*;

class Antenna{
	int antennaId;
	String antennaName;
	String projectLead;
	double antennaVSWR;
	Antenna(int id,String name,String lead,double vswr){
		this.antennaId=id;
		this.antennaName=name;
		this.projectLead=lead;
		this.antennaVSWR=vswr;
	}
	public int getId() {return this.antennaId;}
	public String getName() {return this.antennaName;}
	public String getPLead() {return this.projectLead;}
	public double getVSWR() {return this.antennaVSWR;}
	
	
}

public class Solution {
	static int searchAntennaByName(List<Antenna> lists,String name) {
		for(Antenna ant:lists) {
			if(ant.getName().equalsIgnoreCase(name)) {
				return ant.getId();
			}
		}
		return 0;
	}
	static List<Antenna> sortAntennaByVSWR(List<Antenna> lists,double vswr) {
		List<Antenna> list=new ArrayList<>();
		for(Antenna ant:lists) {
			if(ant.getVSWR()<vswr)
				list.add(ant);
		}
		if(list.size()==0)
			return null;
		list.sort(Comparator.comparingDouble(Antenna::getVSWR));
		return list;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Antenna> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			String lead=scan.nextLine();
			double vswr=scan.nextDouble();scan.nextLine();
			lists.add(new Antenna(id,name,lead,vswr));
		}
		String name=scan.nextLine();
		int id=searchAntennaByName(lists,name);
		if(id==0)
			System.out.println("There is no antenna with the given parameter");
		else
			System.out.println(id);
		double vswr=scan.nextDouble();
		List<Antenna> list=sortAntennaByVSWR(lists,vswr);
		if(list==null)
			System.out.println("No Antenna found");
		else {
			for(Antenna an:list) {
				System.out.println(an.getPLead());
			}
		}
			
		
		
		scan.close();
	}

}
