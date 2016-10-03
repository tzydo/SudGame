package main.Class.Statistic;

import main.Class.location.Location;

public class Statistic {
	private String name;
	private int healt;
	private int strenth;
	private int magic;
	private int agility;
	private int points;
	private Location location;
	private String level ="";

	public Statistic(String name, int healt, int strenth, int magic, int agility,Location location) {
		this.name = name;
		this.healt = healt;
		this.strenth = strenth;
		this.magic = magic;
		this.agility = agility;
		this.location = location;
		setLevel(this.points);
	}

	public Statistic(String name, int healt, int strenth, int magic, int agility, int points) {
		this.name = name;
		this.healt = healt;
		this.strenth = strenth;
		this.magic = magic;
		this.agility = agility;
		this.points = points;
		setLevel(this.points);
	}
	
	private void setLevel(int strenth) {
		if(strenth>30 && strenth<=40)this.level = "hard";
		if(strenth>20 && strenth<=30)this.level = "medium";
		if(strenth>10 && strenth<=20)this.level = "easy";
		if(strenth>=0 && strenth<=10)this.level = "very easy";
		
	}
	
	public Boolean isAlive(){
		Boolean isLive = true;
		if(this.healt<=0)isLive = false;
		return isLive;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealt() {
		return healt;
	}

	public void setHealt(int healt) {
		this.healt = healt;
	}

	public int getStrenth() {
		return strenth;
	}

	public void setStrenth(int strenth) {
		this.strenth = strenth;
	}

	public int getMagic() {
		return magic;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
