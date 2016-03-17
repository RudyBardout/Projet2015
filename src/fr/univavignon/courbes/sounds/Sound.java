package fr.univavignon.courbes.sounds;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

public class Sound extends Thread implements action
{
	public static Mixer mixer;
	public static Clip clip;
	
	public static void audio(File file)
	{
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
		for(Mixer.Info info : mixInfos)
		System.out.println(info.getName() + "----" + info.getDescription());
	
		mixer = AudioSystem.getMixer(mixInfos[0]);
		DataLine.Info datainfo = new DataLine.Info(Clip.class, null);
		try { clip = (Clip)mixer.getLine(datainfo);}
		catch ( LineUnavailableException lue ) { lue.printStackTrace();}
	
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			clip.open(audio);
		}
		catch( LineUnavailableException lue ) { lue.printStackTrace();}
		catch(UnsupportedAudioFileException uafe) { uafe.printStackTrace();}
		catch(IOException ioe) { ioe.printStackTrace(); }
	
		clip.start();
		do
		{
			try { Thread.sleep(50); }
			catch(InterruptedException ie ) {ie.printStackTrace();}
		}
		while(clip.isActive());
	}
}

