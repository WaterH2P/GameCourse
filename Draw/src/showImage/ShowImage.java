package showImage;
import java.awt.*;
import javax.swing.JFrame;

public class ShowImage extends JFrame{
	String filename;
	public ShowImage(String filename){
		setSize(500,450);
		setVisible(true);
		this.filename=filename;
	}
	public void paint(Graphics g){
		Image img=getToolkit().getImage(filename);
		//获取Image对象，加载图像
		int w=img.getWidth(this);
		int h=img.getHeight(this);
		g.drawImage(img,46,51,this);
		g.drawImage(img,230,255,w/2,h/2,this);
		g.drawImage(img,150,180,w*2,h/2,this);
		g.drawImage(img,300,130,w/2,h*2,this);
	}
	public static void main(String args[]){
		new ShowImage("Image\\sb.jpg");
	}
}
