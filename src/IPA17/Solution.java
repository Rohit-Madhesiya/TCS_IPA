package IPA17;
import java.util.*;

class Student{
	int rollNo;
	String name;
	String subject;
	char grade;
	String date;
	Student(int roll,String name,String sub,char grade,String date){
		this.rollNo=roll;
		this.name=name;
		this.subject=sub;
		this.grade=grade;
		this.date=date;
	}
	public int getRoll() {return this.rollNo;}
	public char getGrade() {return this.grade;}
	public String getDate() {return this.date;}
	public String getsubject() {return this.subject;}
	public String getName() {return this.name;}
}

public class Solution {
	static List<Student> findStudentByGradeAndMonth(List<Student> lists,char grade,int month) {
		List<Student> list=new ArrayList<>();
		for(Student std:lists) {
			if(std.getGrade()==grade) {
				int mnth=Integer.parseInt(std.getDate().substring(3,5));
				if(mnth==month) {
					list.add(std);
				}
			}
		}
		return list.size()==0?null:list;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Student> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int roll=scan.nextInt();scan.nextLine();
			String name=scan.nextLine();
			String sub=scan.nextLine();
			char ch=scan.next().charAt(0);scan.nextLine();
			String date=scan.nextLine();
			lists.add(new Student(roll,name,sub,ch,date));
		}
		char grade=scan.next().charAt(0);scan.nextLine();
		int month=scan.nextInt();
		
		List<Student> list=findStudentByGradeAndMonth(lists,grade,month);
		if(list==null)
			System.out.println("No student found");
		else {
			for(Student std:list)
				System.out.println(std.getName()+"\n"+std.getsubject());
			System.out.println(list.size());
		}
		

		scan.close();
	}

}
