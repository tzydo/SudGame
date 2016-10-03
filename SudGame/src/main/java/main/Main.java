package main;

import java.util.Scanner;

import main.Class.*;
import main.Class.commandParser.CommandParser;
import main.Class.location.addLocation;

public class Main {

	public static String command = "";
	private static Scanner ask;
	
	
	
	public static  String question(String question) {
		ask = new Scanner(System.in);
		System.out.println(question);
		String answer = ask.nextLine();
		return answer;
	}

	
	public static void main(String[] args) throws InterruptedException {

		CommandParser parser = new CommandParser();
		addLocation startLocation = new addLocation();

		String name = question("What's your name? :");
		System.out.println("Helo " + name);

		Player player = new Player(name, startLocation.getFirstLocation());
		System.out.println(player.getLocation().printDescription());

		// GAME LOOP

		while (!command.equals("zakoncz")) {
			command = question(">");
			parser.act(command, player);
		}

		System.out.println("Good Bye!");
		ask.close();
	}
}
