package mouse1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mouse1 extends JFrame implements MouseListener{
	JLabel l=new JLabel();
	public Mouse1(){
		super("����¼�");
		setBounds(10,10,400,400);
		setLayout(null);
		l.setOpaque(true);
		l.setBackground(Color.ORANGE);
		l.setBounds(30,30,200,150);
		add(l);
		l.addMouseListener(this);
		setVisible(true);
	}
	public static void main(String args[]){
		Mouse1 f=new Mouse1();
	}
	public void mouseEntered(MouseEvent e){
		System.out.println("�������ǩ");
	}
	public void mousePressed(MouseEvent e){
		if(e.getButton()==1)
			System.out.println("������������");
		if(e.getButton()==2)
			System.out.println("������");
		if(e.getButton()==3)
			System.out.println("����Ҽ�������");
	}
	public void mouseReleased(MouseEvent e){
		System.out.println("��걻�ͷ�");
	}
	public void mouseClicked(MouseEvent e){
		System.out.println("��굥��");
		System.out.println("��굥����"+e.getClickCount()+"��");
	}
	public void mouseExited(MouseEvent e){
		System.out.println("����Ƴ��˱�ǩ");
	}
}
