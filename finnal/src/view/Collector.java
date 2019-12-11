package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;

public class Collector extends JInternalFrame {

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
	 * Create the frame.
	 */
	public Collector() {
		setTitle("统计数据");
		setClosable(true);
		setFrameIcon(new ImageIcon(Collector.class.getResource("/image/userName.png")));
		setBounds(100, 100, 450, 300);

	}

}
