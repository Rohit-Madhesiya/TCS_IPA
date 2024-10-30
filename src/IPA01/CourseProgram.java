package IPA01;
import java.util.*;

class Course{
	int courseId;
	String courseName;
	String courseAdmin;
	int quiz;
	int handson;
	Course(int id,String cName,String cAdmin,int quiz,int handson){
		this.courseId=id;
		this.courseName=cName;
		this.courseAdmin=cAdmin;
		this.quiz=quiz;
		this.handson=handson;
	}
	public String getCourseName() {return this.courseName;}
	public int getQuiz() {return this.quiz;}
	public int getHandsOn() {return this.handson;}
	public String getAdmin() {return this.courseAdmin;}
}

public class CourseProgram {
	static int findAvgOfQuizByAdmin(List<Course> courses,String admin) {
		long sum=0;
		int count=0;
		for(Course course:courses) {
			if(course.getAdmin().equals(admin)) {
				sum+=course.getQuiz();
				count++;
			}
		}
		if(count==0)
			return 0;
		return (int)(sum/count);
	}
	static List<Course> sortCourseByHandsOn(List<Course> courses,int handson) {
		List<Course> list=new ArrayList<>();
		for(Course course:courses) {
			if(course.getHandsOn()<handson)
				list.add(course);
		}
		if(list.size()==0)
			return null;
		Collections.sort(list,(a,b)->{return a.getHandsOn()-b.getHandsOn();});
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		List<Course> courses=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String cName=scan.nextLine();
			String cAdmin=scan.nextLine();
			int quiz=scan.nextInt();scan.nextLine();
			int handson=scan.nextInt();scan.nextLine();
			courses.add(new Course(id,cName,cAdmin,quiz,handson));
		}
		
		String admin=scan.nextLine();
		int handsOn=scan.nextInt();
		
		int average=findAvgOfQuizByAdmin(courses,admin);
		if(average==0)
			System.out.println("No Course found");
		else
			System.out.println(average);
		
		List<Course> list=sortCourseByHandsOn(courses,handsOn);
		if(list==null)
			System.out.println("No Course found with mentioned attribute.");
		else {
			for(Course course:list)
				System.out.println(course.getCourseName());
		}
		scan.close();
	}

}
