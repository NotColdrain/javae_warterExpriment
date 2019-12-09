package finnal;

public class Borrower {
	String Name;//借书者姓名
	String Sex;//性别
	int Student_Number;//学号
	int Class;//班级
	Borrower(){
		this.Name="no name";
		this.Student_Number=0;
		this.Sex="unknown";
		this.Class=0;
	}
	Borrower(int Student_Number,String Name){
		this.Name=Name;
		this.Student_Number=Student_Number;
		this.Sex="unknown";
		this.Class=0;
	}
	Borrower(String Name,String Sex,int Student_Number,int Class){
		this.Name=Name;
		this.Student_Number=Student_Number;
		this.Sex=Sex;
		this.Class=Class;
	}
	void Print()
	{
		System.out.println("*****************************************************************************");
		System.out.println("Name : "+this.Name);
		System.out.println("Sex : "+this.Sex);
		System.out.println("Student_number : "+this.Student_Number);
		System.out.println("Class: : "+this.Class);
		System.out.println("*****************************************************************************");
	}
	void Borrow(Borrow_list List,String Book_Name,int Borrow_time)
	{
		List.add(this.Student_Number,Borrow_time,Book_Name);
	}
	int check(Borrower[] list,int lenth)
	{
		int temp=0,i;
		for(i=0;i<lenth;i++)
		{
			if(list[i].Student_Number==this.Student_Number&&this.Name.equals(list[i].Name))
			{temp=1;}
		}
		return temp;
	}
}


