public class Book{
	private String id;
	private String title,author;
	private boolean isAvailable;
	private int borrowCount;
	Book(String id,String title,String author){
		this.id = id;
		this.title = title;
		this.author = author;
		this.isAvailable = true;
		this.borrowCount = 0;
	}
	public String getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
	public String getAuthor(){
		return author;
	}
	public boolean isAvailable(){
		return isAvailable;
	}
	public void setAvailable(boolean available){
		isAvailable = available;
	}
	public void incrementBorrowCount(){
		this.borrowCount++;
	}
	public int getBorrowCount(){
		return borrowCount;
	}
	public String toString(){
		return "Book Number :"+ id +"\n"+"Book Name :"+" "+title+"\n"+"Author Name :"+" "+author+" "+"\n"+ "Book is Available : "+ isAvailable;
	}
}
