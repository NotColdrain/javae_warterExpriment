package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.plaf.FontUIResource;

import finnal.Borrower;
import finnal.Borrower_Read;
import finnal.Borrower_Save;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
/**
 * 注册用户
 * @author LoveBeforT
 *
 */
public class RegisterUser extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7219404647365272787L;
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().trim().equals("") ||
						numField.getText().trim().equals("") ||
						classField.getText().trim().equals("") ||
						!(maleBtn.isSelected() || FemalBtn.isSelected())
						){
						JLabel label = new JLabel("输入框不能为空！");
						label.setForeground(Color.RED);
						label.setFont(new Font("幼圆", Font.BOLD, 16));
						UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("幼圆", Font.BOLD, 15)));
						JOptionPane.showMessageDialog(null, label);
						return;
					}
				String sex;
				if(maleBtn.isSelected())
					sex = "男";
				else
					sex = "女";
				Borrower u = new Borrower(nameField.getText().trim(),
						sex,
						Integer.parseInt(numField.getText().trim()),
						Integer.parseInt(classField.getText().trim()));
				Borrower_Read BDAO = new Borrower_Read("Borrower");
				if(BDAO.BorrowerExist(u)) {
					JLabel label = new JLabel("用户已经存在！");
					label.setForeground(Color.RED);
					label.setFont(new Font("幼圆", Font.BOLD, 16));
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("幼圆", Font.BOLD, 15)));
					JOptionPane.showMessageDialog(null, label);
					return;
				}
				List<Borrower> list = BDAO.Read_Borrower();
				list.add(u);
				Borrower_Save s = new Borrower_Save("Borrower");
				s.Save(list);
				JLabel label = new JLabel("保存成功！");
				label.setForeground(Color.RED);
				label.setFont(new Font("幼圆", Font.BOLD, 16));
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("幼圆", Font.BOLD, 15)));
				JOptionPane.showMessageDialog(null, label);
				return;
			}
		});
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
