package IPA16;
import java.util.*;

class NavalVessel{
	int vesselId;
	String vesselName;
	int noOfVoyagesPlanned;
	int noOfVoyagesCompleted;
	String purpose;
	String classification;
	NavalVessel(int id,String name,int planned,int completed,String purpose){
		this.vesselId=id;
		this.vesselName=name;
		this.noOfVoyagesPlanned=planned;
		this.noOfVoyagesCompleted=completed;
		this.purpose=purpose;
	}
	public int getId() {return this.vesselId;}
	public String getName() {return this.vesselName;}
	public int getPlanned() {return this.noOfVoyagesPlanned;}
	public int getCompleted() {return this.noOfVoyagesCompleted;}
	public String getPurpose() {return this.purpose;}
	public String getClassification() {return this.classification;}
	public void setClassification(String classify) {
		this.classification=classify;
	}
}

public class Solution {
	static int findAvgVoyagesByPct(List<NavalVessel> lists,int percentage) {
		int sum=0,count=0;
		for(NavalVessel list:lists) {
			int obtainedPercentage=(list.getCompleted()*100)/list.getPlanned();
			if(obtainedPercentage>=percentage) {
				sum+=list.getCompleted();
				++count;
			}
		}
		return (int)(sum/count);
	}
	static NavalVessel findVesselByGrade(List<NavalVessel> lists,String purpose) {
		for(NavalVessel list:lists) {
			if(list.getPurpose().equalsIgnoreCase(purpose)) {
				int percentage=(list.getCompleted()*100)/list.getPlanned();
				if(percentage==100)
					list.setClassification("Star");
				else if(percentage<=99&&percentage>=80)
					list.setClassification("Leader");
				else if(percentage<=79&&percentage>=55)
					list.setClassification("Inspirer");
				else
					list.setClassification("Striver");
				return list;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<NavalVessel> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			int planned=scan.nextInt();scan.nextLine();
			int completed=scan.nextInt();scan.nextLine();
			String purpose=scan.nextLine();
			lists.add(new NavalVessel(id,name,planned,completed,purpose));
		}
		int percentage=scan.nextInt();scan.nextLine();
		String purpose=scan.nextLine();
		
		int average=findAvgVoyagesByPct(lists,percentage);
		
		if(average==0)
			System.out.println("There are no tests passed in this particular environment");
		else
			System.out.println(average);
		
		NavalVessel vessel=findVesselByGrade(lists,purpose);
		if(vessel==null)
			System.out.println("No Car is available with the specified brand");
		else
			System.out.println(vessel.getName()+"%"+vessel.getClassification());
		
		scan.close();
	}

}

