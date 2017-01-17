package mouse1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mouse1 extends JFrame implements MouseListener{
	JLabel l=new JLabel();
	public Mouse1(){
		super("鼠标事件");
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
		System.out.println("鼠标进入标签");
	}
	public void mousePressed(MouseEvent e){
		if(e.getButton()==1)
			System.out.println("鼠标左键被按下");
		if(e.getButton()==2)
			System.out.println("鼠标滚轮");
		if(e.getButton()==3)
			System.out.println("鼠标右键被按下");
	}
	public void mouseReleased(MouseEvent e){
		System.out.println("鼠标被释放");
	}
	public void mouseClicked(MouseEvent e){
		System.out.println("鼠标单击");
		System.out.println("鼠标单击了"+e.getClickCount()+"次");
	}
	public void mouseExited(MouseEvent e){
		System.out.println("鼠标移除了标签");
	}
}
