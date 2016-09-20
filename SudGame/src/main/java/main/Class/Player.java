package main.Class;
import java.util.Random;

import main.Class.location.*;
import main.Class.movements.Direction;


public class Player {

	private String name;
	public Location location;
	private int healt = 10000;
	private int strenght = 10;
	private Random random = new Random();
	
	
	
	
	
	public Player(String name, Location location){
		this.name = name;
		this.location = location;
	}
	
	
	
	public void setLocation(Location location ){
		this.location = location;
	}
		
	

	public boolean move(Direction direction){
		Location nextLocation = this.location.getNextLocation(direction);
		if(nextLocation!=null){
			this.location = nextLocation;
			
			return true;
		}
		else
			return false;
	}
	
	
	
	public String getName(){
		return this.name;
	}
	
	
	public void setLife(int life){
		this.healt = life;
	}
	
	
	public int getLife(){
		return this.healt;
	}



	public void attack(NPC npc) {
		int hit = random.nextInt(5);
		npc.hit(hit);
	}
	
	
	
	public void hit(int hit){
		this.healt -=hit;
		System.out.println(this.name + " loses : " + hit +" point life , his life :" +this.healt);
	}
	
}
