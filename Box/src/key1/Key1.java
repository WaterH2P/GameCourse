package key1;
import javax.swing.*;
import java.awt.event.*;

public class Key1 extends JFrame implements KeyListener{
	JTextArea t=new JTextArea();
	public Key1(){
		super("键盘事件");
		setBounds(0,0,400,300);
		JScrollPane sp=new JScrollPane();
		sp.setViewportView(t);
		add(sp,"Center");
		t.addKeyListener(this);
		setVisible(true);
	}
	public void keyPressed(KeyEvent e){
		String keyText=KeyEvent.getKeyText(e.getKeyCode());
		if(e.isActionKey())
				System.out.println("您按下的是动作键 "+keyText+" ");
		else{
			System.out.println("您按下的是非动作键 "+keyText+" ");
		}
	}
	public void keyTyped(KeyEvent e){
		System.out.println("此次输入的是 "+e.getKeyCode()+" ");
	}
	public void keyReleased(KeyEvent e){
		System.out.println("您释放的是 "+e.getKeyChar()+" ");
	}
	public static void main(String args[]){
		Key1 f=new Key1();
	}
}
