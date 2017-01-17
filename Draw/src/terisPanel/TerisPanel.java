package terisPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
public class TerisPanel extends JPanel implements Runnable,KeyListener{
	public int ypos=-80, xpos=110; //С�����Ͻ�����
	public TerisPanel(){
		Thread t=new Thread(this); //�������߳�
		t.start();                 //�����߳�
		//�趨�����ڱ���岢��Ϊ��������
		setFocusable(true);
		addKeyListener(this);
	}
	public void run(){              //����run()����
		while(true){                //�߳�����ѭ��
			try{
				Thread.sleep(30);   //�߳�����30ms
			}catch(InterruptedException e){}
			ypos+=5;                //�޸�С�����Ͻǵ�������
			if(ypos>300)
				ypos=-80;
			if(xpos<-80)
				xpos=380;
			if(xpos>380)
				xpos=-80;
			repaint();              //�����ػ�
		}		
	}
	public void paint(Graphics g){  //���ػ�ͼ����
		super.paint(g);             //�������ԭ���Ķ�������
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.RED);
		g.fillOval(xpos, ypos, 80, 80);//����С��
		}
	public void keyPressed(KeyEvent e){
		int keyCode=e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_LEFT:
			xpos-=10;
			break;
		case KeyEvent.VK_RIGHT:
			xpos+=10;
			break;
		}
		repaint();
	}
	public void keyReleased(KeyEvent arg0){
	}
	public void keyTyped(KeyEvent arg0){
	}
}
