package simpleDraw;
import java.awt.*;
import javax.swing.*;
public class SimpleDraw {
	public static void main(String args[]){
		DrawFrame frame=new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class DrawFrame extends JFrame{
	public DrawFrame(){
		setTitle("简单图形绘制");
		setSize(300,300);
		DrawPanel panel=new DrawPanel();
		Container contentPane=getContentPane();
		contentPane.add(panel);
	}
class DrawPanel extends JPanel{
	public void paint(Graphics g){
		int x1=50,y1=50,x2=50,y2=150;
		int radius=100;        //半径
		int startAngle=-90;    //起始角度
		int arcAngle=180;      //弧的角度
		g.drawLine(x1,y1,x2,y2);  //画线
		g.drawArc(x1-radius/2,y1,radius,radius,startAngle, arcAngle);
		Polygon p=new Polygon();
		x1=x1+150; y1=y1+150; radius=radius/2;
		for(int i=0;i<6;i++){
			p.addPoint((int)(x1+radius*Math.cos(i*2*Math.PI/6)),
					(int)(y1+radius*Math.sin(i*2*Math.PI/6)));
			}
		g.drawPolygon(p);     //画六边形
	}
}
}
	

