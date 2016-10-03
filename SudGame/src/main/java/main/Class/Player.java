package main.Class;

import main.Class.Statistic.Statistic;
import main.Class.location.*;
import main.Class.movements.Direction;

public class Player {

	private Statistic stat;

	
	public Player(String name, Location location) {
		stat = new Statistic(name, 100, 20, 20, 11, location);
	}

	public void setLocation(Location location) {
		stat.setLocation(location);
	}

	public Location getLocation(){
		return stat.getLocation();
	}
	
	public boolean move(Direction direction) {
		Location nextLocation = stat.getLocation().getNextLocation(direction);
		if (nextLocation != null) {
			stat.setLocation(nextLocation);
			return true;
		} else
			return false;
	}

	public String getName() {
		return stat.getName();
	}

	public void setHealt(int life) {
		stat.setHealt(life);
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

	public boolean npcIsThere(NPC npc) {
		return stat.getLocation().checkInList(npc);
		
	}

}
