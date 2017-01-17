package myBoll;
import java.awt.*;
import javax.swing.JPanel;
public class TetrisPanel extends JPanel implements Runnable{
	//��ͼ�߳���
	public int ypos=-80; //С�����Ͻǵ�������
	public int xpos=-80;
	public int xpos2=380;
	//�����������������˽�г�Ա
	private Image iBuffer;
	private Graphics gBuffer;
	public TetrisPanel(){
		//����һ�����߳�
		Thread t=new Thread(this);
		//�����߳�
		t.start();
	}
	public void run()          //����run()����
	{
		while(true){           //�߳�����ѭ��
			try{
				Thread.sleep(30);  //�߳�����30ms
			}catch(InterruptedException e){}
			ypos+=5;               //�޸�С�����Ͻǵ�������
			xpos+=5;
			xpos2-=5;
			if(ypos>300)           //С���뿪���ں��������Ͻǵ�������
				ypos=-80;
			if(xpos>300)
				xpos=-80;
			if(xpos2<0)
				xpos2=380;
			repaint();             //�����ػ�
		}
	}
	public void paint(Graphics g)  //���ػ�ͼ����
	{
		super.paint(g);            //�������ԭ�����Ķ�������
		                           //������Ļ������ԭ�����Ķ�������
		g.clearRect(0,0,this.getWidth(),this.getHeight());
		g.setColor(Color.RED);     //����С����ɫ
		g.fillOval(xpos,ypos,80,80); //����С��
		g.setColor(Color.YELLOW);
		g.fillOval(xpos-100,ypos,80,80);
		g.setColor(Color.BLUE);
		g.fillOval(xpos,ypos+100,80,80);
		g.setColor(Color.orange);
		g.fillOval(xpos-100,ypos+100,80,80);
		g.setColor(Color.RED);     
		g.fillOval(xpos2-100,ypos,80,80); 
		g.setColor(Color.YELLOW);
		g.fillOval(xpos2,ypos,80,80);
		g.setColor(Color.BLUE);
		g.fillOval(xpos2-100,ypos+100,80,80);
		g.setColor(Color.orange);
		g.fillOval(xpos2,ypos+100,80,80);
	}
}
