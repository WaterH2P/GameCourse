package sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

public class Sprite {
	public int m_xpos=0, m_ypos=0;
	private Image pic[]=null;       //Sprite类的图片数组
	/**当前帧的ID**/
	private int mPlayID=0;
	/**是否更新绘制Sprite**/
	boolean mFacus=true;
	public Sprite(){
		pic=new Image[4];
		for(int i=0;i<4;i++)
			pic[i]=Toolkit.getDefaultToolkit().getImage(
					"Image\\d"+i+".png");
	}
	/**初始化坐标**/
	public void init(int x,int y){
		m_xpos=x;
		m_ypos=y;
	}
	/**设置坐标**/
	public void set(int x, int y){
		m_xpos=x;
		m_ypos=y;
	}
	/**绘制精灵**/
	public void DrawSprite(Graphics g,JPanel i){
		g.drawImage(pic[mPlayID],m_xpos,m_ypos,(ImageObserver)i);
		mPlayID++;               //下一帧图像
		if(mPlayID==4)
			mPlayID=0;
		g.drawOval(m_xpos, m_ypos+80, 30, 30);
		g.setColor(Color.RED);
		g.fillOval(m_xpos, m_ypos+80, 30, 30);
	}
	public void UpdateSprite(){
		if(mFacus==true)
			m_xpos+=15;
		if(m_xpos==300)
			m_xpos=0;
	}
}
