package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import finnal.Borrower;
import finnal.Manager;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private String version = " Alpha 0.2";
	private JDesktopPane table = new JDesktopPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager u = null;
					MainFrm frame = new MainFrm(u);
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
	public MainFrm(Manager u) {
		setResizable(false);
		setTitle("图书借阅系统	" + 
				version 
				+ "   你好! (｡•ˇ‸ˇ•｡) —— " 
				+ u.getManagerName()
				);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/image/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 580);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("菜单");
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("注册借书人");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterUser regUser = new RegisterUser();
				regUser.setVisible(true);
				table.add(regUser);
			}
		});
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("新进图书");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook add = new AddBook();
				add.setVisible(true);
				table.add(add);
			}
		});
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("查询图书");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBook sh = new SearchBook();
				sh.setVisible(true);
				table.add(sh);
			}
		});
		menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(menuItem_2);
		
		JMenuItem menuItem_4 = new JMenuItem("办理借书手续");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowBook bb = new BorrowBook();
				bb.setVisible(true);
				table.add(bb);
			}
		});
		
		JMenuItem menuItem_3 = new JMenuItem("归还图书");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook bb = new ReturnBook();
				bb.setVisible(true);
				table.add(bb);
			}
		});
		menuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(menuItem_3);
		menuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("统计数据");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Collector c = new Collector();
					c.setVisible(true);
					table.add(c);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		menuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(menuItem_5);
		
		JMenuItem About = new JMenuItem("关于");
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("<html>图书借阅系统"+version
		                + "<br> 制作组:张红江、吕烈羽、高原寒、聂致远、张传 "
		                + "<br> 2019.12.18(C)</html>",JLabel.CENTER);
				label.setFont(new Font("幼圆", Font.BOLD, 16));
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("幼圆", Font.BOLD, 15)));
				JOptionPane.showMessageDialog(null, label);
			}
		});
		About.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(About);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(contentPane);
		contentPane.setLayout(null);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
