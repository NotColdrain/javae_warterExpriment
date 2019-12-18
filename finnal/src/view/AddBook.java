package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import finnal.Book;
import finnal.Read_Data;
import finnal.Save_Data;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
/**
 * 添加图书
 * @author LoveBeforT
 *
 */
public class AddBook extends JInternalFrame {
	private JTextField bookname;
	private JTextField isbn;
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
		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bookname.getText().trim().equals("") ||
						booknum.getText().trim().equals("") ||
						isbn.getText().trim().equals("") ||
						author.getText().trim().equals("")
						){
							JLabel label = new JLabel("输入框不能为空！");
							label.setForeground(Color.RED);
							label.setFont(new Font("幼圆", Font.BOLD, 16));
							UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("幼圆", Font.BOLD, 15)));
							JOptionPane.showMessageDialog(null, label);
							return;
					}
				Book b = new Book(bookname.getText(),Integer.parseInt(booknum.getText()),isbn.getText(),author.getText());
				Read_Data br = new Read_Data("Books");
				List<Book> list = br.Read_Books();
				Save_Data s = new Save_Data("Books");
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getISBN().equals(b.getISBN())) {
						list.get(i).setSurplus(list.get(i).getSurplus()+b.getSurplus());
						s.Save(list);
						JLabel label = new JLabel("添加成功！");
						label.setForeground(Color.RED);
						label.setFont(new Font("幼圆", Font.BOLD, 16));
						UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("幼圆", Font.BOLD, 15)));
						JOptionPane.showMessageDialog(null, label);
						return;
					}
				}
				list.add(b);
				s.Save(list);
				JLabel label = new JLabel("添加成功！");
				label.setForeground(Color.RED);
				label.setFont(new Font("幼圆", Font.BOLD, 16));
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("幼圆", Font.BOLD, 15)));
				JOptionPane.showMessageDialog(null, label);
				return;
			}
		});
		AddBtn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		AddBtn.setBounds(173, 245, 118, 36);
		getContentPane().add(AddBtn);
		
		JLabel label = new JLabel("图书名称：");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label.setBounds(29, 63, 80, 28);
		getContentPane().add(label);
		
		bookname = new JTextField();
		bookname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bookname.setBounds(115, 58, 118, 36);
		getContentPane().add(bookname);
		bookname.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN：");
		lblIsbn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblIsbn.setBounds(247, 63, 80, 28);
		getContentPane().add(lblIsbn);
		
		isbn = new JTextField();
		isbn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		isbn.setColumns(10);
		isbn.setBounds(333, 58, 118, 36);
		getContentPane().add(isbn);
		
		JLabel label_2 = new JLabel("作者：");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_2.setBounds(29, 153, 80, 28);
		getContentPane().add(label_2);
		
		author = new JTextField();
		author.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		author.setColumns(10);
		author.setBounds(115, 148, 118, 36);
		getContentPane().add(author);
		
		JLabel label_3 = new JLabel("数量：");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_3.setBounds(247, 153, 80, 28);
		getContentPane().add(label_3);
		
		booknum = new JTextField();
		booknum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		booknum.setColumns(10);
		booknum.setBounds(333, 148, 118, 36);
		getContentPane().add(booknum);

	}

}
