package main.Class.commands;

import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.Class.Player;
import main.Class.commands.Command;
import main.Class.location.Location;
import main.Class.movements.Direction;



public class CommandsTest {

	private Location first;
	private Location second;
	private Command commands;
	private Command spyCommands;
	private Player player;	
	
	@Before
	public void initTest(){
		first = new Location("short", "long");
		second = new Location("second","long");
		first.addExit(Direction.N, second);
		
	
		player  = new Player("Destroyer", first);
		commands = new Command();
		spyCommands = Mockito.spy(commands);
	}
	
	
	@Test
	public void actTest() throws InterruptedException{
		spyCommands.act("north", player);
		Mockito.verify(spyCommands,times(1)).nowIsFighting(Direction.N, player);
	}
	
	
	@Test
	public void actTest1() throws InterruptedException{
		spyCommands.act("kill Joe M", player);
		Mockito.verify(spyCommands, times(1)).fight("Joe M", player);;
	}
	
	
	@Test 
	public void nowIsFightingTest() throws InterruptedException{
		spyCommands.nowIsFighting(Direction.N, player);
		Mockito.verify(spyCommands, times(1)).move(Direction.N, player);
	}
	
}
	
		
	
