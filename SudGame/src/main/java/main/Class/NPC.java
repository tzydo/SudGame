package main.Class;
import java.util.Random;

import main.Class.Statistic.Statistic;;

public class NPC {

	private Statistic stat;

	private String[] tab = { "Dexter Taylor", "Jordan Watson", "Brandon Miller", "Noah Clarke", "Joel Russell",
			"Walker Paul", "Luciano Meyers", "Jasiah Mccoy", "Francisco Barber", "Dylan Knight", "Christopher Fox",
			"Jordan Henderson", "Frankie Holland", "Jonathan Price", "Isaias Valencia", "Brody Wilson",
			"Mustafa Holman", "Yael Mckinney", "Royce Duran", "Joel Khan", "Rhys Hawkins", "Brandon Armstrong",
			"Luca Kaur", "Dexter Wilson", "Izayah Pickett", "August Long", "Marvin Richardson", "Jackson Palmer",
			"Mauricio York", "Ollie Parry", "Gabriel Parry", "Alfie Parker", "Jacob King", "Sebastian Mitchell",
			"Kian Christensen", "Richard Espinoza", "Mayson Castaneda", "Zachariah Lynch", "Malcolm Macdonald",
			"Augustus Flores" };

	private Random random = new Random();

	public NPC() {
		stat = new Statistic(setName(), 100, 10, 10, 10, setLevelPoints());
	}

	private String setName() {
		int nr = random.nextInt(tab.length);
		return tab[nr];
	}

	private int setLevelPoints() {
		int strenth = random.nextInt(40);
		return strenth;
	}

	public String getName() {
		return stat.getName();
	}

	public void setHealt(int healt) {
		stat.setHealt(healt);
	}

	public int getHealt() {
		return stat.getHealt();
	}

	public void getHit(int hit) {
		stat.setHealt(stat.getHealt()-hit);
	}
	
	public int getAgility(){
		return stat.getAgility();
	}
	
	public int getStrenth(){
		return stat.getStrenth();
	}
	
	public Boolean isLive(){
		return stat.isAlive();
	}
	
	@Override
	public String toString(){
		return (getName() +"(" + stat.getLevel() + ")");
	}
}