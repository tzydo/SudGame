package main.Class.location;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;

import main.Class.NPC;
import main.Class.movements.Direction;

public class LocationTest {
	private Location location ;
	private Location l1;
	private Location l2;
	
	@Before
	public void initTest(){
		location = new Location();
		l1 = new Location("short1","long1");
		l2 = new Location("short2","long2");
		Location l3 = new Location("short3","long3");
		Location l4 = new Location("short4","long4");
		Location l5 = new Location("short5","long5");
		
		
		location.addExit(Direction.N, l1);
		location.addExit(Direction.W, l2);
		location.addExit(Direction.S, l3);
		location.addExit(Direction.E, l4);
		location.addExit(Direction.N, l5);
	}
	
	
	@Test
	public void exitMapSizeTest() {
		assertThat(location.exit.size(),is(4));
	}
	
	@Test
	public void exitMapIskeyTest(){
		assertThat(location.exit, IsMapContaining.hasKey(Direction.N));
	}
	
	@Test
	public void getExitTest(){
		assertNotNull(location.getExitString());
	}
	
	
	@Test
	public void npcInNpcListTest(){
		NPC npc = new NPC();
		String name = npc.getName();
		location.addNpc(npc);
		assertTrue(location.npcInNpcList(name));
	}
	
	
	
	@Test
	public void getNpcTest(){
		NPC npc = new NPC();
		String name = npc.getName();
		location.addNpc(npc);
		
		assertEquals("the same", npc, location.getNpc(name));
	}
}
