package strokeDemo;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class StrokeDemo extends JFrame{
	public StrokeDemo(){
		super();
		setTitle("Stroke Demo");
		setSize(300,200);
		setVisible(true);
	}
	public void paint(Graphics g){
		Graphics2D g2=(Graphics2D) g;
		Line2D l=new Line2D.Double(30,50,100,80);
		//创建一个BasicTroke对象来设置直线的绘制方式
		Stroke stroke=new BasicStroke(10.0f,
				BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
		g2.setStroke(stroke);
		g2.draw(l);
		
		Ellipse2D e=new Ellipse2D.Double(150,50,90,90);
		//创建一个BasicStroke对象来设置椭圆的绘制方式
		stroke =new BasicStroke(8,BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL,0,new float[]{10,5},0);
		g2.setStroke(stroke);
		g2.draw(e);
		Rectangle2D r=new Rectangle2D.Double(30,100,80,80);
		//创建一个BasicStroke对象来设置矩形的绘制方式
		stroke =new BasicStroke(10,BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_ROUND,0);
		g2.setStroke(stroke);
		g2.draw(r);
	}
	public static void main(String args[]){
		StrokeDemo sd=new StrokeDemo();
		sd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
