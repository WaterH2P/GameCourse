package addPathExample;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;
public class AddPathExample extends JFrame{
	public AddPathExample(){
		super();
		setTitle("GeneralPath Demo");
		setSize(400,400);
		setVisible(true);
	}
	public void paint(Graphics g){
		Graphics2D g2=(Graphics2D) g;
		GeneralPath myPath, myPath2;
		//muArray�����������ε����ж���
		Point[] myArray ={
				new Point(130,130), new Point(160,160),
				new Point(100,160), new Point(130,130),
				};
		myPath=new GeneralPath();                      //����GeneralPath����
		myPath.moveTo(myArray[0].x,myArray[0].y);      //��ʼ����
		for(int i=0;i<myArray.length;i++)              //������������·�� 
			myPath.lineTo(myArray[i].x,myArray[i].y);  //����ֱ��
		g2.draw(myPath);                               //����������
		//myArray2�����������ε����ж���
		Point[] myArray2={
				new Point(130,130), new Point(100,100),
				new Point(160,100), new Point(130,130),
		};
		myPath2=new GeneralPath();                     //����GeneralPath����
		myPath2.moveTo(myArray[0].x,myArray[0].y);     //��ʼ����
		for(int i=1;i<myArray2.length;i++)             //���������ǵ�·��
			myPath2.lineTo(myArray2[i].x,myArray2[i].y);//����ֱ��
		g2.draw(myPath2);  //��������
		}
	public static void main(String args[]){
		AddPathExample ape=new AddPathExample();
		ape.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
