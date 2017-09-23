package pullBox;
import javax.sound.midi.*;
import java.io.File;

public class Sound {
	//播放背景音乐
	String path=new String("G:/javagame workspace/PullBox/musics//");
	String file=new String("monkey.MP3");
	Sequence seq;
	Sequencer midi;
	boolean sign;
	void loadSound(){
		try{
			seq=MidiSystem.getSequence(new File(path+file));
			midi=MidiSystem.getSequencer();
			midi.open();
			midi.setSequence(seq);
			midi.start();
			midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		}catch (Exception ex){
			ex.printStackTrace();}
		sign=true;
	}
	void mystop(){
		midi.stop();
		midi.close();
		sign=false;
	}
	boolean isplay(){
		return sign;
	}
	void setMusic(String e){
		file=e;
	}
}
