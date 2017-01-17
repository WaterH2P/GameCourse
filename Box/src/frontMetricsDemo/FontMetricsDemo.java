package frontMetricsDemo;
import java.awt.*;
import javax.swing.JFrame;
public class FontMetricsDemo extends JFrame{
	public FontMetricsDemo(){
		super();
		setTitle("FontMetrics ��ʾ");
		setSize(300,200);
		setVisible(true);
	}
	public void paint(Graphics g){
		Font font=new Font("����",Font.BOLD+Font.ITALIC,30);
		g.setFont(font);
		setBackground(Color.LIGHT_GRAY);
		g.setColor(Color.black);
		FontMetrics f=g.getFontMetrics();
		int width=f.stringWidth("java��Ϸ�����̳�");
		int ascent=f.getAscent();
		int descent=f.getDescent();
		int x=(getWidth()-width)/2;
		int y=(getHeight()-ascent)/2;
		g.drawString("java��Ϸ�����̳�",x,y);
	}
	public static void main(String args[]){
		FontMetricsDemo fmd=new FontMetricsDemo();
		fmd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
