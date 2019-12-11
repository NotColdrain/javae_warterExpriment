package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddBook extends JInternalFrame {
	private JTextField bookname;
	private JTextField isbn;
	private JTextField bookclass;
	private JTextField author;
	private JTextField booknum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setFrameIcon(new ImageIcon(AddBook.class.getResource("/image/logo.png")));
		setTitle("新进图书");
		setClosable(true);
		setBounds(100, 100, 500, 360);
		getContentPane().setLayout(null);
		
		JButton AddBtn = new JButton("确定");
		AddBtn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		AddBtn.setBounds(173, 258, 118, 36);
		getContentPane().add(AddBtn);
		
		JLabel label = new JLabel("图书名称：");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label.setBounds(29, 24, 80, 28);
		getContentPane().add(label);
		
		bookname = new JTextField();
		bookname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bookname.setBounds(115, 19, 118, 36);
		getContentPane().add(bookname);
		bookname.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN：");
		lblIsbn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblIsbn.setBounds(247, 24, 80, 28);
		getContentPane().add(lblIsbn);
		
		isbn = new JTextField();
		isbn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		isbn.setColumns(10);
		isbn.setBounds(333, 19, 118, 36);
		getContentPane().add(isbn);
		
		JLabel label_1 = new JLabel("分类号：");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_1.setBounds(29, 110, 80, 28);
		getContentPane().add(label_1);
		
		bookclass = new JTextField();
		bookclass.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bookclass.setColumns(10);
		bookclass.setBounds(115, 105, 118, 36);
		getContentPane().add(bookclass);
		
		JLabel label_2 = new JLabel("作者：");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_2.setBounds(247, 107, 80, 28);
		getContentPane().add(label_2);
		
		author = new JTextField();
		author.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		author.setColumns(10);
		author.setBounds(333, 102, 118, 36);
		getContentPane().add(author);
		
		JLabel label_3 = new JLabel("数量：");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_3.setBounds(133, 187, 80, 28);
		getContentPane().add(label_3);
		
		booknum = new JTextField();
		booknum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		booknum.setColumns(10);
		booknum.setBounds(219, 182, 118, 36);
		getContentPane().add(booknum);

	}

}
