package favourite;
//��������ʾFavorite������Ĵ���
import javax.swing.*;
import java.awt.*;
public class JCheckBoxExample extends JFrame{
	public JCheckBoxExample(){
		super("��ѡ��");
		Container container=getContentPane();
		container.setLayout(new FlowLayout());
		Favorite f=new Favorite();
		container.add(f);
		pack();
		setVisible(true);
	}
	public static void main(String args[]){
		JCheckBoxExample jcbe=new JCheckBoxExample();
		jcbe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
