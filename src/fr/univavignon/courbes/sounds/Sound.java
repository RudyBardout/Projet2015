package fr.univavignon.courbes.sounds;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

public class Sound extends Thread implements action
{
	public static Mixer mixer;
	public static Clip clip;
	@Override public void erase(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void big(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void fly(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void game(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void speed(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void slow(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void death(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void pop_item(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void upside_down(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void mass_item(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void menu(File file)
	{
	//public static void audio(File file)
	//{
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
	@Override public void through_wall(File file)
	{
	//public static void audio(File file)
	//{
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

