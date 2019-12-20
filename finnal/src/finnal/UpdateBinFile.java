package finnal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ClassBookInfo{
	int classID;
	int bookNum;
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
}

public class UpdateBinFile {
	public void UpdateBin() throws IOException {
		String File_Name = "collection.bin";//初始化文件名
		Borrower_Read br = new Borrower_Read("Borrower");
		Borrow_list bl = new Borrow_list();
		List<Borrower> borlist = new ArrayList<>();
		List<Borrow> infolist = new ArrayList<>();
		List<ClassBookInfo> classList = new ArrayList<>();
		borlist = br.Read_Borrower();
		infolist = bl.GetBorrowList();
		for(int i=0;i<infolist.size();i++) {	//3层for嵌套，效率偏低
			int tempNum = infolist.get(i).getStudent_Number();
			for(int j = 0;j<borlist.size();j++) {
				if(tempNum == borlist.get(j).getStudent_Number()) {
					boolean flag = false;
					for(int k = 0;k<classList.size();k++) {
						if(borlist.get(j).getclass() == classList.get(k).getClassID()) {
							classList.get(k).setBookNum(classList.get(k).getBookNum()+1);
							flag = true;
							break;
						}
					}
					if(!flag) {
						ClassBookInfo c = new ClassBookInfo();
						c.bookNum = 1;
						c.classID = borlist.get(j).getclass();
						classList.add(c);
					}
					break;
				}
			}
			
		}

		String cwdpath = System.getProperty("user.dir") + "\\finnal\\bin\\graph\\";
		File Save=new File(cwdpath+File_Name);
		System.out.println(Save.getPath());
		FileWriter Writer=new FileWriter(Save);
		for(int i=0;i<classList.size();i++)
		{
			Writer.write(String.valueOf(classList.get(i).getClassID()));
			Writer.write(" "); 
			Writer.write(String.valueOf(classList.get(i).getBookNum()));
			if(i!=classList.size()-1)Writer.write("\r\n"); 
		}
		Writer.close();
		//调用exe
		Runtime.getRuntime().exec("cmd.exe /c cd " +cwdpath+ " & start graph.exe");
	}
}
