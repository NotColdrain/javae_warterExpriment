package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class RegisterUser extends JInternalFrame {
	private JTextField nameField;
	private JTextField numField;
	private JTextField classField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUser frame = new RegisterUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterUser() {
		setClosable(true);
		setTitle("注册借书人");
		setFrameIcon(new ImageIcon(RegisterUser.class.getResource("/image/userName.png")));
		setBounds(100, 100, 450, 300);
		
		nameField = new JTextField();
		nameField.setBounds(64, 42, 128, 36);
		nameField.setColumns(10);
		
		JLabel label = new JLabel("姓名：");
		label.setBounds(14, 50, 72, 18);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		numField = new JTextField();
		numField.setBounds(270, 42, 128, 36);
		numField.setColumns(10);
		
		JLabel label_1 = new JLabel("学号：");
		label_1.setBounds(220, 50, 72, 18);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		classField = new JTextField();
		classField.setBounds(270, 108, 128, 36);
		classField.setColumns(10);
		
		JLabel label_2 = new JLabel("班级：");
		label_2.setBounds(220, 116, 72, 18);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("性别：");
		label_3.setBounds(14, 117, 72, 18);
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JRadioButton maleBtn = new JRadioButton("男");
		maleBtn.setBounds(78, 113, 48, 27);
		maleBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JRadioButton FemalBtn = new JRadioButton("女");
		FemalBtn.setBounds(132, 113, 48, 27);
		FemalBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		ButtonGroup group = new ButtonGroup();
		group.add(maleBtn);
		group.add(FemalBtn);
		
		JButton button = new JButton("注册");
		button.setBounds(150, 185, 116, 42);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		getContentPane().setLayout(null);
		getContentPane().add(nameField);
		getContentPane().add(label);
		getContentPane().add(numField);
		getContentPane().add(label_1);
		getContentPane().add(classField);
		getContentPane().add(label_2);
		getContentPane().add(label_3);
		getContentPane().add(maleBtn);
		getContentPane().add(FemalBtn);
		getContentPane().add(button);
		
	}

}
