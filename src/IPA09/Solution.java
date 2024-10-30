package IPA09;
import java.util.*;

class Book{
	int id;
	int pages;
	String title;
	String author;
	double price;
	Book(int id,int pages,String title,String author,double price){
		this.id=id;
		this.pages=pages;
		this.title=title;
		this.author=author;
		this.price=price;
	}
	public int getId() {return this.id;}
	public int getPages() {return this.pages;}
	public double getPrice() {return this.price;}
	public String getAuthor() {return this.author;}
	public String getTitle() {return this.title;}
}

public class Solution {
	static List<Book> findBookWithMaximumPrice(List<Book> books) {
		List<Book> lists=null;
		double price=Integer.MIN_VALUE;
		for(Book book:books) {
			if(book.getPrice()>price) {
				price=book.getPrice();
				lists=new ArrayList<>();
				lists.add(book);
			}else if(book.getPrice()==price)
				lists.add(book);
		}
		return lists;
	}
	static Book searchBookByTitle(List<Book> books,String title) {
		for(Book book:books) {
			if(book.getTitle().equals(title))
				return book;
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		List<Book> lists=new ArrayList<>();
		for(int i=0;i<4;i++) {
			int id=scan.nextInt();scan.nextLine();
			int pages=scan.nextInt();scan.nextLine();
			String title=scan.nextLine();
			String author=scan.nextLine();
			double price=scan.nextDouble();scan.nextLine();
			lists.add(new Book(id,pages,title,author,price));
		}
		String title=scan.nextLine();
		
		List<Book> bookList=findBookWithMaximumPrice(lists);
		if(bookList==null)
			System.out.println("No Book found with mentioned attribute.");
		else {
			for(Book book:bookList)
				System.out.println(book.getId()+" "+book.getTitle());
		}
		Book book=searchBookByTitle(lists,title);
		if(book==null)
			System.out.println("No Book found with mentioned attribute.");
		else
			System.out.println(book.getId()+"\n"+book.getPages());
		scan.close();
	}

}
