package IPA06;
import java.util.*;

class RRT{
	int ticketNo;
	String raisedBy;
	String assignedTo;
	int priority;
	String project;
	RRT(int ticket,String raised,String assign,int priority,String project){
		this.ticketNo=ticket;
		this.raisedBy=raised;
		this.assignedTo=assign;
		this.priority=priority;
		this.project=project;
	}
	
	public int getPriority() {return this.priority;}
	public String getProject() {return this.project;}
	public String toString() {
		return ticketNo+"\n"+raisedBy+"\n"+assignedTo+"\n";
	}
}

public class MyClass {
	static RRT getHighestPriorityTicket(List<RRT> lists,String project) {
		RRT rrt=null;
		for(RRT ticket:lists) {
			if(ticket.getProject().equals(project)) {
				if(rrt==null)
					rrt=ticket;
				else if(rrt.getPriority()>ticket.getPriority())
					rrt=ticket;
			}
		}
		return rrt;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<RRT> tickets=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int no=scan.nextInt();scan.nextLine();
			String raised=scan.nextLine();
			String assign=scan.nextLine();
			int priority=scan.nextInt();scan.nextLine();
			String project=scan.nextLine();
			tickets.add(new RRT(no,raised,assign,priority,project));
		}
		String project=scan.nextLine();
		
		RRT myTicket=getHighestPriorityTicket(tickets,project);
		if(myTicket==null)
			System.out.println("No such Ticket");
		else
			System.out.println(myTicket);
		
		scan.close();
	}

}
