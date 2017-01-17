package jFrame;
/*
 * 基于JFrame实现的窗口界面
 */
import javax.swing.*;
import java.awt.*;
public class JFrameDemo {
	JFrame f;
	JButton b;
	Container c;
	public JFrameDemo(){
		f=new JFrame("JFrame Demo");
		b=new JButton("Press me");
		c=f.getContentPane();//获取内容面板容器
		c.add(b);            //为内容面板添加内容组件
		f.setSize(200,200);
		f.setVisible(true);
	}
	public static void main(String args[]){
		new JFrameDemo();
	}
}
