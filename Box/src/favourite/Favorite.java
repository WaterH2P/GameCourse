package favourite;
//���һ���̳�����Favorite�࣬����У��˶������ԣ����֣�����
import javax.swing.*;
import java.awt.*;
class Favorite extends JPanel{
	JCheckBox sport,computer,music,read;
	Favorite(){
		sport=new JCheckBox("�˶�");
		computer=new JCheckBox("����");
		music=new JCheckBox("����");
		read=new JCheckBox("����");
		add(new JLabel("����"));
		add(sport);add(computer);add(music);add(read);
		sport.setSelected(false);
		computer.setSelected(false);
		music.setSelected(false);
		read.setSelected(false);
	}
}
