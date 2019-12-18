package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import finnal.Borrow;
import finnal.Borrow_list;
import finnal.Borrower;
import finnal.Borrower_Read;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
/**
 * 统计信息
 * @author LoveBeforT
 *
 */
public class Collector extends JInternalFrame {
	private String name = "collection.jpg";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Collector frame = new Collector();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 统计按其它类别暂定
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws InterruptedException 
	 */
	public Collector() throws FileNotFoundException, IOException, InterruptedException {
		setTitle("统计数据");
		setClosable(true);
		setFrameIcon(new ImageIcon(Collector.class.getResource("/image/userName.png")));
		setBounds(50, 20, 660, 480);
		getContentPane().setLayout(null);
		
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
		Thread.sleep(4000);
		JLabel lblNewLabel = new JLabel("");
		//按班级统计
		lblNewLabel.setIcon(new ImageIcon(Collector.class.getResource("/graph/collection.jpg")));
		lblNewLabel.setBounds(0, -30, 640, 480);
		getContentPane().add(lblNewLabel);
		//按类别统计........待定
	}
}