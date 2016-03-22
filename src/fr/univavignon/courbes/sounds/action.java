package fr.univavignon.courbes.sounds;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;
public interface action 
{
	public void game(File file);
	public void death(File file);
	public void pop_item(File file);
	public void menu(File file);
	public void speed(File file);
	public void slow(File file);
	public void erase(File file);
	public void fly(File file);
	public void big(File file);
	public void upside_down(File file);
	public void mass_item(File file);
	public void through_wall(File file);
}
