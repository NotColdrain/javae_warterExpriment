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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInFrm extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameField;
	private JTextField UserNumField;

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
		setLocationRelativeTo(contentPane);
		setResizable(false);
		
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
		
		UserNameField = new JTextField();
		UserNameField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		UserNameField.setBounds(167, 97, 193, 43);
		contentPane.add(UserNameField);
		UserNameField.setColumns(10);
		
		UserNumField = new JTextField();
		UserNumField.setBounds(167, 175, 193, 43);
		contentPane.add(UserNumField);
		UserNumField.setColumns(10);
		
		JButton LogInBtn = new JButton("登录");
		LogInBtn.setIcon(new ImageIcon(LogInFrm.class.getResource("/image/login.png")));
		LogInBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LogInBtn.setBounds(115, 295, 113, 27);
		contentPane.add(LogInBtn);
		
		JButton ResetBtn = new JButton("重置");
		ResetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				UserNameField.setText("");
				UserNumField.setText("");
			}
		});
		ResetBtn.setIcon(new ImageIcon(LogInFrm.class.getResource("/image/delete.png")));
		ResetBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		ResetBtn.setBounds(273, 295, 113, 27);
		contentPane.add(ResetBtn);
	}
}
