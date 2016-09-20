package main.Class.location;

import main.Class.movements.Direction;



public class addLocation {
	private Location firstLocation;
	private Location secondLocation;
	private Location thirdLocation;
	
	
	public addLocation(){
		firstLocation =  new Location("You are alone", " in smart room, what are you doing now? where you go? lets start the game !");
		secondLocation = new Location("", "ewerywhere you look is dark!");
		thirdLocation = new Location("SUN!","you are in desert, ewerywhere you look is sand");

		
		firstLocation.addExit(Direction.N, secondLocation);
		secondLocation.addExit(Direction.S, thirdLocation);
		thirdLocation.addExit(Direction.E, firstLocation);
	}
	
	
	public Location getFirstLocation(){
		return this.firstLocation;
	}
}
