package finnal;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Borrow{
	int Student_Number;
	int Borrow_Time;
	String Book_Name;
	Borrow()
	{
		this.Book_Name="no name";
		this.Borrow_Time=0;
		this.Student_Number=0;
	}
	Borrow(int Student_number,int Borrow_time,String Book_name)
	{
		this.Book_Name=Book_name;
		this.Borrow_Time=Borrow_time;
		this.Student_Number=Student_number;
	}
}
public class Borrow_list {
Borrow Book_Borrow[];
Book Book_list[];
String File;
int lenth;
int Book_lenth;
char[] input;
String input2;
String[] input3;

Borrow_list(String File,Book[] Book_list,int Book_lenth)
{
	this.File=File;
	this.Book_list=Book_list;
	this.Book_lenth=Book_lenth;
	int i;
	this.Book_Borrow=new Borrow[1000];
	for(i=0;i<1000;i++)
		this.Book_Borrow[i]=new Borrow();
}
int read_list()
	{
	int i;
	try {
		this.input=new char[100000];
		File input=new File(this.File);
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
	for(i=0;i<input3.length;i++)
	{
		input3[i]=input3[i].substring(0,input3[i].length()-1);
	}
	int number=Integer.valueOf(this.input3[0]);
	this.lenth=number;
	for(i=0;i<number;i++)
	{
		this.Book_Borrow[i].Book_Name=input3[1+3*i];
		this.Book_Borrow[i].Borrow_Time=Integer.parseInt(this.input3[2+3*i]);
		this.Book_Borrow[i].Student_Number=Integer.parseInt(this.input3[3+3*i]);
	}
	return number;
	}
int add(int Student_number,int Borrow_time,String Book_name)
{
	
	int sign=0;
	int i;
	for(i=0;i<this.Book_lenth;i++)
	{
		if(this.Book_list[i].Name.equals(Book_name))
				{this.Book_list[i].Surplus--;
				sign=1;
				}
			
	}
	if(sign==1) {
		this.Book_Borrow[lenth]=new Borrow(Student_number,Borrow_time,Book_name);
		this.lenth++;
	}
	
	return sign;
}
int Return_Book(int Student_Number,String Book_Name)
{
	int i=0;
	while(!(this.Book_Borrow[i].Book_Name.equals(Book_Name)&&this.Book_Borrow[i].Student_Number==Student_Number))
	{
		i++;
		if(i==lenth-1)
		{
		return 0;
		}
	}
	while(i<lenth)
	{
		this.Book_Borrow[i]=this.Book_Borrow[i+1];
		i++;
	}
	
	for(i=0;i<this.Book_lenth;i++)
	{
		if(this.Book_list[i].Name.equals(Book_Name))
				this.Book_list[i].Surplus++;
			
	}
	lenth--;
	return 1;
}

void save_list()
{
	int i;
	File Save=new File(this.File);
	try {
	FileWriter Writer=new FileWriter(Save);
	Writer.write(String.valueOf(this.lenth));
	Writer.write("\r\n"); 
	for(i=0;i<this.lenth;i++)
	{
		Writer.write(this.Book_Borrow[i].Book_Name);
		Writer.write("\r\n"); 
		Writer.write(String.valueOf(this.Book_Borrow[i].Borrow_Time));
		Writer.write("\r\n"); 
		Writer.write(String.valueOf(this.Book_Borrow[i].Student_Number));
		Writer.write("\r\n"); 
	}
	Writer.close();
	}
	catch(IOException a)
	{
		a.printStackTrace();
	}
	
	Save_Data Book_save=new Save_Data("Book");
	Book_save.Save(this.Book_list, this.Book_lenth);
	
	
}
}