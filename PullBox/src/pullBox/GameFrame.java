package pullBox;
//右键单击——悔棋功能
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/***
 * 记载地图行列数的变量可以删去
 */

public class GameFrame extends JFrame implements ActionListener, MouseListener, KeyListener{
	//主面板类
	private int grade=0;
	//row,column记载人的行号、列号
	//leftX,leftY记载左上角图片的位置，避免图片从(0,0)坐标开始
	private int row=7, column=7, leftX=0, leftY=0;
	//记载地图的行列数
	private int mapRow=0, mapColumn=0;
	//width,height记载屏幕的大小
	private int width=0;
	private boolean acceptKey=true;
	//程序用到的图片
	private Image pic[]=null;
	private byte map[][]=null;
	private ArrayList list=new ArrayList();
	Sound sound;
	final byte Wall=1, Box=2, BoxOnEnd=3, End=4, ManDown=5, ManLeft=6, ManRight=7, ManUp=8,
			Road=9, ManDownOnEnd=10, ManLeftOnEnd=11, ManRightOnEnd=12, ManUpOnEnd=13;
/*在构造方法GrameFrame()中，调用initMap()方法来初始化本关grade游戏地图，
 * 清空悔棋信息列表list，同时播放MIDI背景音乐。
 */
	public GameFrame(){
		super("Pull Box");
		setSize(600,550);
		setVisible(true);
		setResizable(false);
		setLocation(400,70);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont=getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.black);
		//最初13张照片
		getPic();
		width=this.getWidth();
		this.setFocusable(true);
		//初始化本关grade游戏地图，清空悔棋信息列表list
		initMap();
		this.addKeyListener(this);
		this.addMouseListener(this);
	//	sound=new Sound();
	//	sound.loadSound();
		//播放MIDI背景音乐
	}
/*initMap()方法的作用是初始化本关grade游戏地图，清空悔棋信息列表list。
 * 调用getMapSizeAndPosition()方法获取游戏区域大小及显示游戏的左上角位置(leftX,leftY)。
 */
	public void initMap(){
		map=MapFactory.getMap(grade);
		list.clear();
		getMapSizeAndPosition();
		getManPosition();
	}
//getManPosition()方法的作用是获取工人的当前位置(row,column)。
	public void getManPosition(){
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				if(map[i][j]==ManDown||map[i][j]==ManLeft||map[i][j]==ManRight||map[i][j]==ManUp
						||map[i][j]==ManDownOnEnd||map[i][j]==ManLeftOnEnd
						||map[i][j]==ManRightOnEnd||map[i][j]==ManUpOnEnd){
					row=i;
					column=j;
					break;
				}
			}
		}
	}
//getManPositionzeAndPosition()方法用来获取游戏区域大小及显示游戏的左上角位置(leftX,leftY)。
	private void getMapSizeAndPosition(){
		//TODO Auto-generated method stub
		mapRow=map.length;
		mapColumn=map[0].length;
		leftX=(width-map[0].length*30)/2;
		leftY=(width-map.length*30)/2;
		System.out.println(leftX);
		System.out.println(leftY);
		System.out.println(mapRow);
		System.out.println(mapColumn);
	}
//getPic()方法用来加载要现实的图片
	public void getPic(){
		pic=new Image[14];
		for(int i=0;i<=13;i++){
			pic[i]=Toolkit.getDefaultToolkit().getImage("image//box_"+i+".jpg");
		}
	}
//grassOrEnd(byte man)方法用来判断人所在的位置是通道还是目的地。
	public byte roadOrEnd(byte man){
			byte result=Road;
			if(man==ManDownOnEnd||man==ManLeftOnEnd||man==ManRightOnEnd||man==ManUpOnEnd)
				result=End;
			return result;
	}
//向上走
	private void moveUp(){
		//上一位p1为Wall
		if(map[row-1][column]==Wall)
			return;
		//上一位p1位Box或BoxOnEnd，需考虑p2
		if(map[row-1][column]==Box||map[row-1][column]==BoxOnEnd){
			if(map[row-2][column]==End||map[row-2][column]==Road){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte boxTemp=map[row-2][column]==End?BoxOnEnd:Box;
				byte manTemp=map[row-1][column]==Box?ManUp:ManUpOnEnd;
				//箱子变成temp，箱子往前一步
				map[row-2][column]=boxTemp;
				//人变成manUp，往上走一步
				map[row-1][column]=manTemp;
				//将人刚才站的地方变成Road或者End
				map[row][column]=roadOrEnd(map[row][column]);
				//人离开后修改人的坐标
				row--;
			}
		}
		else{
			//上一位位Road或者End，无需考虑p2。
			if(map[row-1][column]==Road||map[row-1][column]==End){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte temp=map[row-1][column]==End?ManUpOnEnd:ManUp;
				//人变成temp，往上走一步
				map[row-1][column]=temp;
				//人刚才站的地方变成Road或者End
				map[row][column]=roadOrEnd(map[row][column]);
				//人离开后修改人的坐标
				row--;
			}
		}
	}
