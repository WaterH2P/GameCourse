package borderLayoutTest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BorderLayoutTest {
	public BorderLayoutTest(){
		JFrame jf=new JFrame();
		Container contentPane=jf.getContentPane();
		//设置容器的布局方式为BorderLayout
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new JButton("东"),BorderLayout.EAST);
		contentPane.add(new JButton("西"),BorderLayout.WEST);
		contentPane.add(new JButton("南"),BorderLayout.SOUTH);
		contentPane.add(new JButton("北"),BorderLayout.NORTH);
		//将标签放到中间
		contentPane.add(new JLabel("中",JLabel.CENTER),BorderLayout.CENTER);
		jf.setTitle("BorderLayout布局管理器示例");//设置标题
		jf.setSize(250,250);
		jf.setVisible(true);
		//对一个窗口进行关闭操作的事件
		jf.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public static void main(String args[]){
		new BorderLayoutTest();
	}
}
