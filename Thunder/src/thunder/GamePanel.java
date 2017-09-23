package thunder;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	/*屏幕的宽度*/
	private int mScreenWidth=320;
	private int mScreenHeight=480;
	
	/*游戏主菜单状态*/
	private static final int STATE_GAME=0;
	/*游戏状态*/
	private int mState=STATE_GAME;
	/*游戏背景资源，两张图片切换让屏幕滚动起来*/
	private Image mBitMenuBG0=null;
	private Image mBitMenuBG1=null;
	/*记录两张背景图片更新时的y坐标*/
	private int mBitposY0=0;
	private int mBitposY1=0;
	
	/*子弹对象的数量*/
	final static int BULLET_POOL_COUNT=15;
	/*飞机移动步长*/
	final static int PLAN_STEP=10;	
	/*每500ms发射一颗子弹*/
	final static int PLAN_TIME=500;
	
	/*敌人对象的数量*/
	final static int ENEMY_POOL_COUNT=5;
	/*敌人飞机偏移量*/
	final static int ENEMY_POS_OFF=65;
	
	/*游戏主线程*/
	private Thread mThread=null;
	/*线程循环标志*/
	private boolean mIsRunning =false;
	/*飞机在屏幕中的坐标*/
	public int mAirPosX=mScreenWidth/2-15;
	public int mAirPosY=mScreenHeight-30;
	
	/*敌机对象数组*/
	Enemy mEnemy[]=null;
	/*子弹对象数组*/
	Bullet mBullet[]=null;
	/*初始化发射子弹ID*/
	public int mSendId=0;
	/*上一颗子弹发射时间*/
	public Long mSendTime=0L;
	Image myPlanePic[];      /*玩家飞机的所有图片*/
	public int myPlaneID=0;  /*玩家飞机当前的帧号*/
	
	final static int BULLET_UP_OFFSET=30;
	private int count=0;
	
	public GamePanel(){
		setPreferredSize(new Dimension(mScreenWidth,mScreenHeight));
		//设定焦点在本窗口并赋予监听对象
		setFocusable(true);
		addKeyListener(this);
		init();
		setGameState(STATE_GAME);
		mIsRunning=true;
		mThread=new Thread(this);  //实例线程
		/*启动游戏线程*/
		mThread.start();
		setVisible(true);
	}
	public void run(){
		while(mIsRunning){
			/*刷新屏幕*/
			Draw();
			//延时0.1s
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	/*
	 * init()方法初始化各种对象，包括两张背景图片mBitMenuBG0和mBitMenuBG1，
	 * 通过这两张背景图片的切换实现游戏背景动态移动的效果。
	 * 初始化玩家飞机的坐标(150,400)点处。
	 * 创建5个地方飞机对象mEnemy数组，同时创建15个子弹类对象mBullet数组。
	 */
	public void init(){
		mBitMenuBG0=Toolkit.getDefaultToolkit().getImage("image\\map_0.jpg");
		mBitMenuBG1=Toolkit.getDefaultToolkit().getImage("image\\map_1.jpg");
		/*第一张图片紧贴在屏幕(0,0)点处，第二张图片在第一张图片上方*/
		mBitposY0=0;
		mBitposY1=-mScreenHeight;
		/*初始化玩家飞机相关的6张图片对象*/
		myPlanePic=new Image[6];
		for(int i=0;i<6;i++)
			myPlanePic[i]=Toolkit.getDefaultToolkit().getImage("image\\plane.png");
		/*创建敌机对象*/
		mEnemy=new Enemy[ENEMY_POOL_COUNT];
		for(int i=0;i<ENEMY_POOL_COUNT;i++){
			mEnemy[i]=new Enemy();
			mEnemy[i].init(i*ENEMY_POS_OFF, i*ENEMY_POS_OFF-300);
		}
		/*创建子弹类对象*/
		mBullet=new Bullet[BULLET_POOL_COUNT];
		for(int i=0;i<BULLET_POOL_COUNT;i++){
			mBullet[i]=new Bullet();
		}
		mSendTime=System.currentTimeMillis();
	}
	
	protected void Draw(){
		switch(mState){
		case STATE_GAME:
			renderBg();  //绘制游戏界面
			updateBg();  //更新游戏逻辑
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
		/*绘制游戏地图*/
		g.drawImage(mBitMenuBG0, 0, mBitposY0, this);
		g.drawImage(mBitMenuBG1, 0, mBitposY1, this);
		/*绘制自己的飞机动画*/
		g.drawImage(myPlanePic[myPlaneID], mAirPosX, mAirPosY, this);
		/*绘制子弹动画*/
		for(int i=0;i<BULLET_POOL_COUNT;i++)
			mBullet[i].DrawBullet(g, this);
		for(int i=0;i<ENEMY_POOL_COUNT;i++)
			mEnemy[i].DrawEnemy(g, this);
	}
	
	public void updateBg(){
		/*更新游戏背景图片实现向下滚动效果*/
		mBitposY0=mBitposY0+10;   /*第一张地图map_0的纵坐标下移10个像素*/
		mBitposY1=mBitposY1+10;   /*第一张地图map_1的纵坐标下移10个像素*/
		if(mBitposY0==mScreenHeight){   //超过游戏屏幕的底边
			mBitposY0=-mScreenHeight;   //回到屏幕上方
		}
		if(mBitposY1==mScreenHeight){
			mBitposY1=-mScreenHeight;
		}
		/*更新每发子弹的位置坐标，上移15个像素*/
		for(int i=0;i<BULLET_POOL_COUNT;i++){
			mBullet[i].UpdateBullet();
		}
		/*更新敌机位置坐标*/
		for(int i=0;i<ENEMY_POOL_COUNT;i++){
			mEnemy[i].UpdateEnemy();
			/*敌机死亡且爆炸动画结束或者敌机超过屏幕还未死亡则重置坐标*/
			if(mEnemy[i].enemyState==Enemy.ENEMY_DEATH_STATE&&
					mEnemy[i].mPlayID==6||mEnemy[i].m_posY>=mScreenHeight){
				mEnemy[i].init(UtilRandom(0,ENEMY_POOL_COUNT)*ENEMY_POS_OFF,0);
			}
		}
		/*根据时间初始化发射的子弹位置*/
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
			//子弹与敌人的碰撞检测
			Collision();
		}
	}
	
	public void Collision(){
		//子弹与敌人的碰撞检测
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
						){   //发生碰撞敌人的状态修改为死亡
				mEnemy[j].enemyState=Enemy.ENEMY_DEATH_STATE;
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





