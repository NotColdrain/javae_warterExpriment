package finnal;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Borrower_Read {
	String File_Name;//初始化文件名
	char[] input;
	String input2;
	String[] input3;
	public Borrower_Read(String File_Name)
	{
		this.File_Name=File_Name; 
	}
	public List<Borrower> Read_Borrower()
	{
		List<Borrower> Bor = new ArrayList<>();
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
			Borrower temp=new Borrower(this.input3[4*i],
					this.input3[4*i+1],
					Integer.parseInt(this.input3[4*i+2]),
					Integer.parseInt(this.input3[4*i+3]));
			Bor.add(temp);
		}
		return Bor;
	}
}
