package main.Class.fight.strategy;

import java.util.Random;

import main.Class.NPC;
import main.Class.Player;
import main.Class.fight.FightStrategy;

public class AgilityFight implements FightStrategy {
	private int hit;
	private Random random;

	public void fight(Player player, NPC npc, int speed) {

		while (player.isLive() && npc.isLive()) {

			if (!player.npcIsThere(npc)) {
				System.out.println("Cry like a bitch and run!");
				return;
			}

			try {
				Thread.sleep(speed);
				if (calculateHit(player.getAgility(), npc.getAgility())) {
					checkHit(player.getStrenth());
					npc.getHit(hit);
					showMessage(player.getName(), npc.getName(), hit);
				} else
					System.out.println("You missed!");

			} catch (InterruptedException e) {
				System.out.println("cos sie zjebalo w walce");
			}

			try {
				Thread.sleep(speed);
				if (calculateHit(npc.getAgility(), player.getAgility())) {
					checkHit(npc.getStrenth());
					player.getHit(hit);
					showMessage(npc.getName(), player.getName(), hit);
				} else
					System.out.println(npc.getName()+" missed!");
			} catch (InterruptedException e) {
				System.out.println("cos sie zjebalo w walce");
			}
		}

		if (player.isLive() && !npc.isLive()) {
			System.out.println("You are winner!");
		} else if ((!player.isLive() && npc.isLive())) {
			System.out.println("You are looser try agen in next time");
		}
	}

	private boolean calculateHit(int agility, int agility2) {
		random = new Random();
		int rand;
		Boolean shield = true;
		if(agility2 > agility){
			rand = random.nextInt(4);
			if(rand == 3 )shield = false;
		}else{
			rand = random.nextInt(10);
			if(rand == 10)shield = false;
		}
		
		return shield;
		//return ((agility + random.nextInt(20)) > agility2);
	}

	private void showMessage(String name, String name2, int hit2) {
		System.out.println(name + " hit " + name2 + " for " + hit + " damage.");
	}

	private void checkHit(int strenth) {

		random = new Random();
		hit = strenth * random.nextInt(4);

	}

}
