package thunder;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	/*��Ļ�Ŀ���*/
	private int mScreenWidth=320;
	private int mScreenHeight=480;
	/*��Ϸ���˵�״̬*/
	private static final int STATE_GAME=0;
	/*��Ϸ״̬*/
	private int mState=STATE_GAME;
	/*��Ϸ������Դ������ͼƬ�л�����Ļ��������*/
	private Image mBitMenuBG0=null;
	private Image mBitMenuBG1=null;
	/*��¼���ű���ͼƬ����ʱ��y����*/
	private int mBitposY0=0;
	private int mBitposY1=0;
	/*�ӵ����������*/
	final static int BULLET_POOL_COUNT=15;
	/*�ɻ��ƶ�����*/
	final static int PLAN_STEP=10;
	/*ÿ500ms����һ���ӵ�*/
	final static int PLAN_TIME=500;
	/*���˶��������*/
	final static int ENEMY_POOL_COUNT=5;
	/*���˷ɻ�ƫ����*/
	final static int ENEMY_POS_OFF=65;
	/*��Ϸ���߳�*/
	private Thread mThread=null;
	/*�߳�ѭ����־*/
	private boolean mIsRunning =false;
	/*�ɻ�����Ļ�е�����*/
	public int mAirPosX=mScreenWidth/2-15;
	public int mAirPosY=mScreenHeight-30;
	
	/*�л���������*/
	Enemy mEnemy[]=null;
	/*�ӵ���������*/
	Bullet mBullet[]=null;
	/*��ʼ�������ӵ�ID*/
	public int mSendId=0;
	/*��һ���ӵ�����ʱ��*/
	public Long mSendTime=0L;
	Image myPlanePic[];      /*��ҷɻ�������ͼƬ*/
	public int myPlaneID=0;  /*��ҷɻ���ǰ��֡��*/
	
	final static int BULLET_UP_OFFSET=30;
	private int count=0;
	
	public GamePanel(){
		setPreferredSize(new Dimension(mScreenWidth,mScreenHeight));
		//�趨�����ڱ����ڲ������������
		setFocusable(true);
		addKeyListener(this);
		init();
		setGameState(STATE_GAME);
		mIsRunning=true;
		mThread=new Thread(this);  //ʵ���߳�
		/*������Ϸ�߳�*/
		mThread.start();
		setVisible(true);
	}
	public void run(){
		while(mIsRunning){
			/*ˢ����Ļ*/
			Draw();
			//��ʱ0.1s
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	/*
	 * init()������ʼ�����ֶ��󣬰������ű���ͼƬmBitMenuBG0��mBitMenuBG1��
	 * ͨ�������ű���ͼƬ���л�ʵ����Ϸ������̬�ƶ���Ч����
	 * ��ʼ����ҷɻ�������(150,400)�㴦��
	 * ����5���ط��ɻ�����mEnemy���飬ͬʱ����15���ӵ������mBullet���顣
	 */
	public void init(){
		mBitMenuBG0=Toolkit.getDefaultToolkit().getImage("image\\map_0.jpg");
		mBitMenuBG1=Toolkit.getDefaultToolkit().getImage("image\\map_1.jpg");
		/*��һ��ͼƬ��������Ļ(0,0)�㴦���ڶ���ͼƬ�ڵ�һ��ͼƬ�Ϸ�*/
		mBitposY0=0;
		mBitposY1=-mScreenHeight;
		/*��ʼ����ҷɻ���ص�6��ͼƬ����*/
		myPlanePic=new Image[6];
		for(int i=0;i<6;i++)
			myPlanePic[i]=Toolkit.getDefaultToolkit().getImage("image\\plane.png");
		/*�����л�����*/
		mEnemy=new Enemy[ENEMY_POOL_COUNT];
		for(int i=0;i<ENEMY_POOL_COUNT;i++){
			mEnemy[i]=new Enemy();
			mEnemy[i].init(i*ENEMY_POS_OFF, i*ENEMY_POS_OFF-300);
		}
		/*�����ӵ������*/
		mBullet=new Bullet[BULLET_POOL_COUNT];
		for(int i=0;i<BULLET_POOL_COUNT;i++){
			mBullet[i]=new Bullet();
		}
		mSendTime=System.currentTimeMillis();
	}
	
	protected void Draw(){
		switch(mState){
		case STATE_GAME:
			renderBg();  //������Ϸ����
			updateBg();  //������Ϸ�߼�
			break;
		}
	}
	
	private void setGameState(int newState){
		mState=newState;
	}
	
	public void renderBg(){
		myPlaneID++;
		if(myPlaneID==6)
			myPlaneID=0;
		repaint();
	}
	
	public void paint(Graphics g){
		/*������Ϸ��ͼ*/
		g.drawImage(mBitMenuBG0, 0, mBitposY0, this);
		g.drawImage(mBitMenuBG1, 0, mBitposY1, this);
		/*�����Լ��ķɻ�����*/
		g.drawImage(myPlanePic[myPlaneID], mAirPosX, mAirPosY, this);
		/*�����ӵ�����*/
		for(int i=0;i<BULLET_POOL_COUNT;i++)
			mBullet[i].DrawBullet(g, this);
		for(int i=0;i<ENEMY_POOL_COUNT;i++)
			mEnemy[i].DrawEnemy(g, this);
	}
	
	public void updateBg(){
		/*������Ϸ����ͼƬʵ�����¹���Ч��*/
		mBitposY0=mBitposY0+10;   /*��һ�ŵ�ͼmap_0������������10������*/
		mBitposY1=mBitposY1+10;   /*��һ�ŵ�ͼmap_1������������10������*/
		if(mBitposY0==mScreenHeight){   //������Ϸ��Ļ�ĵױ�
			mBitposY0=-mScreenHeight;   //�ص���Ļ�Ϸ�
		}
		if(mBitposY1==mScreenHeight){
			mBitposY1=-mScreenHeight;
		}
		/*����ÿ���ӵ���λ�����꣬����15������*/
		for(int i=0;i<BULLET_POOL_COUNT;i++){
			mBullet[i].UpdateBullet();
		}
		/*���µл�λ������*/
		for(int i=0;i<ENEMY_POOL_COUNT;i++){
			mEnemy[i].UpdateEnemy();
			/*�л������ұ�ը�����������ߵл�������Ļ��δ��������������*/
			if(mEnemy[i].mAnimState==Enemy.ENEMY_DEATH_STATE&&
					mEnemy[i].mPlayID==6||mEnemy[i].m_posY>=mScreenHeight){
				mEnemy[i].init(UtilRandom(0,ENEMY_POOL_COUNT)*ENEMY_POS_OFF,0);
			}
		}
		/*����ʱ���ʼ��������ӵ�λ��*/
		if(mSendId<BULLET_POOL_COUNT){
			long now=System.currentTimeMillis();
			if(now-mSendTime>=PLAN_TIME){
				mBullet[mSendId].init(mAirPosX,mAirPosY-BULLET_UP_OFFSET);
				mSendTime=now;
				mSendId++;
			}
			else{
				mSendId=0;
			}
			//�ӵ�����˵���ײ���
			Collision();
		}
	}
	
	public void Collision(){
		//�ӵ�����˵���ײ���
		for(int i=0;i<BULLET_POOL_COUNT;i++){
			for(int j=0;j<ENEMY_POOL_COUNT;j++){
				if(( (mBullet[i].m_posX>=mEnemy[j].m_posX
						&&mBullet[i].m_posX<=mEnemy[j].m_posX+30)
						||((mBullet[i].m_posX>=mEnemy[j].m_posX-30)
						&&(mBullet[i].m_posX<=mEnemy[j].m_posX)) )
						&&
						((mBullet[i].m_posY<=mEnemy[j].m_posY
						&&mBullet[i].m_posY>=mEnemy[j].m_posY-60)
						||(mBullet[i].m_posY<=mEnemy[j].m_posY+60
						&&mBullet[i].m_posY>=mEnemy[j].m_posY))
						){   //������ײ���˵�״̬�޸�Ϊ����
				mEnemy[j].mAnimState=Enemy.ENEMY_DEATH_STATE;
				}
			}
		}
	}
	
	public int UtilRandom(int botton,int top){
		return ((Math.abs(new Random().nextInt())%(top-botton))+botton);
	}
	
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_UP){
			mAirPosY=mAirPosY-PLAN_STEP;
			if(mAirPosY<0)
				mAirPosY=0;
		}
		if(key==KeyEvent.VK_DOWN){
			mAirPosY=mAirPosY+PLAN_STEP;
			if(mAirPosY>mScreenHeight-30)
				mAirPosY=mScreenHeight-30;
		}
		if(key==KeyEvent.VK_LEFT){
			mAirPosX=mAirPosX-PLAN_STEP;
			if(mAirPosX<0)
				mAirPosX=0;
		}
		if(key==KeyEvent.VK_RIGHT){
			mAirPosX=mAirPosX+PLAN_STEP;
			if(mAirPosX>mScreenWidth-30)
				mAirPosX=mScreenWidth-30;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}




