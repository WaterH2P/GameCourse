package gridLayoutExample;
import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame{
	JButton buttons[];
	GridLayout layout;
	public void init(){
		this.setTitle("���񲼾ֹ�����ʾ��");
		layout=new GridLayout(4,3,50,10);
		setLayout(layout);                 //����4��3�е����񲼾�
		buttons=new JButton[12];
		for(int i=0;i<12;i++){
			buttons[i]=new JButton("��ť"+(i+1));
			add(buttons[i]);
	}
	}
	public static void main(String args[]){
		GridLayoutExample gle=new GridLayoutExample();
		gle.init();
		gle.pack();
		gle.setVisible(true);
		gle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
