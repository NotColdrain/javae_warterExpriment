package finnal;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Read_Data {
	private String File_Name;//初始化文件名
	private char[] input;
	private String input2;
	private String[] input3;
	public Read_Data(String File_Name)
	{
		this.File_Name=File_Name; 
	}
	public List<Book> Read_Books()
	{
		List<Book> Book_Data = new ArrayList<>();
		try {
			this.input=new char[100000];
			File input=new File(File_Name);
			FileReader reader=new FileReader(input);
			reader.read(this.input);
			reader.close();
		}
		catch(IOException a)
		{
			a.printStackTrace();
		}
		this.input2=new String(this.input);
		this.input3=this.input2.split("\n");
		for(int i=0;i<input3.length;i++)
		{
			input3[i]=input3[i].substring(0,input3[i].length()-1);
		}
		for(int i=0;i<this.input3.length/4;i++)
		{
			Book_Data.add(new Book(this.input3[4*i],
					Integer.parseInt(this.input3[4*i+1]),
					this.input3[4*i+2],
					this.input3[4*i+3]));
		}
		return Book_Data;
	}
}
