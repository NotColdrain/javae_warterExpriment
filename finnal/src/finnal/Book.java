package finnal;

public class Book {
	private String Name;//书名
	private int Surplus;//剩余量（在馆本数）
	private String ISBN;//书好
	private String Writer_Name;//作者名
	public Book(){
		this.ISBN="no ISBN";
		this.Name="no name";
		this.Surplus=0;
		this.Writer_Name="no name";
	}
	public Book(String Name,int Surplus,String ISBN,String Writer_Name){
		this.ISBN=ISBN;
		this.Name=Name;
		this.Surplus=Surplus;
		this.Writer_Name=Writer_Name;
	}
	public void Print()
	{
		System.out.println("*****************************************************************************");
		System.out.println("Name : "+this.Name);
		System.out.println("Surplus : "+this.Surplus);
		System.out.println("ISBN : "+this.ISBN);
		System.out.println("Writer_Name : "+this.Writer_Name);
		System.out.println("*****************************************************************************");
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getSurplus() {
		return Surplus;
	}
	public void setSurplus(int surplus) {
		Surplus = surplus;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getWriter_Name() {
		return Writer_Name;
	}
	public void setWriter_Name(String writer_Name) {
		Writer_Name = writer_Name;
	}
}