//向下走
	private void moveDown(){
		//下一位p1为Wall
		if(map[row+1][column]==Wall)
			return;
		//下一位p1位Box或BoxOnEnd，需考虑p2
		if(map[row+1][column]==Box||map[row+1][column]==BoxOnEnd){
			if(map[row+2][column]==End||map[row+2][column]==Road){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte boxTemp=map[row+2][column]==End?BoxOnEnd:Box;
				byte manTemp=map[row+1][column]==Box?ManDown:ManDownOnEnd;
				//箱子变成temp，箱子往后一步
				map[row+2][column]=boxTemp;
				//人变成manUp，往下走一步
				map[row+1][column]=manTemp;
				//将人刚才站的地方变成Road或者End
				map[row][column]=roadOrEnd(map[row][column]);
				//人离开后修改人的坐标
				row++;
			}
		}
		else{
			//下一位位Road或者End，无需考虑p2。
			if(map[row+1][column]==Road||map[row+1][column]==End){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte temp=map[row+1][column]==End?ManDownOnEnd:ManDown;
				//人变成temp，往下走一步
				map[row+1][column]=temp;
				//人刚才站的地方变成Road或者End
				map[row][column]=roadOrEnd(map[row][column]);
				//人离开后修改人的坐标
				row++;
			}
		}
	}
//向左走
	private void moveLeft(){
		//左一位p1为Wall
		if(map[row][column-1]==Wall)
			return;
		//左一位p1位Box或BoxOnEnd，需考虑p2
		if(map[row][column-1]==Box||map[row][column-1]==BoxOnEnd){
			if(map[row][column-2]==End||map[row][column-2]==Road){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte boxTemp=map[row][column-2]==End?BoxOnEnd:Box;
				byte manTemp=map[row][column-1]==Box?ManLeft:ManLeftOnEnd;
				//箱子变成temp，箱子往左一步
				map[row][column-2]=boxTemp;
				//人变成manUp，往左走一步
				map[row][column-1]=manTemp;
				//将人刚才站的地方变成Road或者End
				map[row][column]=roadOrEnd(map[row][column]);
				//人离开后修改人的坐标
				column--;
			}
		}
		else{
			//左一位位Road或者End，无需考虑p2。
			if(map[row][column-1]==Road||map[row][column-1]==End){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte temp=map[row][column-1]==End?ManLeftOnEnd:ManLeft;
				//人变成temp，往左走一步
				map[row][column-1]=temp;
				//人刚才站的地方变成Road或者End
				map[row][column]=roadOrEnd(map[row][column]);
				//人离开后修改人的坐标
				column--;
			}
		}
	}
