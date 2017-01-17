package jRadioButtomTest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioButtonTest {
	JFrame f=null;
	JRadioButtonTest(){
		f=new JFrame("单选框示例");//创建一个JFrame的对象
		Container contentPane=f.getContentPane();//创建一个内容面板容器
		contentPane.setLayout(new FlowLayout());//设置该窗口的布局
		JPanel pl=new JPanel();//创建一个面板对象pl
		pl.setLayout(new GridLayout(1,4));//设置布局管理器格式
		pl.setBorder(BorderFactory.createTitledBorder("选择你喜欢的城市"));
		//定义3个JRadioButton单选按钮
		JRadioButton r1=new JRadioButton("北京");
		JRadioButton r2=new JRadioButton("上海");
		JRadioButton r3=new JRadioButton("苏州");
		JRadioButton r4=new JRadioButton("泰州");
		pl.add(r1);
		pl.add(r2);
		pl.add(r3);
		pl.add(r4);
		r1.setSelected(true);  //设置“北京”单选按钮为被选中
		contentPane.add(pl);   //面板对象pl加到窗口面板容器中
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){//添加一个窗口监听器
			public void windowClosing(WindowEvent e){
				System.exit(0);
				}
			});
		}
		public static void main(String args[]){
			new JRadioButtonTest();
		}
}

