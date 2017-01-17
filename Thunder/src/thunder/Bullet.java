package thunder;
import java.awt.*;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

public class Bullet {
	/**�ӵ���x���ٶ�**/
	static final int BULLET_STEP_X=3;
	/**�ӵ���y���ٶ�**/
	static final int BULLET_STEP_Y=35;
	/**�ӵ�ͼƬ�Ŀ��**/
	static final int BULLET_WIDEH=30;
	/**�ӵ�ͼƬ�ĸ߶�**/
	static final int BULLET_HEIGHT=30;
	/**�ӵ���(x,y)����**/
	public int m_posX=0;
	public int m_posY=-20;             //��ʼʱ�ӵ�����Ļ��
	/**�Ƿ���»����ӵ�**/
	boolean mFacus=true;
	private Image pic[]=null;          //�ӵ�ͼƬ��
	/**��ǰ֡��ID**/
	private int mPlayID=0;
	public Bullet(){
		pic=new Image[4];
		for(int i=0;i<4;i++){
			pic[i]=Toolkit.getDefaultToolkit().getImage("image\\bullet_"+i+".png");
		}
	}
	/**��ʼ������**/
	public void init(int x,int y){
		m_posX=x;
		m_posY=y;
		mFacus=true;
	}
	/**�����ӵ�**/
	public void DrawBullet(Graphics g,JPanel i){
		g.drawImage(pic[mPlayID++],m_posX,m_posY,(ImageObserver)i);
		if(mPlayID==4)
			mPlayID=0;
	}
	/**�����ӵ��������**/
	public void UpdateBullet(){
		if(mFacus)
			m_posY-=BULLET_STEP_Y;
	}
}