//向右走
	private void moveRight(){
		//下一位p1为Wall
		if(map[row][column+1]==Wall)
			return;
		//下一位p1位Box或BoxOnEnd，需考虑p2
		if(map[row][column+1]==Box||map[row][column+1]==BoxOnEnd){
			if(map[row][column+2]==End||map[row][column+2]==Road){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte boxTemp=map[row][column+2]==End?BoxOnEnd:Box;
				byte manTemp=map[row][column+1]==Box?ManRight:ManRightOnEnd;
				//箱子变成temp，箱子往后一步
				map[row][column+2]=boxTemp;
				//人变成manUp，往下走一步
				map[row][column+1]=manTemp;
				//将人刚才站的地方变成Road或者End
				map[row][column]=roadOrEnd(map[row][column]);
				//人离开后修改人的坐标
				column++;
			}
		}
		else{
			//下一位位Road或者End，无需考虑p2。
			if(map[row][column+1]==Road||map[row][column+1]==End){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte temp=map[row][column+1]==End?ManRightOnEnd:ManRight;
				//人变成temp，往下走一步
				map[row][column+1]=temp;
				//人刚才站的地方变成Road或者End
				map[row][column]=roadOrEnd(map[row][column]);
				//人离开后修改人的坐标
				column++;
			}
		}
	}
	//isFinishen()方法验证玩家是否通关。如果有目的地End或人在目的地则没有成功。
	public boolean isFinished(){
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				if(map[i][j]==End||map[i][j]==ManUpOnEnd||map[i][j]==ManLeftOnEnd
						||map[i][j]==ManRightOnEnd||map[i][j]==ManDownOnEnd)
					return false;
			}
		}
		return true;
	}
	//paint(Graphics g)方法绘制整个游戏区域的图形
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				//画出地图，i代表行数，j代表列数
				if(map[i][j]!=0)
					g.drawImage(pic[map[i][j]],leftX+j*30,leftY+i*30,this);
			}
		}
		g.setColor(Color.red);
		g.setFont(new Font("楷体_2312",Font.BOLD,30));
		g.drawString("现在是第",150,140);
		g.drawString(String.valueOf(grade+1),310,140);
		g.drawString("关",360,140);
	}
	//getManX()、getManY()方法返回人的位置
	public int getManX(){
		return row;
	}
	public int getManY(){
		return column;
	}
	//getGrade()方法返回当前关卡数
	public int getGrade(){
		return grade;
	}
	//getMap(int grade)方法返回当前关卡的地图信息
	public byte[][] getMap(int grade){
		return MapFactory.getMap(grade);
	}
	//DisplayToast(String str)方法用来显示提示信息对话框
	/*显示提示信息对话框*/
	public void DisplayToast(String str){
		JOptionPane.showMessageDialog(null,str,"提示",JOptionPane.ERROR_MESSAGE);
	}
	//undo()方法的作用是撤销移动操作
	public void undo(){
		if(acceptKey){
			//撤销
			if(list.size()>0){
				//如果撤销则必须走过
				Map priorMap=(Map)list.get(list.size()-1);
				map=priorMap.getMap();
				row=priorMap.getManX();
				column=priorMap.getManY();
				repaint();
				list.remove(list.size()-1);
			}
			else
				DisplayToast("不能再撤销!");
		}
		else
			DisplayToast("此关已完成，不能撤销!");
	}
	//nextGrade()方法实现下一关初始化，并调用repaint()方法显示游戏界面
	public void nextGrade(){
		if(grade>=MapFactory.getCount()-1){
			DisplayToast("     恭喜你完成所有关卡!");
			acceptKey=false;
		}
		else{
			grade++;
			initMap();
			repaint();
			acceptKey=true;
		}
	}
	//priorGrade()方法实现上一关初始化并调用repaint()方法显示游戏界面。
	public void priorGrade(){
		grade--;
		acceptKey=true;
		if(grade<0)
			grade=0;
		initMap();
		repaint();
	}
	//键盘相关事件如下。窗体的kayPressed按键事件中根据用户的按键消息，分别调用4个方向移动的方法。
	public void keyPressed(KeyEvent e){//键盘事件
		if(e.getKeyCode()==KeyEvent.VK_UP){
			moveUp();
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			moveDown();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			moveLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			moveRight();
		}
		repaint();
		if(isFinished()){
			//禁用按键
			acceptKey=false;
			if(grade==10){
				JOptionPane.showMessageDialog(this,"恭喜通过最后一关");
			}
			else{
				//提示进入下一关
				String msg="     恭喜您通过第"+grade+"关!!!\n     是否要进入下一关?";
				int type=JOptionPane.YES_NO_OPTION;
				String title="过关";
				int choice=0;
				choice=JOptionPane.showConfirmDialog(null,msg,title,type);
				if(choice==1){
					acceptKey=true;
					grade--;
					nextGrade();
				}
				else if(choice==0){
					//进入下一关
					acceptKey=true;
					nextGrade();
				}
			}
		}
	}
	public void actionPerformed(ActionEvent arg0){
		//TODO Auto-generated method stub
	}
	public void keyReleased(KeyEvent arg0){
		//TODO Auto-generated method stub
	}
	public void keyTyped(KeyEvent arg0){
		//TODO Auto-generated method stub
	}
	//鼠标相关事件如下：
	public void mouseClicked(MouseEvent e){
		//TODO Auto-generated method stub
		if(e.getButton()==MouseEvent.BUTTON3){
			//撤销移动
			undo();
		}
	}
	public void mouseReleased(MouseEvent arg0){
		//TODO Auto-generated method stub
	}
	public void mouseEntered(MouseEvent arg0){
		//TODO Auto-generated method stub
	}
	public void mouseExited(MouseEvent arg0){
		//TODO Auto-generated method stub
	}
	public void mousePressed(MouseEvent arg0){
		//TODO Auto-generated method stub
	}
	//程序入口Main方法实例化一个GameFrame窗口。
	public static void main(String args[]){
		new GameFrame();
	}
}











