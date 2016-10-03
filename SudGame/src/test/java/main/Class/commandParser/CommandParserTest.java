package main.Class.commandParser;

import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.Class.Player;
import main.Class.location.Location;
import main.Class.movements.Direction;

public class CommandParserTest {
	private Location first;
	private Location second;
	private CommandParser commandParsers;
	private CommandParser spyCommands;
	private Player player;	
	
	@Before
	public void initTest(){
		first = new Location("short", "long");
		second = new Location("second","long");
		first.addExit(Direction.N, second);
		
	
		player  = new Player("Destroyer", first);
		commandParsers = new CommandParser();
		
	}
	

	@Test
	public void actTest(){
		spyCommands = Mockito.spy(commandParsers);
		spyCommands.act("kill x x", player);
		Mockito.verify(spyCommands,times(1)).equals("incorrect enemy name !");
	}
		
	@Test
	public void actTest2(){
		spyCommands = Mockito.spy(commandParsers);
		spyCommands.act("n", player);
		Mockito.verify(spyCommands,times(1)).equals("north");
	}
		
	
}
