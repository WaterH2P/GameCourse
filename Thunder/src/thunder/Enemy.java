package thunder;
import java.awt.*;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;

import javax.swing.JPanel;

public class Enemy {
	/**敌机的状态**/
	public static final int ENEMY_ALIVE_STATE = 0;
	public static final int ENEMY_DEATH_STATE = 1;
	
	/**敌机行走y轴的速度**/
	static final int ENEMY_STEP_Y = 5;
	
	/**敌机的(x,y)坐标**/
	public int m_posX = 0;
	public int m_posY = 0;
	public int enemyState = ENEMY_ALIVE_STATE;
	private Image enemyExplorePic[] = new Image[6];  //敌机爆炸图片组合
	
	/**当前帧的ID**/
	public int mPlayID = 0;
	
	public Enemy(){
		for(int i=0;i<6;i++)
			enemyExplorePic[i] = Toolkit.getDefaultToolkit().getImage("image\\bomb_enemy_"+i+".png");
	}
	
	/*初始化坐标*/
	public void init(int x,int y){
		m_posX = x;
		m_posY = y;
		enemyState = ENEMY_ALIVE_STATE;
		mPlayID = 0;
	}
	
	/*绘制敌机*/
	public void DrawEnemy(Graphics g, JPanel jpanel){
		//当敌机状态为死亡且死亡动画播放完毕，则不再绘制敌机
		if(enemyState==ENEMY_DEATH_STATE && mPlayID<6){
			g.drawImage(enemyExplorePic[mPlayID], m_posX, m_posY, (ImageObserver)jpanel);
			mPlayID++;
		}
		//当敌机状态为存活状态
		Image pic = Toolkit.getDefaultToolkit().getImage("image\\el_1.png");
		int iw = pic.getWidth((ImageObserver)jpanel);
		int ih = pic.getHeight((ImageObserver)jpanel);
		int pixels[] = new int[iw*ih];
		ColorModel cm = ColorModel.getRGBdefault();
		Color deleteColor = Color.white;
		for(int i=0;i<iw*ih;i++){
			int red,green,blue;
			red = cm.getRed(pixels[i]);
			green = cm.getGreen(pixels[i]);
			blue = cm.getBlue(pixels[i]);
			int rgb = cm.getRGB(pixels[i]);
			if(deleteColor.getRGB() == rgb){
				pixels[i]= red<<16|green<<8|blue;
			}
		}
		//将数组中的象素产生一个图像
		ImageProducer ip=new MemoryImageSource(iw,ih,pixels,0,iw);
		pic = Toolkit.getDefaultToolkit().createImage(ip);
		
		//根据处理完的像素创建图像。
		
		
		g.drawImage(pic, m_posX, m_posY,(ImageObserver)jpanel);
	}
	
	/*更新敌机坐标*/
	public void UpdateEnemy(){
		m_posY = m_posY + ENEMY_STEP_Y;
	}
}






