package drawImageDemo;
//在框架中绘制直线/矩形和椭圆
import java.awt.*;
import javax.swing.*;
public class DrawImageDemo extends JFrame{
	public DrawImageDemo(){
		super();
		setTitle("Draw Line Rectangle Ellipse");
		setSize(300,300);
		setVisible(true);
	}
	public void paint(Graphics g){
		//绘制直线， 空心矩形和空心椭圆
		g.setColor(Color.red);
		g.drawRect(30,50,getWidth()/2-50,getHeight()/2-50);
		g.drawOval(30,50,getWidth()/2-50,getHeight()/2-50);
		g.drawLine(30,50,30+getWidth()/2-50,50+getHeight()/2-50);
		
		//绘制填充色位淡灰色的3D矩形，圆角矩形和椭圆
		g.setColor(Color.LIGHT_GRAY);
		g.fill3DRect(30,180,getWidth()/2-50,getHeight()/2-50,true);
		g.fillRoundRect(150,50,getWidth()/2-50,getHeight()/2-50,30,40);
		g.fillOval(150,180,getWidth()/2-30,getHeight()/2-50);
	}
	public static void main(String args[]){
		DrawImageDemo d=new DrawImageDemo();
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
