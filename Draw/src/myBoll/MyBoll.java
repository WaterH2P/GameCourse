package myBoll;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyBoll extends JFrame{
	MyBoll(){
		//���ô��ڱ���
		this.setTitle("Boll is falling");
		Container c=this.getContentPane();//��ȡ�������
		c.add(new TetrisPanel());
		//���ô��ڿ�ʼ��ʾʱ������Ļ���400�����ص�
		//������Ļ�ϱ�200�����ص�
		//���ڿ�300�����ص㣬���ڸ�300�����ص�
		this.setBounds(400,200,300,300);
		//���ô��ڹرհ�ť���йر���������Ĺ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);  //���ô��ڴ�С����ı�
		this.setVisible(true);     //��ʾ�ô���
	}
	public static void main(String args[]){
		//�����ô��ڵ�ʵ��DB����ʼ��������
		MyBoll DB=new MyBoll();    //��������Ķ���
		DB.addWindowFocusListener(new WindowAdapter(){
			//��Ӵ��ڹرմ�����
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});		
	}
}
