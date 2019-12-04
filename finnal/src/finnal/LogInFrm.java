package finnal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class LogInFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInFrm frame = new LogInFrm();
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
	public LogInFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("图书借阅系统");
		lblNewLabel.setIcon(new ImageIcon(LogInFrm.class.getResource("/image/logo.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel.setBounds(135, 13, 227, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("学生名:");
		lblNewLabel_1.setIcon(new ImageIcon(LogInFrm.class.getResource("/image/userName.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel_1.setBounds(69, 109, 83, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("学号 ：");
		lblNewLabel_2.setIcon(new ImageIcon(LogInFrm.class.getResource("/image/password.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel_2.setBounds(69, 185, 83, 33);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField.setBounds(167, 97, 193, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 175, 193, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("登录");
		button.setIcon(new ImageIcon(LogInFrm.class.getResource("/image/login.png")));
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button.setBounds(115, 295, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("重置");
		button_1.setIcon(new ImageIcon(LogInFrm.class.getResource("/image/delete.png")));
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_1.setBounds(273, 295, 113, 27);
		contentPane.add(button_1);
	}
}
