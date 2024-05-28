public class Member{
	private String memId;
	private String name;
	private int borrowCount;
	Member(String memId,String name){
		this.memId = memId;
		this.name = name;
		this.borrowCount = 0;
	}
	public String getId(){
		return memId;
	}
	public String getName(){
		return name;
	}
	public int getBorrowCount(){
		return borrowCount;
	}
	public void incrementBorrowCount(){
		borrowCount++;
	}
	public String toString(){
		return memId+" "+name+" "+borrowCount;
	}
}