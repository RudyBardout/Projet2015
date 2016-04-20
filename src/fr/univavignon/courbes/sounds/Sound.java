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

public class Sound extends Thread implements action
{
	public static Mixer mixer;
	public static Clip clip;
	private String name;
	@Override public void erase()
	{
		this.name = "res/sounds/.wav";
		start();
	}
	@Override public void big()
	{
		this.name="res/sounds/.wav";
		start();
	}
	@Override public void fly()
	{
		this.name="res/sounds/fly.wav";
		start();
	}
	@Override public void game()
	{
		this.name="res/sounds/game.wav";
		start();
	}
	@Override public void speed()
	{
		this.name="res/sounds/speed.wav";
		start();
	}
	@Override public void slow()
	{
		this.name="res/sounds/slow.wav";
		start();
	}
	@Override public void death()
	{
		this.name="res/sounds/death.wav";
		start();
	}
	@Override public void pop_item()
	{
		this.name="res/sounds/pop_item.wav";
		start();
	}
	@Override public void upside_down()
	{
		this.name="res/sounds/through_wall.wav";
		start();
	}
	@Override public void mass_item()
	{
		this.name="res/sounds/mass_item.wav";
		start();
	}
	@Override public void menu()
	{
		this.name="res/sounds/menu.wav";
		start();
	}

	@Override public void through_wall()
	{
		this.name="res/sounds/through_wall.wav";
		start();
	}
	
public void audio()
	{
	File file = new File(name);
		
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
	@Override public void end()
	{
		this.stop();
	}
}

