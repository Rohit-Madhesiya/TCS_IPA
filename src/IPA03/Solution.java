package IPA03;
import java.util.*;

class Student{
	int rollNo;
	String name;
	String branch;
	double score;
	boolean dayScholar;
	Student(int roll,String name,String branch,double score,boolean isdayScholar){
		this.rollNo=roll;
		this.name=name;
		this.branch=branch;
		this.score=score;
		this.dayScholar=isdayScholar;
	}
	public int getRollNo() {return this.rollNo;}
	public String getName() {return this.name;}
	public String getBranch() {return this.branch;}
	public double getScore() {return this.score;}
	public boolean isDayScholar() {return this.dayScholar;}
}

public class Solution {
	static int findCountOfDayScholarStudents(List<Student> students) {
		int count=0;
		for(Student std:students) {
			if(std.getScore()>80 && std.isDayScholar()) {
				++count;
			}
		}
		return count;
	}
	static Student findStudentWithSecondHighestScore(List<Student> students) {
		Student highest=null,second_highest=null;
		for(Student std:students) {
			if(!std.isDayScholar()) {
				if(highest==null) {
					highest=std;
					second_highest=std;
				}else if(highest.getScore()<std.getScore()) {
					second_highest=highest;
					highest=std;
				}else if(second_highest.getScore()<std.getScore())
					second_highest=std;
			}
		}
		return second_highest;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Student> list=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			String branch=scan.nextLine();
			int score=scan.nextInt();
			boolean isDay=scan.nextBoolean();
			list.add(new Student(id,name,branch,score,isDay));
		}
		
		int dayScholarDays=findCountOfDayScholarStudents(list);
		Student std=findStudentWithSecondHighestScore(list);
		
		if(dayScholarDays==0)
			System.out.println("There are no such dayscholar students");
		else
			System.out.println(dayScholarDays);
		
		if(std==null)
			System.out.println("There are no student from non-day scholar");
		else
			System.out.println(std.getRollNo()+"#"+std.getName()+"#"+std.getScore());
		
		scan.close();
	}

}
