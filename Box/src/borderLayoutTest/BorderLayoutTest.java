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
		//���������Ĳ��ַ�ʽΪBorderLayout
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new JButton("��"),BorderLayout.EAST);
		contentPane.add(new JButton("��"),BorderLayout.WEST);
		contentPane.add(new JButton("��"),BorderLayout.SOUTH);
		contentPane.add(new JButton("��"),BorderLayout.NORTH);
		//����ǩ�ŵ��м�
		contentPane.add(new JLabel("��",JLabel.CENTER),BorderLayout.CENTER);
		jf.setTitle("BorderLayout���ֹ�����ʾ��");//���ñ���
		jf.setSize(250,250);
		jf.setVisible(true);
		//��һ�����ڽ��йرղ������¼�
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
