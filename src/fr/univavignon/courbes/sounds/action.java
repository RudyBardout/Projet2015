package fr.univavignon.courbes.sounds;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;
public interface action 
{
	public void game();
	public void death();
	public void pop_item();
	public void menu();
	public void speed();
	public void slow();
	public void erase();
	public void fly();
	public void big();
	public void upside_down();
	public void mass_item();
	public void through_wall();
}
