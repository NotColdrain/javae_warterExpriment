package finnal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class logged {
	Borrower user;
	logged(Borrower user)
	{
		this.user=user;
		JFrame frame = new JFrame("图书借阅管理系统");
        frame.setSize(600, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel welcome_label=new JLabel("欢迎使用图书借阅系统，选择你想使用的服务");
        welcome_label.setBounds(50, 50, 50, 50);
        panel.add(welcome_label);
        
        JButton Borrow=new JButton("借书");
        Borrow.setBounds(100,50,100,50);
        frame.add(Borrow);
        Borrow.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		new Borrow_Book_ui(user);
        	}
        });
        
        JButton Return=new JButton("还书");
        Return.setBounds(100,150,100,50);
        frame.add(Return);
        Return.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		new Return_Book_ui();
        	}
        });
        JButton Class_check=new JButton("按班级查询借书情况");
        Class_check.setBounds(100,250,150,50);
        frame.add(Class_check);
        Class_check.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		//这里调用py输出一张图片然后把图片显示出来。//
        	}
        });
        
        frame.add(panel);
        frame.setVisible(true);
	}
}
