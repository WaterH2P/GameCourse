package jPanelExample;
import javax.swing.*;
import java.awt.*;
public class JPanelExample extends JFrame{
	JButton[] buttons;
	JPanel panel1;
	CustomPanel panel2;
	public JPanelExample(){
		super("���ʾ��");
		Container container=getContentPane();
		container.setLayout(new BorderLayout());
		panel1=new JPanel(new FlowLayout());   //����һ�������ֹ����������
		buttons=new JButton[4];
		for(int i=0;i<buttons.length;i++){
			buttons[i]=new JButton("��ť"+(i+1));
			panel1.add(buttons[i]);            //��Ӱ�ť�����panel��
		}
		panel2=new CustomPanel();
		container.add(panel1, BorderLayout.NORTH);
		container.add(panel2, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	public static void main(String args[]){
		JPanelExample jpe=new JPanelExample();
		jpe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class CustomPanel extends JPanel{         //�����ڲ���CustomPanel
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawString("Welcome to Java Shape World",20,20);
			g.drawRect(20,40,130,130);
			g.setColor(Color.green);          //������ɫΪ��ɫ
			g.fillRect(20,40,130,130);        //���ƾ���
			g.drawOval(170,40,100,130);       //������Բ
			g.setColor(Color.orange);         //������ɫΪ��ɫ
			g.fillOval(170,40,100,130);       //������Բ
		}
		public Dimension getPreferredSize(){  //������ѳߴ�
			return new Dimension(200,200);
		}
	}                                         //�����ڲ���Ķ���
}
