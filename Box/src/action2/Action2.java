package action2;
import java.awt.Color;
import java.awt.color.*;
import javax.swing.*;
import java.awt.event.*;

public class Action2 extends JFrame{
	static JButton b1=new JButton("Red");
	static JButton b2=new JButton("Green");
	static JButton b3=new JButton("Yellow");
	static JPanel p=new JPanel();
	static JLabel l=new JLabel("�뵥������İ�ť");
	public Action2(){
		super("�����¼�");
		setBounds(10,20,300,200);
		l.setOpaque(true);                 //���ÿؼ���͸��
		l.setBounds(0,0,300,150);
		l.setHorizontalAlignment(JLabel.CENTER);//���ö��뷽ʽ
		add(l,"Center");
		p.add(b1); p.add(b2); p.add(b3);
		add(p,"South");
		b1.addActionListener(new B());
		b2.addActionListener(new B());
		b3.addActionListener(new B());
		setVisible(true);
	}
	public static void main(String args[]){
		Action2 f=new Action2();
	}
}
class B implements ActionListener{
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==Action2.b1){
			Action2.l.setText("���µ��Ǻ�ɫ");
			Action2.l.setBackground(Color.red);
		}
		if(e.getSource()==Action2.b2){
			Action2.l.setText("���µ�����ɫ");
			Action2.l.setBackground(Color.green);
		}
		if(e.getSource()==Action2.b3){
			Action2.l.setText("���µ��ǻ�ɫ");
			Action2.l.setBackground(Color.yellow);
		}
	}
}