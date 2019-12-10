package finnal;
import java.io.*;
import java.util.List;

public class Save_Data {
	String File_Name;
	public Save_Data(String File_Name)
	{
		this.File_Name=File_Name; 
	}
	public boolean Save(List<Book> Data)
	{
		File Save=new File(this.File_Name);
		try {
			FileWriter Writer=new FileWriter(Save);
			for(int i=0;i<Data.size();i++)
			{
				Writer.write(Data.get(i).getName());
				Writer.write("\r\n"); 
				Writer.write(String.valueOf(Data.get(i).getSurplus()));
				Writer.write("\r\n"); 
				Writer.write(Data.get(i).getISBN());
				Writer.write("\r\n"); 
				Writer.write(Data.get(i).getWriter_Name());
				Writer.write("\r\n"); 
			}
			Writer.close();
			return true;
		}
		catch(IOException a)
		{
			a.printStackTrace();
			return false;
		}
	}
}
