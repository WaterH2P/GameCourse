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
	static JLabel l=new JLabel("请单击下面的按钮");
	public Action2(){
		super("动作事件");
		setBounds(10,20,300,200);
		l.setOpaque(true);                 //设置控件不透明
		l.setBounds(0,0,300,150);
		l.setHorizontalAlignment(JLabel.CENTER);//设置对齐方式
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
			Action2.l.setText("按下的是红色");
			Action2.l.setBackground(Color.red);
		}
		if(e.getSource()==Action2.b2){
			Action2.l.setText("按下的是绿色");
			Action2.l.setBackground(Color.green);
		}
		if(e.getSource()==Action2.b3){
			Action2.l.setText("按下的是黄色");
			Action2.l.setBackground(Color.yellow);
		}
	}
}