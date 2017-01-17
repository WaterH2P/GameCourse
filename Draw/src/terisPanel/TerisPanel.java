package terisPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
public class TerisPanel extends JPanel implements Runnable,KeyListener{
	public int ypos=-80, xpos=110; //小球左上角坐标
	public TerisPanel(){
		Thread t=new Thread(this); //创建新线程
		t.start();                 //启动线程
		//设定焦点在本面板并作为监听对象
		setFocusable(true);
		addKeyListener(this);
	}
	public void run(){              //重载run()方法
		while(true){                //线程无限循环
			try{
				Thread.sleep(30);   //线程休眠30ms
			}catch(InterruptedException e){}
			ypos+=5;                //修改小球左上角的纵坐标
			if(ypos>300)
				ypos=-80;
			if(xpos<-80)
				xpos=380;
			if(xpos>380)
				xpos=-80;
			repaint();              //窗口重绘
		}		
	}
	public void paint(Graphics g){  //重载绘图方法
		super.paint(g);             //将面板上原来的东西擦掉
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.RED);
		g.fillOval(xpos, ypos, 80, 80);//绘制小球
		}
	public void keyPressed(KeyEvent e){
		int keyCode=e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_LEFT:
			xpos-=10;
			break;
		case KeyEvent.VK_RIGHT:
			xpos+=10;
			break;
		}
		repaint();
	}
	public void keyReleased(KeyEvent arg0){
	}
	public void keyTyped(KeyEvent arg0){
	}
}
