import java.util.*;
class Transaction{
	private String bookId;
	private String memId;
	private Date date;
	private boolean isBorrow;
	Transaction(String bookId,String memId,Date date,boolean isBorrow){
		this.bookId = bookId;
		this.memId = memId;
		this.date = date;
		this.isBorrow = isBorrow;
	}
	public String getBookId(){
		return bookId;
	}
	public String getMemId(){
		return memId;
	}
	public Date getDate(){
		return date;
	}
	public boolean isBorrow(){
		return isBorrow;
	}
	public String toString(){
		return bookId+" "+memId+" "+date+" "+isBorrow;
	}
}