package main.Class.fight;

import main.Class.NPC;
import main.Class.Player;

public interface FightStrategy {
	public void fight(Player player, NPC npc, int fightSpeed);
}
