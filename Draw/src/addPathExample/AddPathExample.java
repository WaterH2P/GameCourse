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
		//muArray包含正三角形的所有顶点
		Point[] myArray ={
				new Point(130,130), new Point(160,160),
				new Point(100,160), new Point(130,130),
				};
		myPath=new GeneralPath();                      //建立GeneralPath对象
		myPath.moveTo(myArray[0].x,myArray[0].y);      //起始顶点
		for(int i=0;i<myArray.length;i++)              //创建正三角形路径 
			myPath.lineTo(myArray[i].x,myArray[i].y);  //绘制直线
		g2.draw(myPath);                               //画正三角形
		//myArray2包含倒三角形的所有顶点
		Point[] myArray2={
				new Point(130,130), new Point(100,100),
				new Point(160,100), new Point(130,130),
		};
		myPath2=new GeneralPath();                     //建立GeneralPath对象
		myPath2.moveTo(myArray[0].x,myArray[0].y);     //起始顶点
		for(int i=1;i<myArray2.length;i++)             //创建倒三角的路径
			myPath2.lineTo(myArray2[i].x,myArray2[i].y);//绘制直线
		g2.draw(myPath2);  //画倒三角
		}
	public static void main(String args[]){
		AddPathExample ape=new AddPathExample();
		ape.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
