// user interface code. Have to replace the location of the URL into where you place the file thought



import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;


public class UserWindow {

	public static void main(String[] args)  
		throws Exception{
			JFrame j1 = new JFrame();
			j1.setSize(1000, 700);
			j1.setTitle("Skywalker");
			j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			UserComp u1 = new UserComp();
			j1.add(u1);
			j1.setVisible(true);
			URL path = ClassLoader.getSystemResource("battle.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(path);
			clip.open(ais);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
}
