package main.Class;

import org.junit.Before;
import org.junit.Test;

import main.Class.fight.Fight;
import main.Class.location.Location;

public class FightTest {

	
	@Before
	public void beforeTest(){
		Location location = new Location("short","long");
		Player player = new Player("Destroyer",location );
		NPC npc = new NPC();
		Fight fight = new Fight(player,npc);
		fight.setFightSpeed(0);
	}
	
	
	@Test
	public void test() {
		
	}

}
