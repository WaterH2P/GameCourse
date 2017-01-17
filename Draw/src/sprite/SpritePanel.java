package sprite;

import java.awt.*;
import javax.swing.JPanel;
public class SpritePanel extends JPanel implements Runnable{
	//绘制线程类
	private Sprite player;
	public SpritePanel(){
		player=new Sprite();       //创建角色精灵
		Thread t=new Thread(this); //创建一个新线程
		t.start();
	}
	public void run(){
		while(true){
			player.UpdateSprite();  //更新角色Sprite类的x,y坐标
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){}
			repaint();
		}
	}
	public void paint(Graphics g){
		super.paint(g);             //将面板上原来的东西擦掉
		g.clearRect(0,0,this.getWidth(),this.getHeight());
		player.DrawSprite(g, this);
		
	}
}
