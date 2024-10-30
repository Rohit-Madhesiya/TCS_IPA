package IPA13;
import java.util.*;

class AutonomousCar{
	int carId;
	String brand;
	int noOfTestsConducted;
	int noOfTestsPassed;
	String environment;
	String grade;
	AutonomousCar(int id,String brand,int testConducted,int testPassed,String environment){
		this.carId=id;
		this.brand=brand;
		this.noOfTestsConducted=testConducted;
		this.noOfTestsPassed=testPassed;
		this.environment=environment;
		this.grade="B2";
	}
	public int getId() {return this.carId;}
	public String getBrand() {return this.brand;}
	public int GetTestConducted() {return this.noOfTestsConducted;}
	public int getTestPassed() {return this.noOfTestsPassed;}
	public String getEnv() {return this.environment;}
	public String getGrade() {return this.grade;}
	public void setGrade(String grade) {
		this.grade=grade;
	}
}

public class Solution {
	static int findTestPassedByEnv(List<AutonomousCar> cars,String environment) {
		int sum=0;
		for(AutonomousCar car:cars) {
			if(car.getEnv().equals(environment))
				sum+=car.getTestPassed();
		}
		return sum;
	}
	static AutonomousCar updateCarGrade(List<AutonomousCar> cars,String brand) {
		for(AutonomousCar car:cars) {
			if(car.getBrand().equals(brand)) {
				int rating=(car.getTestPassed()*100)/car.GetTestConducted();
				if(rating>=80)
					car.setGrade("A1");
				return car;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<AutonomousCar> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String brand=scan.nextLine();
			int conducted=scan.nextInt();scan.nextLine();
			int passed=scan.nextInt();scan.nextLine();
			String env=scan.nextLine();
			lists.add(new AutonomousCar(id,brand,conducted,passed,env));
		}
		String env=scan.nextLine();
		String brand=scan.nextLine();
		
		int totalPassedTest=findTestPassedByEnv(lists,env);
		
		if(totalPassedTest==0)
			System.out.println("There are no tests passed in this particular environment");
		else
			System.out.println(totalPassedTest);
		
		AutonomousCar car=updateCarGrade(lists,brand);
		if(car==null)
			System.out.println("No Car is available with the specified brand");
		else
			System.out.println(car.getBrand()+"::"+car.getGrade());
		
		scan.close();
	}

}
