package finnal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Return_Book_ui {
	Return_Book_ui()
	{
		JFrame frame = new JFrame("还书");
        frame.setSize(600, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel welcome_label=new JLabel("欢迎使用还书服务");
        welcome_label.setBounds(50, 50, 150, 50);
        panel.add(welcome_label);
        
        JLabel BookLabel = new JLabel("书名:");
        BookLabel.setBounds(10,100,100,25);
        panel.add(BookLabel);
        JTextField BookText = new JTextField(20);
        BookText.setBounds(120,100,165,25);
        panel.add(BookText);
        
        JLabel student_number_Label = new JLabel("学生号:");
        student_number_Label.setBounds(10,150,100,25);
        panel.add(student_number_Label);
        JTextField student_number_Text = new JTextField(20);
        student_number_Text.setBounds(120,150,165,25);
        panel.add(student_number_Text);
        
        
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
				if(list.Return_Book(Integer.parseInt(student_number_Text.getText()),BookText.getText())==1)
				{
					JOptionPane.showMessageDialog(null, "还书成功");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "借书记录不存在");
				}
				list.save_list();
			}
        });
        
        frame.setVisible(true);
	}
}
