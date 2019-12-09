package finnal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
public class login_false {
			login_false()
			{
				JFrame frame = new JFrame("学生信息不存在");
				frame.setSize(100, 100);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JPanel panel = new JPanel();
				JLabel False=new JLabel("学生信息不存在");
				panel.add(False);
		        frame.add(panel);
		        frame.setVisible(true);
			}
}
