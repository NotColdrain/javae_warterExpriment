package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import finnal.Borrower;

import java.awt.Toolkit;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private String version = " Alpha 0.1";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrower u = null;
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
	public MainFrm(Borrower u) {
		setResizable(false);
		setTitle("图书借阅系统	" + 
				version + 
				"   你好! " +
				u.getName()
				);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/image/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(contentPane);
	}

}
