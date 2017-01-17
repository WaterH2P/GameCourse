package thunder;
import java.awt.*;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

public class Enemy {
	/**�л���״̬**/
	public static final int ENEMY_ALIVE_STATE=0;
	public static final int ENEMY_DEATH_STATE=1;
	
	/**�л�����y����ٶ�**/
	static final int ENEMY_STEP_Y=5;
	
	/**�ͼ���(x,y)����**/
	public int m_posX=0;
	public int m_posY=0;
	public int mAnimState=ENEMY_ALIVE_STATE;
	private Image enemyExplorePic[]=new Image[6];  //�л���ըͼƬ���
	
	/**��ǰ֡��ID**/
	public int mPlayID=0;
	
	public Enemy(){
		for(int i=0;i<6;i++)
			enemyExplorePic[i]=Toolkit.getDefaultToolkit().getImage("image\\bomb_enemy_"+i+".png");
	}
	
	/*��ʼ������*/
	public void init(int x,int y){
		m_posX=x;
		m_posY=y;
		mAnimState=ENEMY_ALIVE_STATE;
		mPlayID=0;
	}
	
	/*���Ƶл�*/
	public void DrawEnemy(Graphics g,JPanel i){
		//���л�״̬Ϊ��������������������ϣ����ٻ��Ƶл�
		if(mAnimState==ENEMY_DEATH_STATE && mPlayID<6){
			g.drawImage(enemyExplorePic[mPlayID],m_posX,m_posY,(ImageObserver)i);
			mPlayID++;
		}
		//���л�״̬Ϊ���״̬
		Image pic=Toolkit.getDefaultToolkit().getImage("image\\el_0.png");
		g.drawImage(pic, m_posX, m_posY,(ImageObserver)i);
	}
	
	/*���µл�����*/
	public void UpdateEnemy(){
		m_posY=m_posY+ENEMY_STEP_Y;
	}
}





