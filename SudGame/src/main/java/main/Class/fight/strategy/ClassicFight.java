package main.Class.fight.strategy;

import java.util.Random;

import main.Class.NPC;
import main.Class.Player;
import main.Class.fight.FightStrategy;

public class ClassicFight implements FightStrategy{

	private int hit;
	private Random random = new Random();
	
	
	public void fight(Player player, NPC npc, int fightSpeed) {

		while (player.isLive() && npc.isLive()) {
			
			if(!player.npcIsThere(npc)){
				System.out.println("Cry like a bitch and run!");
				return;
			}
			
			try {
				Thread.sleep(fightSpeed);
				hit = checkHit(player.getStrenth());
				npc.getHit(hit);
				showMessage(player.getName(),npc.getName(),hit);
			} catch (InterruptedException e) {
				System.out.println("cos sie zjebalo w walce");
			}
			
			
			try {
				Thread.sleep(fightSpeed);
				hit = checkHit(npc.getStrenth());
				player.getHit(hit);
				showMessage(npc.getName(),player.getName(),hit);
			} catch (InterruptedException e) {
				System.out.println("cos sie zjebalo w walce");
			}
			}
		
		if(player.isLive() && !npc.isLive()) {
            System.out.println("You are victorious!");
        } else if((!player.isLive() && npc.isLive())) {
            System.out.println("Try harder next time");
		}
	}
	private void showMessage(String name, String name2, int hit2) {
		System.out.println(name + " hit " + name2 + " for " + hit + " damage.");		
	}


	private int checkHit(int strenth) {
		int hitPower = 0;
		
		hitPower = strenth * random.nextInt(4);
		
		return hitPower;
	}

}