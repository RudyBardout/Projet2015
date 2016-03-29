package fr.univavignon.courbes.sounds;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound 
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

