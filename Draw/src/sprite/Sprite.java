package sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

public class Sprite {
	public int m_xpos=0, m_ypos=0;
	private Image pic[]=null;       //Sprite���ͼƬ����
	/**��ǰ֡��ID**/
	private int mPlayID=0;
	/**�Ƿ���»���Sprite**/
	boolean mFacus=true;
	public Sprite(){
		pic=new Image[4];
		for(int i=0;i<4;i++)
			pic[i]=Toolkit.getDefaultToolkit().getImage(
					"Image\\d"+i+".png");
	}
	/**��ʼ������**/
	public void init(int x,int y){
		m_xpos=x;
		m_ypos=y;
	}
	/**��������**/
	public void set(int x, int y){
		m_xpos=x;
		m_ypos=y;
	}
	/**���ƾ���**/
	public void DrawSprite(Graphics g,JPanel i){
		g.drawImage(pic[mPlayID],m_xpos,m_ypos,(ImageObserver)i);
		mPlayID++;               //��һ֡ͼ��
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
