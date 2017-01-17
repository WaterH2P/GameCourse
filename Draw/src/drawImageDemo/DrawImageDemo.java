package drawImageDemo;
//�ڿ���л���ֱ��/���κ���Բ
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
		//����ֱ�ߣ� ���ľ��κͿ�����Բ
		g.setColor(Color.red);
		g.drawRect(30,50,getWidth()/2-50,getHeight()/2-50);
		g.drawOval(30,50,getWidth()/2-50,getHeight()/2-50);
		g.drawLine(30,50,30+getWidth()/2-50,50+getHeight()/2-50);
		
		//�������ɫλ����ɫ��3D���Σ�Բ�Ǿ��κ���Բ
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
