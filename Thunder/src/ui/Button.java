package ui;

import java.awt.Cursor;

import javax.swing.JButton;
/**
 * 
 * @Description: use "isFcous" to save that if it has been click;
 * @author: hzp
 * @date: 2017.2.1
 */
public class Button extends JButton{
	private boolean isFcous;
	
	protected Button(){
		super();
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		isFcous = false;
	}
	
	protected boolean getStatus(){
		return isFcous;
	}
	
	protected void setStatus(boolean status){
		this.isFcous = status;
	}
}
