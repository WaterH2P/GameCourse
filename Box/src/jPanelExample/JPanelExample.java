package jPanelExample;
import javax.swing.*;
import java.awt.*;
public class JPanelExample extends JFrame{
	JButton[] buttons;
	JPanel panel1;
	CustomPanel panel2;
	public JPanelExample(){
		super("面板示例");
		Container container=getContentPane();
		container.setLayout(new BorderLayout());
		panel1=new JPanel(new FlowLayout());   //创建一个流布局管理器的面板
		buttons=new JButton[4];
		for(int i=0;i<buttons.length;i++){
			buttons[i]=new JButton("按钮"+(i+1));
			panel1.add(buttons[i]);            //添加按钮到面板panel中
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
	class CustomPanel extends JPanel{         //定义内部类CustomPanel
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawString("Welcome to Java Shape World",20,20);
			g.drawRect(20,40,130,130);
			g.setColor(Color.green);          //设置颜色为绿色
			g.fillRect(20,40,130,130);        //绘制矩形
			g.drawOval(170,40,100,130);       //绘制椭圆
			g.setColor(Color.orange);         //设置颜色为橙色
			g.fillOval(170,40,100,130);       //绘制椭圆
		}
		public Dimension getPreferredSize(){  //设置最佳尺寸
			return new Dimension(200,200);
		}
	}                                         //结束内部类的定义
}
