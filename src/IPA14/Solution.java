package IPA14;
import java.util.*;

class Movie{
	String movieName;
	String company;
	String genre;
	int budget;
	Movie(String name,String company,String genre,int budget){
		this.movieName=name;
		this.company=company;
		this.genre=genre;
		this.budget=budget;
	}
	public String getName() {return this.movieName;}
	public String getCompany() {return this.company;}
	public String getGenre() {return this.genre;}
	public int getBudget() {return this.budget;}
}

public class Solution {
	static List<Movie> getMovieByGenre(List<Movie> movies,String genre) {
		List<Movie> list=new ArrayList<>();
		for(Movie movie:movies) {
			if(movie.getGenre().equalsIgnoreCase(genre))
				list.add(movie);
		}
		return list.size()==0?null:list;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Movie> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			String name=scan.nextLine();
			String company=scan.nextLine();
			String genre=scan.nextLine();
			int budget=scan.nextInt();scan.nextLine();
			lists.add(new Movie(name,company,genre,budget));
		}
		String genre=scan.nextLine();
		
		List<Movie> movies=getMovieByGenre(lists,genre);
		if(movies==null)
			System.out.println("There are no tests passed in this particular environment");
		else {
			for(Movie movie:movies) {
				if(movie.getBudget()>80000000)
					System.out.println("High Budget Movie");
				else
					System.out.println("Low Budget Movie");
			}
		}
		
		scan.close();
	}

}
