package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class test {

	private final int frameWidth = 320;
	private final int frameHeight = 480;
	private JFrame frame = new JFrame();
	
	public void test1(){
		JPanel jpanel = new FirstUI();
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);
		
		frame.setLocation(450, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(jpanel);
	}
	
	public static void main(String args[]){
		new test().test1();
	}
}
