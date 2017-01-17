package myBoll;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyBoll extends JFrame{
	MyBoll(){
		//设置窗口标题
		this.setTitle("Boll is falling");
		Container c=this.getContentPane();//获取面板容器
		c.add(new TetrisPanel());
		//设置窗口开始显示时距离屏幕左边400个像素点
		//距离屏幕上边200个像素点
		//窗口宽300个像素点，窗口高300个像素点
		this.setBounds(400,200,300,300);
		//设置窗口关闭按钮具有关闭整个程序的功能
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);  //设置窗口大小不会改变
		this.setVisible(true);     //显示该窗口
	}
	public static void main(String args[]){
		//创建该窗口的实例DB，开始整个程序
		MyBoll DB=new MyBoll();    //创建主类的对象
		DB.addWindowFocusListener(new WindowAdapter(){
			//添加窗口关闭处理方法
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});		
	}
}
