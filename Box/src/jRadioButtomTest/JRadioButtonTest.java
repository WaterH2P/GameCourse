package jRadioButtomTest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioButtonTest {
	JFrame f=null;
	JRadioButtonTest(){
		f=new JFrame("��ѡ��ʾ��");//����һ��JFrame�Ķ���
		Container contentPane=f.getContentPane();//����һ�������������
		contentPane.setLayout(new FlowLayout());//���øô��ڵĲ���
		JPanel pl=new JPanel();//����һ��������pl
		pl.setLayout(new GridLayout(1,4));//���ò��ֹ�������ʽ
		pl.setBorder(BorderFactory.createTitledBorder("ѡ����ϲ���ĳ���"));
		//����3��JRadioButton��ѡ��ť
		JRadioButton r1=new JRadioButton("����");
		JRadioButton r2=new JRadioButton("�Ϻ�");
		JRadioButton r3=new JRadioButton("����");
		JRadioButton r4=new JRadioButton("̩��");
		pl.add(r1);
		pl.add(r2);
		pl.add(r3);
		pl.add(r4);
		r1.setSelected(true);  //���á���������ѡ��ťΪ��ѡ��
		contentPane.add(pl);   //������pl�ӵ��������������
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){//���һ�����ڼ�����
			public void windowClosing(WindowEvent e){
				System.exit(0);
				}
			});
		}
		public static void main(String args[]){
			new JRadioButtonTest();
		}
}

