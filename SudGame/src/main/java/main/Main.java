package main;
import java.util.Scanner;

import main.Class.*;

public class Main{
	
	
	private static Fight fight ;
	private static Thread thread;
	public static String command="";
	

	//<----------------------------------------QUESTION METHOD ----------------------------------------------->
	private static String question(String question) {
		String answer = null;
		Scanner ask = new Scanner(System.in);
		System.out.println(question);
		answer = ask.nextLine();
		return answer;
	}

	
	
	
	
	
	//<---------------------------------------CHOICE DIRECTION OF MOVEMENTS OR KILL ENEMY------------------------------------->
	private static void act(String command , Player player){

		String[] pom = command.split(" ");
		
		if(pom.length !=1){
			command = pom[1]+ " " + pom[2];
			System.out.println(command);
			fight = new Fight();
			fight(command , player);
			
		}else{	
		
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
	
	
	
	
	public static void nowIsFighting(Direction direction , Player player){
		Boolean isFight = true;
		try{
		 isFight= fight.nowIsFighting();
		}catch(Exception ex){
			
		}
		if(isFight.equals(false)){
			fight.stopFightAndRun();
			move(direction,player);
		}else{
			move(direction,player);
		}
	}
	
	
	
	
	public static void fight(String command , Player player){
		if(player.location.npcInNpcList(command)){
			//fight = new Fight(player,null);
			fight.setFighters(player,command);
			thread = new Thread(fight);
			thread.start();	
		}else
			System.out.println("incorrect enemy name !");
	}
	
	
	
	
	
	//<--------------------------------------------------MOVEMENTS---------------------------------->
	public static void move(Direction direction, Player player){
		boolean travel = player.move(direction);
		if(travel){
			System.out.println(direction.getDirectionDesc());
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			player.location.printDescription();
		}else
			System.out.println("Wrong direction!");
	}

	
	
	
	
	
	
	//<-------------------------------------------------MAIN-------------------------------->>
	public static void main(String[] args) {
		String name = question("What's your name? :");
		System.out.println("Helo "+ name);
		
		
		Location firstLocation = new Location("You are alone", " in smart room, what are you doing now? where you go? lets start the game !");
		Location secondLocation = new Location("", "ewerywhere you look is dark!");
		Location thirdLocation = new Location("SUN!","you are in desert, ewerywhere you look is sand");

		
		firstLocation.addExit(Direction.N, secondLocation);
		secondLocation.addExit(Direction.S, thirdLocation);
		thirdLocation.addExit(Direction.E, firstLocation);
		
		
		Player player = new Player(name, firstLocation);
		player.location.printDescription();
		
		
		
		//GAME LOOP
		
		while(command!= "zakoncz"){
			command = question(">");
			act(command,player);
		}
		
		
		System.out.println("Good Bye!");
	}
}
