package IPA10;
import java.util.*;

class Employee{
	int employeeId;
	String name;
	String branch;
	double rating;
	boolean transport;
	Employee(int id,String name,String branch,double rating,boolean trans){
		this.employeeId=id;
		this.name=name;
		this.branch=branch;
		this.rating=rating;
		this.transport=trans;
	}
	public int getEmployeeId() {return this.employeeId;}
	public String getName() {return this.name;}
	public boolean isUsingTransport() {return this.transport;}
	public String getBranch() {return this.branch;}
	public double getRating() {return this.rating;}
}

public class MyClass {
	static int findCountOfEmployeesUsingCompTransport(List<Employee> employees,String branch) {
		int count=0;
		for(Employee emp:employees) {
			if(emp.getBranch().equals(branch) && emp.isUsingTransport() ) {
				++count;
			}
		}
		return count;
	}
	static Employee findEmployeeWithSecondHighestRating(List<Employee> employees) {
		Employee highest=null,second_highest=null;
		for(Employee emp:employees) {
			if(!emp.isUsingTransport()) {
				if(highest==null)
					highest=emp;
				else if(highest.getRating()<emp.getRating()) {
					second_highest=highest;
					highest=emp;
				}else if(second_highest==null)
					second_highest=emp;
				else if(second_highest.getRating()<emp.getRating())
					second_highest=emp;
			}
		}
		return second_highest;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Employee> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			String branch=scan.nextLine();
			double rating=scan.nextDouble();scan.nextLine();
			boolean isUsingTrans=scan.nextBoolean();scan.nextLine();
			lists.add(new Employee(id,name,branch,rating,isUsingTrans));
		}
		String branch=scan.nextLine();
		int count=findCountOfEmployeesUsingCompTransport(lists,branch);
		if(count==0)
			System.out.println("No such Employees");
		else
			System.out.println(count);
		
		Employee emp=findEmployeeWithSecondHighestRating(lists);
		if(emp==null)
			System.out.println("All Employees using company transport");
		else
			System.out.println(emp.getEmployeeId()+"\n"+emp.getName());

		scan.close();
	}

}
