package main.Class.commandParser;

import main.Class.Player;
import main.Class.fight.FightStrategy;
import main.Class.fight.FightThread;
import main.Class.fight.strategy.AgilityFight;


public class KillCommand implements Command {

	private Player player;
	private String target;
	private static Thread thread;
	private FightStrategy strategy;
	public FightThread fightThread;

	public KillCommand(String target, Player player) {
		this.player = player;
		this.target = target;
		this.fightThread = new FightThread();
	}

	@Override
	public String execute() {
		return attack();
	}

	public String attack() {
		if (!player.getLocation().npcInNpcList(this.target))
			return ("incorrect enemy name !");
		else {
			// strategy = new ClassicFight();
			strategy = new AgilityFight();
			fightThread.setFightThread(player, player.getLocation().getNpc(this.target), strategy);

			thread = new Thread(fightThread);
			thread.start();
			return ("Start fight!");
		}
	}
}
