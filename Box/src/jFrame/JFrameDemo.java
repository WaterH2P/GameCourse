package jFrame;
/*
 * ����JFrameʵ�ֵĴ��ڽ���
 */
import javax.swing.*;
import java.awt.*;
public class JFrameDemo {
	JFrame f;
	JButton b;
	Container c;
	public JFrameDemo(){
		f=new JFrame("JFrame Demo");
		b=new JButton("Press me");
		c=f.getContentPane();//��ȡ�����������
		c.add(b);            //Ϊ�����������������
		f.setSize(200,200);
		f.setVisible(true);
	}
	public static void main(String args[]){
		new JFrameDemo();
	}
}
