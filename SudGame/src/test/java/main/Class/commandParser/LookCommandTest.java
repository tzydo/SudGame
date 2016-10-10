package main.Class.commandParser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.Class.NPC;
import main.Class.Player;
import main.Class.location.Location;

public class LookCommandTest {

	private Player playerTest;
	private Location firstLocation;
	private NPC npcTest;
	
	
	@Before
	public void initialize(){
		firstLocation = new Location("short","long");
		playerTest = new Player("Tester",firstLocation);
		
	}
	
	
	@Test
	public void lookCommandTest(){
		npcTest = new NPC();
		LookCommand look = new LookCommand(playerTest);
		LookCommand spy = Mockito.spy(look);
		
		spy.execute();
		Mockito.verify(spy,Mockito.times(1)).equals("short, long");
	}
	
	@Test
	public void lookCommandNPCDescriptionTest(){
		npcTest = new NPC();
		playerTest.getLocation().addNpc(npcTest);
		String name = npcTest.getName();
		npcTest.setDescription("is very bad gay!");
		LookCommand look1 = new LookCommand(playerTest, name);
		
		assertEquals(name + " is very bad gay!\n",look1.execute());
	}
	
	@Test
	public void lookCommandItemDescriptionTest(){
		playerTest.getLocation().addItem("dab", "przeszkodzil Ci w podrozy !");
		LookCommand look1 = new LookCommand(playerTest, "dab");

		assertEquals("dab przeszkodzil Ci w podrozy !", look1.execute());
	}
	
	
	@Test
	public void lookCommandItemAndNPCDescriptionTest(){
		playerTest.getLocation().addItem("ogromny dab", "przeszkodzil Ci w podrozy !");
		npcTest = new NPC();
		npcTest.setName("ogromny dab");
		npcTest.setDescription("to straszny mutant");
		playerTest.getLocation().addNpc(npcTest);
		
		LookCommand look1 = new LookCommand(playerTest, "ogromny dab");
		
		assertEquals("ogromny dab to straszny mutant\nogromny dab przeszkodzil Ci w podrozy !", look1.execute());
	}
	
	
}
