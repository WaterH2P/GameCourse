package jComboBox;
import javax.swing.*;
import java.awt.*;

public class JComboBoxExample extends JFrame{
	JComboBox comboBox1,comboBox2;
	String cityNames[]={"����","�Ϻ�","����","�Ͼ�","�人","����"};
	public JComboBoxExample(){
		super("��Ͽ�");
		Container container=getContentPane();
		container.setLayout(new FlowLayout());
		comboBox1=new JComboBox(cityNames);
		comboBox1.setSelectedIndex(4);
		comboBox1.setEditable(false);
		comboBox2=new JComboBox(cityNames);
		comboBox2.setSelectedItem(cityNames[1]);
		comboBox2.addItem(new String("��ɳ"));
		comboBox2.setEditable(true);
		container.add(comboBox1);
		container.add(comboBox2);
		pack();
		setVisible(true);
	}
	public static void main(String args[]){
		JComboBoxExample jcbe=new JComboBoxExample();
		jcbe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}