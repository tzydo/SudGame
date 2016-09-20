package main.Class.commands;

import main.Class.Player;
import main.Class.fight.Fight;
import main.Class.movements.Direction;

//CHOICE DIRECTION OF MOVEMENTS OR KILL ENEMY
public class Command {

	
	public Fight fight;
	private static Thread thread;
	
	
	
	public Command(){}

	
	
	public void act(String command, Player player) throws InterruptedException {

		String[] pom = command.split(" ");

		if (pom.length != 1) {
			command = pom[1] + " " + pom[2];
			System.out.println(command);
			fight = new Fight();
			fight(command, player);

		} else {

			switch (command) {
			case "n":
			case "N":
			case "north":
			case "North":
				nowIsFighting(Direction.N, player);
				break;

			case "s":
			case "S":
			case "south":
			case "South":
				nowIsFighting(Direction.S, player);
				break;

			case "e":
			case "E":
			case "east":
			case "East":
				nowIsFighting(Direction.E, player);
				break;

			case "w":
			case "W":
			case "west":
			case "West":
				nowIsFighting(Direction.W, player);
				break;

			default:
				System.out.println("Wrong command !");
				break;
			}
		}
	}

	
	
	
	public  void nowIsFighting(Direction direction, Player player) throws InterruptedException {
		Boolean isFight = true;
			isFight = fight.nowIsFighting();
		if (isFight.equals(false)) {
			fight.stopFightAndRun();
			move(direction, player);
		} else {
			move(direction, player);
		}
	}

	
	
	public void fight(String command, Player player) {
		if (player.location.npcInNpcList(command)) {
			// fight = new Fight(player,null);
			fight.setFighters(player, command);
			thread = new Thread(fight);
			thread.start();
		} else
			System.out.println("incorrect enemy name !");
	}

	
	
	// MOVEMENTS
	public void move(Direction direction, Player player) throws InterruptedException {
		boolean travel = player.move(direction);
		if (travel) {
			System.out.println(direction.toString());
			Thread.sleep(400);
			player.location.printDescription();
		} else
			System.out.println("Wrong direction!");
	}
}
