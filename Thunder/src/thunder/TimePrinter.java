package thunder;
import java.util.*;

public class TimePrinter extends Thread{
	int pauseTime;
	String name;
	public TimePrinter(int x,String n){
		pauseTime=x;
		name=n;
	}
	public void run(){
		while(true){
			try{
				System.out.println(name + ":" + new Date(System.currentTimeMillis()));
				Thread.sleep(pauseTime);
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
	public static void main(String args[]){
		TimePrinter tp1=new TimePrinter(1000,"Fast Guy");   //线程的创建
		tp1.start();										//线程的启动
		TimePrinter tp2=new TimePrinter(3000,"Slow Guy");
		tp2.start();
	}
}
