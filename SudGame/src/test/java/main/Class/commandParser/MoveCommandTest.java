package main.Class.commandParser;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.Class.Player;
import main.Class.location.Location;
import main.Class.movements.Direction;

public class MoveCommandTest {

	private Player playerTester;
	private Location firstLocation;

	@Before
	public void initialize() {
		firstLocation = new Location();
		playerTester = new Player("Test", firstLocation);
		
	}
	
	
	@Test
	public void moveTest(){
		MoveCommand mComand = new MoveCommand(Direction.E, playerTester);
		MoveCommand mComandSpy = Mockito.spy(mComand);
				
		mComandSpy.execute();
		Mockito.verify(mComandSpy, times(1)).equals("Wrong direction!");
	}
	
	
	@Test
	public void moveTest1(){
		MoveCommand mComand = new MoveCommand(Direction.N, playerTester);
		MoveCommand mComandSpy = Mockito.spy(mComand);
			
		mComandSpy.execute();
		Mockito.verify(mComandSpy, times(1)).equals("north");
	}
}
