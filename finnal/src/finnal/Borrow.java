package finnal;

public class Borrow{
	private int Student_Number;
	private int Borrow_Time;
	private String Book_Name;
	public Borrow(int Student_number,int Borrow_time,String Book_name)
	{
		this.Student_Number=Student_number;
		this.Borrow_Time=Borrow_time;
		this.Book_Name=Book_name;
	}
	public int getStudent_Number() {
		return Student_Number;
	}
	public void setStudent_Number(int student_Number) {
		Student_Number = student_Number;
	}
	public int getBorrow_Time() {
		return Borrow_Time;
	}
	public void setBorrow_Time(int borrow_Time) {
		Borrow_Time = borrow_Time;
	}
	public String getBook_Name() {
		return Book_Name;
	}
	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}
}
