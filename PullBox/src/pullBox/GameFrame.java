package pullBox;
//�Ҽ������������幦��
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/***
 * ���ص�ͼ�������ı�������ɾȥ
 */

public class GameFrame extends JFrame implements ActionListener, MouseListener, KeyListener{
	//�������
	private int grade=0;
	//row,column�����˵��кš��к�
	//leftX,leftY�������Ͻ�ͼƬ��λ�ã�����ͼƬ��(0,0)���꿪ʼ
	private int row=7, column=7, leftX=0, leftY=0;
	//���ص�ͼ��������
	private int mapRow=0, mapColumn=0;
	//width,height������Ļ�Ĵ�С
	private int width=0;
	private boolean acceptKey=true;
	//�����õ���ͼƬ
	private Image pic[]=null;
	private byte map[][]=null;
	private ArrayList list=new ArrayList();
	Sound sound;
	final byte Wall=1, Box=2, BoxOnEnd=3, End=4, ManDown=5, ManLeft=6, ManRight=7, ManUp=8,
			Road=9, ManDownOnEnd=10, ManLeftOnEnd=11, ManRightOnEnd=12, ManUpOnEnd=13;
/*�ڹ��췽��GrameFrame()�У�����initMap()��������ʼ������grade��Ϸ��ͼ��
 * ��ջ�����Ϣ�б�list��ͬʱ����MIDI�������֡�
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
		//���13����Ƭ
		getPic();
		width=this.getWidth();
		this.setFocusable(true);
		//��ʼ������grade��Ϸ��ͼ����ջ�����Ϣ�б�list
		initMap();
		this.addKeyListener(this);
		this.addMouseListener(this);
	//	sound=new Sound();
	//	sound.loadSound();
		//����MIDI��������
	}
/*initMap()�����������ǳ�ʼ������grade��Ϸ��ͼ����ջ�����Ϣ�б�list��
 * ����getMapSizeAndPosition()������ȡ��Ϸ�����С����ʾ��Ϸ�����Ͻ�λ��(leftX,leftY)��
 */
	public void initMap(){
		map=MapFactory.getMap(grade);
		list.clear();
		getMapSizeAndPosition();
		getManPosition();
	}
//getManPosition()�����������ǻ�ȡ���˵ĵ�ǰλ��(row,column)��
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
//getManPositionzeAndPosition()����������ȡ��Ϸ�����С����ʾ��Ϸ�����Ͻ�λ��(leftX,leftY)��
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
//getPic()������������Ҫ��ʵ��ͼƬ
	public void getPic(){
		pic=new Image[14];
		for(int i=0;i<=13;i++){
			pic[i]=Toolkit.getDefaultToolkit().getImage("image//box_"+i+".jpg");
		}
	}
//grassOrEnd(byte man)���������ж������ڵ�λ����ͨ������Ŀ�ĵء�
	public byte roadOrEnd(byte man){
			byte result=Road;
			if(man==ManDownOnEnd||man==ManLeftOnEnd||man==ManRightOnEnd||man==ManUpOnEnd)
				result=End;
			return result;
	}
//������
	private void moveUp(){
		//��һλp1ΪWall
		if(map[row-1][column]==Wall)
			return;
		//��һλp1λBox��BoxOnEnd���迼��p2
		if(map[row-1][column]==Box||map[row-1][column]==BoxOnEnd){
			if(map[row-2][column]==End||map[row-2][column]==Road){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte boxTemp=map[row-2][column]==End?BoxOnEnd:Box;
				byte manTemp=map[row-1][column]==Box?ManUp:ManUpOnEnd;
				//���ӱ��temp��������ǰһ��
				map[row-2][column]=boxTemp;
				//�˱��manUp��������һ��
				map[row-1][column]=manTemp;
				//���˸ղ�վ�ĵط����Road����End
				map[row][column]=roadOrEnd(map[row][column]);
				//���뿪���޸��˵�����
				row--;
			}
		}
		else{
			//��һλλRoad����End�����迼��p2��
			if(map[row-1][column]==Road||map[row-1][column]==End){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte temp=map[row-1][column]==End?ManUpOnEnd:ManUp;
				//�˱��temp��������һ��
				map[row-1][column]=temp;
				//�˸ղ�վ�ĵط����Road����End
				map[row][column]=roadOrEnd(map[row][column]);
				//���뿪���޸��˵�����
				row--;
			}
		}
	}
//������
	private void moveDown(){
		//��һλp1ΪWall
		if(map[row+1][column]==Wall)
			return;
		//��һλp1λBox��BoxOnEnd���迼��p2
		if(map[row+1][column]==Box||map[row+1][column]==BoxOnEnd){
			if(map[row+2][column]==End||map[row+2][column]==Road){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte boxTemp=map[row+2][column]==End?BoxOnEnd:Box;
				byte manTemp=map[row+1][column]==Box?ManDown:ManDownOnEnd;
				//���ӱ��temp����������һ��
				map[row+2][column]=boxTemp;
				//�˱��manUp��������һ��
				map[row+1][column]=manTemp;
				//���˸ղ�վ�ĵط����Road����End
				map[row][column]=roadOrEnd(map[row][column]);
				//���뿪���޸��˵�����
				row++;
			}
		}
		else{
			//��һλλRoad����End�����迼��p2��
			if(map[row+1][column]==Road||map[row+1][column]==End){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte temp=map[row+1][column]==End?ManDownOnEnd:ManDown;
				//�˱��temp��������һ��
				map[row+1][column]=temp;
				//�˸ղ�վ�ĵط����Road����End
				map[row][column]=roadOrEnd(map[row][column]);
				//���뿪���޸��˵�����
				row++;
			}
		}
	}
//������
	private void moveLeft(){
		//��һλp1ΪWall
		if(map[row][column-1]==Wall)
			return;
		//��һλp1λBox��BoxOnEnd���迼��p2
		if(map[row][column-1]==Box||map[row][column-1]==BoxOnEnd){
			if(map[row][column-2]==End||map[row][column-2]==Road){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte boxTemp=map[row][column-2]==End?BoxOnEnd:Box;
				byte manTemp=map[row][column-1]==Box?ManLeft:ManLeftOnEnd;
				//���ӱ��temp����������һ��
				map[row][column-2]=boxTemp;
				//�˱��manUp��������һ��
				map[row][column-1]=manTemp;
				//���˸ղ�վ�ĵط����Road����End
				map[row][column]=roadOrEnd(map[row][column]);
				//���뿪���޸��˵�����
				column--;
			}
		}
		else{
			//��һλλRoad����End�����迼��p2��
			if(map[row][column-1]==Road||map[row][column-1]==End){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte temp=map[row][column-1]==End?ManLeftOnEnd:ManLeft;
				//�˱��temp��������һ��
				map[row][column-1]=temp;
				//�˸ղ�վ�ĵط����Road����End
				map[row][column]=roadOrEnd(map[row][column]);
				//���뿪���޸��˵�����
				column--;
			}
		}
	}
//������
	private void moveRight(){
		//��һλp1ΪWall
		if(map[row][column+1]==Wall)
			return;
		//��һλp1λBox��BoxOnEnd���迼��p2
		if(map[row][column+1]==Box||map[row][column+1]==BoxOnEnd){
			if(map[row][column+2]==End||map[row][column+2]==Road){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte boxTemp=map[row][column+2]==End?BoxOnEnd:Box;
				byte manTemp=map[row][column+1]==Box?ManRight:ManRightOnEnd;
				//���ӱ��temp����������һ��
				map[row][column+2]=boxTemp;
				//�˱��manUp��������һ��
				map[row][column+1]=manTemp;
				//���˸ղ�վ�ĵط����Road����End
				map[row][column]=roadOrEnd(map[row][column]);
				//���뿪���޸��˵�����
				column++;
			}
		}
		else{
			//��һλλRoad����End�����迼��p2��
			if(map[row][column+1]==Road||map[row][column+1]==End){
				Map currMap=new Map(row,column,map);
				list.add(currMap);
				byte temp=map[row][column+1]==End?ManRightOnEnd:ManRight;
				//�˱��temp��������һ��
				map[row][column+1]=temp;
				//�˸ղ�վ�ĵط����Road����End
				map[row][column]=roadOrEnd(map[row][column]);
				//���뿪���޸��˵�����
				column++;
			}
		}
	}
	//isFinishen()������֤����Ƿ�ͨ�ء������Ŀ�ĵ�End������Ŀ�ĵ���û�гɹ���
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
	//paint(Graphics g)��������������Ϸ�����ͼ��
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				//������ͼ��i����������j��������
				if(map[i][j]!=0)
					g.drawImage(pic[map[i][j]],leftX+j*30,leftY+i*30,this);
			}
		}
		g.setColor(Color.red);
		g.setFont(new Font("����_2312",Font.BOLD,30));
		g.drawString("�����ǵ�",150,140);
		g.drawString(String.valueOf(grade+1),310,140);
		g.drawString("��",360,140);
	}
	//getManX()��getManY()���������˵�λ��
	public int getManX(){
		return row;
	}
	public int getManY(){
		return column;
	}
	//getGrade()�������ص�ǰ�ؿ���
	public int getGrade(){
		return grade;
	}
	//getMap(int grade)�������ص�ǰ�ؿ��ĵ�ͼ��Ϣ
	public byte[][] getMap(int grade){
		return MapFactory.getMap(grade);
	}
	//DisplayToast(String str)����������ʾ��ʾ��Ϣ�Ի���
	/*��ʾ��ʾ��Ϣ�Ի���*/
	public void DisplayToast(String str){
		JOptionPane.showMessageDialog(null,str,"��ʾ",JOptionPane.ERROR_MESSAGE);
	}
	//undo()�����������ǳ����ƶ�����
	public void undo(){
		if(acceptKey){
			//����
			if(list.size()>0){
				//�������������߹�
				Map priorMap=(Map)list.get(list.size()-1);
				map=priorMap.getMap();
				row=priorMap.getManX();
				column=priorMap.getManY();
				repaint();
				list.remove(list.size()-1);
			}
			else
				DisplayToast("�����ٳ���!");
		}
		else
			DisplayToast("�˹�����ɣ����ܳ���!");
	}
	//nextGrade()����ʵ����һ�س�ʼ����������repaint()������ʾ��Ϸ����
	public void nextGrade(){
		if(grade>=MapFactory.getCount()-1){
			DisplayToast("     ��ϲ��������йؿ�!");
			acceptKey=false;
		}
		else{
			grade++;
			initMap();
			repaint();
			acceptKey=true;
		}
	}
	//priorGrade()����ʵ����һ�س�ʼ��������repaint()������ʾ��Ϸ���档
	public void priorGrade(){
		grade--;
		acceptKey=true;
		if(grade<0)
			grade=0;
		initMap();
		repaint();
	}
	//��������¼����¡������kayPressed�����¼��и����û��İ�����Ϣ���ֱ����4�������ƶ��ķ�����
	public void keyPressed(KeyEvent e){//�����¼�
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
			//���ð���
			acceptKey=false;
			if(grade==10){
				JOptionPane.showMessageDialog(this,"��ϲͨ�����һ��");
			}
			else{
				//��ʾ������һ��
				String msg="     ��ϲ��ͨ����"+grade+"��!!!\n     �Ƿ�Ҫ������һ��?";
				int type=JOptionPane.YES_NO_OPTION;
				String title="����";
				int choice=0;
				choice=JOptionPane.showConfirmDialog(null,msg,title,type);
				if(choice==1){
					acceptKey=true;
					grade--;
					nextGrade();
				}
				else if(choice==0){
					//������һ��
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
	//�������¼����£�
	public void mouseClicked(MouseEvent e){
		//TODO Auto-generated method stub
		if(e.getButton()==MouseEvent.BUTTON3){
			//�����ƶ�
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
	//�������Main����ʵ����һ��GameFrame���ڡ�
	public static void main(String args[]){
		new GameFrame();
	}
}











