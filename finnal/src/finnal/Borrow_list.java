package finnal;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Borrow_list {
	private String File_Name = "BorrowList";//初始化文件名
	private char[] input;
	private String input2;
	private String[] input3;
	int lenth;
	public List<Borrow> GetBorrowList()
	{
		List<Borrow> list = new ArrayList<>();
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
		for(int i=0;i<this.input3.length/3;i++)
		{
			list.add(new Borrow(Integer.parseInt(this.input3[3*i]),
					Integer.parseInt(this.input3[3*i+1]),
					this.input3[3*i+2]));
		}
		return list;
	}
	public List<Borrow> add(List<Borrow> list,Borrow b)
	{
		if(!ExistBor(list,b))
			list.add(b);
		return list;
	}
	public List<Borrow> Remove(List<Borrow> list,Borrow b)
	{
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getStudent_Number() == b.getStudent_Number() &&
					list.get(i).getBook_Name().equals(b.getBook_Name()) &&
					list.get(i).getBorrow_Time() == b.getBorrow_Time()
					) {
				list.remove(i);
				return list;
			}
		}
		return list;
	}
	public boolean WriteList(List<Borrow> list) {
		File Save=new File(this.File_Name);
		try {
		FileWriter Writer=new FileWriter(Save);
		for(int i=0;i<list.size();i++)
		{
			Writer.write(String.valueOf(list.get(i).getStudent_Number()));
			Writer.write("\r\n"); 
			Writer.write(String.valueOf(list.get(i).getBorrow_Time()));
			Writer.write("\r\n"); 
			Writer.write(list.get(i).getBook_Name());
			Writer.write("\r\n"); 
		}
		Writer.close();
		}
		catch(IOException a)
		{
			a.printStackTrace();
		}
		return true;
	}
	public boolean ExistBor(List<Borrow> list, Borrow b) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getStudent_Number() == b.getStudent_Number() &&
					list.get(i).getBook_Name().equals(b.getBook_Name()) &&
					list.get(i).getBorrow_Time() == b.getBorrow_Time()
					)
				return true;
		}
		return false;
	}
}
