package main.Class.fight;

import main.Class.NPC;
import main.Class.Player;

public class FightThread implements Runnable {
	public Boolean stopFight = false;
	private Player player;
	private NPC npc;
	private int fightSpeed = 1000;
	private FightStrategy strategy;

	public void setFightThread(Player player, NPC npc, FightStrategy strategy) {
		this.player = player;
		this.npc = npc;
		this.strategy = strategy;
	}

	@Override
	public void run() {
		this.strategy.fight(this.player, this.npc, fightSpeed);
	}


	public void setFightSpeed(int speed) {
		this.fightSpeed = speed;
	}

}
