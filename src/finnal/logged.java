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
		JFrame frame = new JFrame("ͼ����Ĺ���ϵͳ");
        frame.setSize(600, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel welcome_label=new JLabel("��ӭʹ��ͼ�����ϵͳ��ѡ������ʹ�õķ���");
        welcome_label.setBounds(50, 50, 50, 50);
        panel.add(welcome_label);
        
        JButton Borrow=new JButton("����");
        Borrow.setBounds(100,50,100,50);
        frame.add(Borrow);
        Borrow.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		new Borrow_Book_ui(user);
        	}
        });
        
        JButton Return=new JButton("����");
        Return.setBounds(100,150,100,50);
        frame.add(Return);
        Return.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		new Return_Book_ui();
        	}
        });
        JButton Class_check=new JButton("���༶��ѯ�������");
        Class_check.setBounds(100,250,150,50);
        frame.add(Class_check);
        Class_check.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		//�������py���һ��ͼƬȻ���ͼƬ��ʾ������//
        	}
        });
        
        frame.add(panel);
        frame.setVisible(true);
	}
}
