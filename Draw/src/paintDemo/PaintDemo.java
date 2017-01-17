package paintDemo;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintDemo extends JFrame{
	public PaintDemo(){
		super("��ɫ���估���������ʾʾ��");
		setSize(250,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void paint(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		//����ɫ�Ӱ׵��������Խ������û�ͼ��ʽ
		g2d.setPaint(new GradientPaint(20f,50f,Color.white,80f,80f,Color.blue,true));
		g2d.fill(new Rectangle2D.Double(20,50,70,70));
		//��������ʽ���ƾ���
		BufferedImage texture=new BufferedImage(5,5,1);
		//����BufferedImage����
		Graphics2D pattern=texture.createGraphics();
		//����һ��Graphics2D����
		pattern.setColor(Color.blue); //��������ͼ������ɫ
		pattern.fillRect(0,0,5,5);    //�������ͼ��
		pattern.setColor(Color.white);//��������ͼ������ɫ
		pattern.fillOval(0,0,5,5);    //�����Բ��ʽ�������ͼ��
		Rectangle rect=new Rectangle(0,0,5,5);
		//�������ڶ�λ�͸��������Rectangle2D���� 
		g2d.setPaint(new TexturePaint(texture,rect));
		//��ָ�����������û�ͼ��ʽ
		g2d.fill(new Rectangle2D.Double(100,50,70,70));
		//������ʽ���ƾ���
	}	
	public static void main(String args[]){
		new PaintDemo();
	}
}
