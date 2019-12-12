package finnal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * 管理员函数库
 * @author LoveBeforT
 *
 */
public class Manager {
	private String ManagerName;
	private String ManagerPassWord;
	private String File_Name = "Manager";
	
	public String getManagerName() {
		return ManagerName;
	}
	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}
	public String getManagerPassWord() {
		return ManagerPassWord;
	}
	public void setManagerPassWord(String managerPassWord) {
		ManagerPassWord = managerPassWord;
	}
	public Manager(String ManagerName,String ManagerPassWord) {
		this.ManagerName = ManagerName;
		this.ManagerPassWord = ManagerPassWord;
	}
	public Manager() {
		
	}
	/**
	 * 保存管理员
	 * @return
	 * @throws IOException 
	 */
	public boolean ManagerSave(List<Manager> Manager_Data) throws IOException {
		File Save=new File(File_Name);
		FileWriter Writer=new FileWriter(Save);
		for(int i=0;i<Manager_Data.size();i++)
		{
			Writer.write(Manager_Data.get(i).getManagerName());
			Writer.write("\r\n"); 
			Writer.write(Manager_Data.get(i).ManagerPassWord);
			Writer.write("\r\n"); 
		}
		Writer.close();
		return true;
	}
	/**
	 * 获取管理员
	 * @return
	 * @throws IOException 
	 */
	private List<Manager> ReadManager() throws IOException{
		char[] buf = new char[100000];
		List<Manager> Manager_Data = new ArrayList<>();
		File input=new File(File_Name);
		FileReader reader=new FileReader(input);
		reader.read(buf);
		reader.close();
		String data=new String(buf);
		String[] temp = data.split("\n");
		for(int i=0;i<temp.length;i++)
		{
			temp[i]=temp[i].substring(0,temp[i].length()-1);
		}
		for(int i=0;i<temp.length/2;i++)
		{
			Manager_Data.add(new Manager(temp[2*i],
					temp[2*i+1]));
		}
		return Manager_Data;
		
	}
	/**
	 * 登录
	 * @param u
	 * @return
	 * @throws IOException 
	 */
	public Manager LogIn(Manager u) throws IOException {
		System.out.println("用户名:" +
				u.getManagerName()
		);
		System.out.println("密码:" +
				u.getManagerPassWord()
		);
		List<Manager> Manager_Data = new ArrayList<>();
		Manager_Data = this.ReadManager();
		for(int i = 0;i<Manager_Data.size();i++) {
			System.out.println("数据用户名:" +
					Manager_Data.get(i).getManagerName()
			);
			System.out.println("数据密码:" +
					Manager_Data.get(i).getManagerPassWord()
			);
			if(u.getManagerName().equals(Manager_Data.get(i).getManagerName()) &&
				u.getManagerPassWord().equals(Manager_Data.get(i).getManagerPassWord())
			){
				return u;
			}
		}
		return null;
	}
}
