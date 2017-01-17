package key1;
import javax.swing.*;
import java.awt.event.*;

public class Key1 extends JFrame implements KeyListener{
	JTextArea t=new JTextArea();
	public Key1(){
		super("�����¼�");
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
				System.out.println("�����µ��Ƕ����� "+keyText+" ");
		else{
			System.out.println("�����µ��ǷǶ����� "+keyText+" ");
		}
	}
	public void keyTyped(KeyEvent e){
		System.out.println("�˴�������� "+e.getKeyCode()+" ");
	}
	public void keyReleased(KeyEvent e){
		System.out.println("���ͷŵ��� "+e.getKeyChar()+" ");
	}
	public static void main(String args[]){
		Key1 f=new Key1();
	}
}
