package drawImageDemo;
import java.awt.*;
import javax.swing.*;

public class DrawNine {
	public static void main(String args[]){
		DrawFrame frame=new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class DrawFrame extends JFrame{
	public DrawFrame(){
		setTitle("九宫格");
		setSize(420,450);
		DrawPanel panel=new DrawPanel();
		Container contentPane=getContentPane();
		contentPane.add(panel);
	}
}
class DrawPanel extends JPanel{
	public void paint(Graphics g){
		int x1=50, y1=50; 
		Polygon p=new Polygon();
		p.addPoint(x1,y1);
		p.addPoint(x1+300,y1);
		p.addPoint(x1+300,y1+300);
		p.addPoint(x1,y1+300);
		g.drawPolygon(p);          //绘制外面的大正方形
		
		g.drawLine(x1,y1+100,x1+300,y1+100);
		g.drawLine(x1,y1+200,x1+300,y1+200);
		g.drawLine(x1+100,y1,x1+100,y1+300);
		g.drawLine(x1+200,y1,x1+200,y1+300);
	}
}
