package main.Class.commandParser;

import main.Class.Player;
import main.Class.movements.Direction;


public class CommandParser {

	public void act(String target, Player player){
		target.toLowerCase();
		
		Command command = null;
		
		String[] pom = target.split(" ");
		if(pom.length ==3)target = pom[1]+" "+ pom[2];
		
		
		switch (pom[0]) {
		case "kill":
			command = new KillCommand(target, player );
			break;
			
		case "look":
			if(pom.length != 1)command = new LookCommand(player, target);
			else
				command = new LookCommand(player);
			break;
		case "n":
		case "N":
		case "north":
		case "North":
			command = new MoveCommand(Direction.N, player);
			break;

		case "s":
		case "S":
		case "south":
		case "South":
			command = new MoveCommand(Direction.S, player);
			break;

		case "e":
		case "E":
		case "east":
		case "East":
			command = new MoveCommand(Direction.E, player);
			break;

		case "w":
		case "W":
		case "west":
		case "West":
			command = new MoveCommand(Direction.W, player);
			break;

		default:
			command = new WrongCommand();
			break;
		}
		
		System.out.println(command.execute());
	}
}
