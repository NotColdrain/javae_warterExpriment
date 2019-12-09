package finnal;
import java.io.*;
import java.util.List;

public class Borrower_Save {
	String File_Name;
	public Borrower_Save(String File_Name)
	{
		this.File_Name=File_Name; 
	}
	public void Save(List<Borrower> Borrower_Data)
	{
		int i;
		File Save=new File(this.File_Name);
		try {
		FileWriter Writer=new FileWriter(Save);
		for(i=0;i<Borrower_Data.size();i++)
		{
			Writer.write(Borrower_Data.get(i).Name);
			Writer.write("\r\n"); 
			Writer.write(Borrower_Data.get(i).Sex);
			Writer.write("\r\n"); 
			Writer.write(String.valueOf(Borrower_Data.get(i).Student_Number));
			Writer.write("\r\n"); 
			Writer.write(String.valueOf(Borrower_Data.get(i).Class));
			Writer.write("\r\n"); 
		}
		Writer.close();
		}
		catch(IOException a)
		{
			a.printStackTrace();
		}
	}
}