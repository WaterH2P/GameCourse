package sprite;

import java.awt.*;
import javax.swing.JPanel;
public class SpritePanel extends JPanel implements Runnable{
	//�����߳���
	private Sprite player;
	public SpritePanel(){
		player=new Sprite();       //������ɫ����
		Thread t=new Thread(this); //����һ�����߳�
		t.start();
	}
	public void run(){
		while(true){
			player.UpdateSprite();  //���½�ɫSprite���x,y����
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){}
			repaint();
		}
	}
	public void paint(Graphics g){
		super.paint(g);             //�������ԭ���Ķ�������
		g.clearRect(0,0,this.getWidth(),this.getHeight());
		player.DrawSprite(g, this);
		
	}
}
