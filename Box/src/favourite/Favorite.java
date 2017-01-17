package favourite;
//设计一个继承面板的Favorite类，类别有：运动，电脑，音乐，读书
import javax.swing.*;
import java.awt.*;
class Favorite extends JPanel{
	JCheckBox sport,computer,music,read;
	Favorite(){
		sport=new JCheckBox("运动");
		computer=new JCheckBox("电脑");
		music=new JCheckBox("音乐");
		read=new JCheckBox("读书");
		add(new JLabel("爱好"));
		add(sport);add(computer);add(music);add(read);
		sport.setSelected(false);
		computer.setSelected(false);
		music.setSelected(false);
		read.setSelected(false);
	}
}
