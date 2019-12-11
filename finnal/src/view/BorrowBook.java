package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BorrowBook extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowBook frame = new BorrowBook();
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
	public BorrowBook() {
		setClosable(true);
		setTitle("办理借书手续");
		setFrameIcon(new ImageIcon(BorrowBook.class.getResource("/image/logo.png")));
		setBounds(100, 100, 540, 300);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("借阅人学号：");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label.setBounds(26, 55, 101, 28);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(131, 50, 118, 36);
		getContentPane().add(textField);
		
		JLabel lblisbn = new JLabel("图书ISBN：");
		lblisbn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblisbn.setBounds(266, 52, 88, 28);
		getContentPane().add(lblisbn);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(368, 50, 118, 36);
		getContentPane().add(textField_1);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button.setBounds(192, 171, 128, 50);
		getContentPane().add(button);

	}

}
