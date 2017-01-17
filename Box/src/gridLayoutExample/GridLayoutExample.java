package gridLayoutExample;
import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame{
	JButton buttons[];
	GridLayout layout;
	public void init(){
		this.setTitle("网格布局管理器示例");
		layout=new GridLayout(4,3,50,10);
		setLayout(layout);                 //设置4行3列的网格布局
		buttons=new JButton[12];
		for(int i=0;i<12;i++){
			buttons[i]=new JButton("按钮"+(i+1));
			add(buttons[i]);
	}
	}
	public static void main(String args[]){
		GridLayoutExample gle=new GridLayoutExample();
		gle.init();
		gle.pack();
		gle.setVisible(true);
		gle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
