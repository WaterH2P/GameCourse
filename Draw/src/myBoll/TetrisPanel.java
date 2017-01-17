package myBoll;
import java.awt.*;
import javax.swing.JPanel;
public class TetrisPanel extends JPanel implements Runnable{
	//绘图线程类
	public int ypos=-80; //小球左上角的纵坐标
	public int xpos=-80;
	public int xpos2=380;
	//在类中添加如下两个私有成员
	private Image iBuffer;
	private Graphics gBuffer;
	public TetrisPanel(){
		//创建一个新线程
		Thread t=new Thread(this);
		//启动线程
		t.start();
	}
	public void run()          //重载run()方法
	{
		while(true){           //线程无限循环
			try{
				Thread.sleep(30);  //线程休眠30ms
			}catch(InterruptedException e){}
			ypos+=5;               //修改小球左上角的纵坐标
			xpos+=5;
			xpos2-=5;
			if(ypos>300)           //小球离开窗口后重设左上角的纵坐标
				ypos=-80;
			if(xpos>300)
				xpos=-80;
			if(xpos2<0)
				xpos2=380;
			repaint();             //窗口重绘
		}
	}
	public void paint(Graphics g)  //重载绘图方法
	{
		super.paint(g);            //将面板上原来画的东西擦掉
		                           //先清屏幕，否则原来画的东西仍在
		g.clearRect(0,0,this.getWidth(),this.getHeight());
		g.setColor(Color.RED);     //设置小球颜色
		g.fillOval(xpos,ypos,80,80); //绘制小球
		g.setColor(Color.YELLOW);
		g.fillOval(xpos-100,ypos,80,80);
		g.setColor(Color.BLUE);
		g.fillOval(xpos,ypos+100,80,80);
		g.setColor(Color.orange);
		g.fillOval(xpos-100,ypos+100,80,80);
		g.setColor(Color.RED);     
		g.fillOval(xpos2-100,ypos,80,80); 
		g.setColor(Color.YELLOW);
		g.fillOval(xpos2,ypos,80,80);
		g.setColor(Color.BLUE);
		g.fillOval(xpos2-100,ypos+100,80,80);
		g.setColor(Color.orange);
		g.fillOval(xpos2,ypos+100,80,80);
	}
}
