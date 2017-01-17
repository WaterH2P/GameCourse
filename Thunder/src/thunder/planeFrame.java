package thunder;

import java.awt.Container;
import javax.swing.JFrame;

public class planeFrame extends JFrame{
	public planeFrame(){
		setTitle("Thunder");
		GamePanel panel=new GamePanel();
		Container contentpane=getContentPane();
		contentpane.add(panel);
		pack();
	}
	
	public static void main(String args[]){
		planeFrame el=new planeFrame();
		el.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		el.setVisible(true);
	}
}
