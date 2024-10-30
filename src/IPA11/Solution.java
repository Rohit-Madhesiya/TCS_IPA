package IPA11;
import java.util.*;

class Player{
	int playerId;
	String skill;
	String level;
	int points;
	Player(int id,String skill,String level,int points){
		this.playerId=id;
		this.skill=skill;
		this.level=level;
		this.points=points;
	}
	public int getId(){return this.playerId;}
	public String getSkill() {return this.skill;}
	public String getLevel() {return this.level;}
	public int getPoints() {return this.points;}
}

public class Solution {
	static int findPointsForGivenSkill(List<Player> players,String skill) {
		int sum=0;
		for(Player player:players) {
			if(player.getSkill().equals(skill))
				sum+=player.getPoints();
		}
		return sum;
	}
	static Player getPlayerBasedOnLevel(List<Player> players,String level,String skill) {
		for(Player player:players) {
			if(player.getLevel().equals(level) && player.getSkill().equals(skill) && player.getPoints()>=20)
				return player;
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Player> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			String skill=scan.nextLine();
			String level=scan.nextLine();
			int points=scan.nextInt();scan.nextLine();
			lists.add(new Player(id,skill,level,points));
		}
		String skill=scan.nextLine();
		String level=scan.nextLine();
		int totalPoints=findPointsForGivenSkill(lists,skill);
		Player player=getPlayerBasedOnLevel(lists,level,skill);
		
		if(totalPoints==0)
			System.out.println("The given Skill is not available");
		else
			System.out.println(totalPoints);
		
		if(player==null)
			System.out.println("No player is available with specified level, skill and eligibility points");
		else
			System.out.println(player.getId());
		
		scan.close();
	}

}
