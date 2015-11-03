// user interface code. Have to replace the location of the URL into where you place the file thought



import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
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
			try { //background music
			     AudioClip clip = Applet.newAudioClip(new URL("C:\\Users\\Dylan\\Documents\\GitHub\\Skywalk\\UserInput\\resources\\battle.wav"));
			     clip.play();
				} 
			catch (MalformedURLException murle) 
				{
				murle.printStackTrace();
		
				Clip clip = AudioSystem.getClip();
				// getAudioInputStream() also accepts a File or InputStream
				AudioInputStream ais = AudioSystem.getAudioInputStream((new File("C:\\Users\\Dylan\\Documents\\GitHub\\Skywalk\\UserInput\\resources\\battle.wav")));
				clip.open(ais);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			j1.setVisible(true);
	}
}
