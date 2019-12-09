package finnal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
public class Borrow_Book_ui {
	Borrow_Book_ui(Borrower user)
	{
		
		JFrame frame = new JFrame("借书");
        frame.setSize(600, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel welcome_label=new JLabel("欢迎使用借书服务");
        welcome_label.setBounds(50, 50, 150, 50);
        panel.add(welcome_label);
        
        JLabel BookLabel = new JLabel("书名:");
        BookLabel.setBounds(10,100,100,25);
        panel.add(BookLabel);
        JTextField BookText = new JTextField(20);
        BookText.setBounds(120,100,165,25);
        panel.add(BookText);
        
        JLabel time_Label = new JLabel("借书时间:");
        time_Label.setBounds(10,150,100,25);
        panel.add(time_Label);
        JTextField time_Text = new JTextField(20);
        time_Text.setBounds(120,150,165,25);
        panel.add(time_Text);
       
        frame.add(panel);
        JButton submitButton = new JButton("提交");
        submitButton.setBounds(10, 200, 80, 25);
     
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
			{
        		Read_Data Book_list=new Read_Data("Books");
        		Book[] temp=new Book[1000];
        		int num;
        		num=Book_list.Read_Books(temp);
				Borrow_list list=new Borrow_list("Borrow_list",temp,num);
				list.read_list();
				if(list.add(user.Student_Number,Integer.parseInt(time_Text.getText()), BookText.getText())==1)
				{JOptionPane.showMessageDialog(null, "借书成功");}
				else
				{JOptionPane.showMessageDialog(null, "书名不存在");}	
				list.save_list();
			}
        });
        frame.setVisible(true);
	}
}
