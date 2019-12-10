package finnal;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RUN {

	public static void main(String[] args) {
		List<Book> Data=new ArrayList<>();
		File Book_data=new File("Books");
		if(!Book_data.exists())
			{
			Data.add(new Book("Math",300,"978-7-03-061207-6","NXY"));
			Data.add(new Book("Java",200,"978-7-5647-0389-9","JCH"));
			Data.add(new Book("Probability_Theory",150,"978-7-04-046386-6","XQZ"));
			System.out.println("图书数据不存在，已经初始化创建了默认数据");
			for(int i=0;i<3;i++)
			{
				System.out.println("BookNumber:"+i);
				Data.get(i).Print();
			}
			}
		else{
			Read_Data in=new Read_Data("Books");
			Data=in.Read_Books();
			System.out.println("录入完毕，一共导入了"+Data.size()+"本书籍信息");
			for(int i=0;i<Data.size();i++)
			{
				Data.get(i).Print();
			}
		}
		
		
		List<Borrower> Borrower_Data = new ArrayList<>();
		File Borrower_data=new File("Borrower");
		if(!Borrower_data.exists())
			{
			Borrower_Data.add(new Borrower("John","male",20180916,1));
			Borrower_Data.add(new Borrower("Mike","male",20180917,2));
			Borrower_Data.add(new Borrower("Ann","female",20180918,1));
			System.out.println("借书者数据不存在，已经初始化创建了默认数据");
			}
		else{
			Borrower_Read in=new Borrower_Read("Borrower");
			Borrower_Data=in.Read_Borrower();
			System.out.println("录入完毕，一共导入了"+Borrower_Data.size()+"个借书者信息");
		}
		while(true)
		{
			System.out.println("欢迎使用书籍管理借阅系统");
			System.out.println("********************************************");
			System.out.println("");
			break;
		}
		
		
		Save_Data Save=new Save_Data("Books");
		Save.Save(Data);
		System.out.println("书籍信息保存成功");
		
		Borrower_Save B_Save=new Borrower_Save("Borrower");
		B_Save.Save(Borrower_Data);
		System.out.println("借书者保存成功");
		new UI();
	}

}
