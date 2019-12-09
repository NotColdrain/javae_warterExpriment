package finnal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
public class UI { 
	    UI() 
	    {    
	        JFrame frame = new JFrame("图书借阅管理系统");
	        frame.setSize(600, 480);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JPanel panel = new JPanel();    
	        frame.add(panel);
	        placeComponents(panel);
	        frame.setVisible(true);
	    }

	    private static void placeComponents(JPanel panel) {
	        panel.setLayout(null);
	        JLabel welcome=new JLabel("欢迎使用，请输入学生名和学生号:");
	        panel.add(welcome);	
	        welcome.setBounds(10,20,200,50);
	        
	        JLabel userLabel = new JLabel("学生名:");
	        userLabel.setBounds(10,100,80,25);
	        panel.add(userLabel);
	        JTextField userText = new JTextField(20);
	        userText.setBounds(100,100,165,25);
	        panel.add(userText);
	        
	        JLabel student_number_Label = new JLabel("学号:");
	        student_number_Label.setBounds(10,150,80,25);
	        panel.add(student_number_Label);
	        JTextField student_number_Text = new JTextField(20);
	        student_number_Text.setBounds(100,150,165,25);
	        panel.add(student_number_Text);
	        
	        JButton loginButton = new JButton("登录");
	        loginButton.setBounds(10, 250, 80, 25);
	        panel.add(loginButton);
	        loginButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
				{
					Borrower user=new Borrower(Integer.parseInt(student_number_Text.getText()),userText.getText());
					Borrower_Read temp=new Borrower_Read("Borrower");
					Borrower list[]=new Borrower[1000];
					int num;
					num=temp.Read_Borrower(list);
					if(user.check(list, num)==0)//
					{
						JOptionPane.showMessageDialog(null, "学生不存在");
					}
					else
					{
						new logged(user);
					}
				}
	        });
	    }

	}

