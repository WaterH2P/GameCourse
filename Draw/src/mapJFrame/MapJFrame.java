package mapJFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class MapJFrame extends JFrame{
	public MapJFrame(){
		super("Draw 2D Shape Demo");
		setSize(350,350);
		MapPane map=new MapPane();
		getContentPane().add(map);
	}
	public static void main(String args[]){
		MapJFrame frame=new MapJFrame();
		frame.setVisible(true);
	}
}
class MapPane extends JPanel{
	public void paintComponent(Graphics g){
		
		//����Graphics2D����
		Graphics2D g2=(Graphics2D) g;
		
		//����Line2D����
		//ֱ��
		Line2D l=new Line2D.Float(1.0f,2.0f,150.0f,20.0f);
		g2.draw(l);
		
		//����Rectangle2D����
		//����
		Rectangle2D r=new Rectangle2D.Float(50,8,100,100);
		Color c=new Color(10,20,255);
		g2.setColor(c);
		g2.draw(r);
		
		//����Ellipse2D����
		//��Բ
		Ellipse2D e=new Ellipse2D.Double(200,180,100,100);
		g2.setColor(Color.GRAY);
		g2.fill(e);
		g2.drawString("java��Ϸ",100,200);
		
		//����CubicCurve2D���󣬱�ֱ�߶����������Ƶ�
		CubicCurve2D cubic=new CubicCurve2D.Float(0,100,120,50,170,270,220,50);
		g2.draw(cubic);
	}
}