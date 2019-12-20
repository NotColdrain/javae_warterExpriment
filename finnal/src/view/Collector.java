package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import finnal.Borrow;
import finnal.Borrow_list;
import finnal.Borrower;
import finnal.Borrower_Read;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 统计信息
 * @author LoveBeforT
 *
 */
public class Collector extends JInternalFrame {
	private String name = "collection.jpg";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Collector frame = new Collector();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 统计按其它类别暂定
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws InterruptedException 
	 */
	public Collector() throws FileNotFoundException, IOException, InterruptedException {
		setTitle("统计数据");
		setClosable(true);
		setFrameIcon(new ImageIcon(Collector.class.getResource("/image/userName.png")));
		setBounds(50, 20, 660, 480);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		//按班级统计
		String cwdpath = System.getProperty("user.dir") + "\\finnal\\bin\\graph\\";
		ImageIcon icon = new ImageIcon(cwdpath+"collection.jpg");
		icon.setImage(icon.getImage().getScaledInstance(getWidth(), getHeight()-25,Image.SCALE_DEFAULT ));
		//lblNewLabel.setIcon(new ImageIcon(Collector.class.getResource("/graph/collection.jpg")));
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0, -30, 640, 480);
		getContentPane().add(lblNewLabel);
		//按类别统计........待定
	}
}