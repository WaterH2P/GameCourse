package paintDemo;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintDemo extends JFrame{
	public PaintDemo(){
		super("颜色渐变及纹理填充演示示例");
		setSize(250,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void paint(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		//以颜色从白到蓝周期性渐变设置绘图方式
		g2d.setPaint(new GradientPaint(20f,50f,Color.white,80f,80f,Color.blue,true));
		g2d.fill(new Rectangle2D.Double(20,50,70,70));
		//以上述方式绘制矩形
		BufferedImage texture=new BufferedImage(5,5,1);
		//创建BufferedImage对象
		Graphics2D pattern=texture.createGraphics();
		//创建一个Graphics2D对象
		pattern.setColor(Color.blue); //设置纹理图案的颜色
		pattern.fillRect(0,0,5,5);    //填充纹理图案
		pattern.setColor(Color.white);//设置纹理图案的颜色
		pattern.fillOval(0,0,5,5);    //以外接圆方式填充纹理图案
		Rectangle rect=new Rectangle(0,0,5,5);
		//创建用于定位和复制纹理的Rectangle2D对象 
		g2d.setPaint(new TexturePaint(texture,rect));
		//以指定的纹理设置绘图方式
		g2d.fill(new Rectangle2D.Double(100,50,70,70));
		//以纹理方式绘制矩形
	}	
	public static void main(String args[]){
		new PaintDemo();
	}
}
