package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import finnal.Book;
import finnal.Read_Data;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class SearchBook extends JInternalFrame {
	private JTextField ISBN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBook frame = new SearchBook();
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
	public SearchBook() {
		setFrameIcon(new ImageIcon(SearchBook.class.getResource("/image/logo.png")));
		setClosable(true);
		setTitle("查询图书");
		setBounds(100, 100, 400, 240);
		getContentPane().setLayout(null);
		
		JLabel lblIsbn = new JLabel("ISBN：");
		lblIsbn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblIsbn.setBounds(50, 66, 72, 18);
		getContentPane().add(lblIsbn);
		
		ISBN = new JTextField();
		ISBN.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		ISBN.setBounds(119, 55, 176, 40);
		getContentPane().add(ISBN);
		ISBN.setColumns(10);
		
		JButton SearchBtn = new JButton("查询");
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ISBN.getText().trim().equals("")) {
					JLabel label = new JLabel("输入框为空！");
					label.setForeground(Color.RED);
					label.setFont(new Font("幼圆", Font.BOLD, 16));
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("幼圆", Font.BOLD, 15)));
					JOptionPane.showMessageDialog(null, label);
					return;
				}
				Read_Data r = new Read_Data("Books");
				List<Book> list = r.Read_Books();
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getISBN().equals(ISBN.getText().trim())) {
						JLabel label = new JLabel("<html>书名 ："+list.get(i).getName()
				                + "<br> ISBN :" + list.get(i).getISBN()
				                + "<br> 作者 ： " + list.get(i).getWriter_Name()
				                + "<br> 剩余量 ： " + list.get(i).getSurplus()
				                + "</html>"
				                ,JLabel.CENTER);
						label.setFont(new Font("幼圆", Font.BOLD, 16));
						UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("幼圆", Font.BOLD, 15)));
						JOptionPane.showMessageDialog(null, label);
						return;
					}
				}
				JLabel label = new JLabel("查询不到！");
				label.setForeground(Color.RED);
				label.setFont(new Font("幼圆", Font.BOLD, 16));
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("幼圆", Font.BOLD, 15)));
				JOptionPane.showMessageDialog(null, label);
				return;
			}
		});
		SearchBtn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		SearchBtn.setBounds(119, 136, 128, 40);
		getContentPane().add(SearchBtn);

	}
}
