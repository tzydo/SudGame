package main.Class.commandParser;

import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.Class.NPC;
import main.Class.Player;
import main.Class.location.Location;

public class KillCommandTest {
	private Player testPlayer;
	private String nameNPC;
	private Location firstLocation;
	private NPC npc;
	private KillCommand killingSpy;
	private KillCommand kill;	
	
	@Before
	public void initialize() {
		firstLocation = new Location();
		testPlayer = new Player("Tester", firstLocation);
		testPlayer.setLocation(firstLocation);
		
	}

	

	@Test
	public void happyAttackTest() {
		npc = new NPC();
		nameNPC = npc.getName();
		testPlayer.getLocation().addNpc(npc);
		
		kill = new KillCommand(nameNPC, testPlayer);
		killingSpy = Mockito.spy(kill);

		killingSpy.execute();
		Mockito.verify(killingSpy, times(1)).equals("Start fight!");

	}
	
	
	@Test
	public void attackTest() {
		kill = new KillCommand("y y", testPlayer);
		killingSpy = Mockito.spy(kill);

		killingSpy.execute();
		Mockito.verify(killingSpy, times(1)).equals("incorrect enemy name !");
	}

}
