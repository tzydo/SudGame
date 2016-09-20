package main.Class.fight;

import java.util.Random;

import main.Main;
import main.Class.NPC;
import main.Class.Player;

public class Fight implements Runnable, Combat {
	public Boolean stopFight = false;
	private Player player;
	private NPC npc;
	private Random random = new Random();
	private int whoAttack = 0;
	private int fightSpeed = 1000;

	public Fight() {
	};

	public Fight(Player player, NPC npc) {
		this.player = player;
		this.npc = npc;
	}

	@Override
	public void run() {
		System.out.println("START FIGHT ! \n " + player.getName() + " VS " + npc.getName());
		whoFirstAttack();
		while (!stopFight) {
			try {
				Thread.sleep(fightSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (whoAttack == 0) {
				player.attack(npc);
				npc.attack(player);
			} else {
				npc.attack(player);
				player.attack(npc);
			}

			if (player.getLife() <= 0) {
				System.out.println("Winner Fight is " + npc.getName() + "You loose!");
				stopFight = true;
				Main.command = "zakoncz";
			}
			if (npc.getLife() <= 0) {
				System.out.println("Winner Fight is " + player.getName());
				stopFight = true;
				player.location.printDescription();
			}

		}

	}

	public void stopFightAndRun() {
		System.out.println("You are crying like BITCH!");
		this.stopFight = true;
	}

	@Override
	public void whoFirstAttack() {
		// TODO Auto-generated method stub
		whoAttack = random.nextInt(2);
		System.out.println(whoAttack);
	}

	@Override
	public void setFighters(Player player, String command) {
		// TODO Auto-generated method stub
		this.player = player;
		this.npc = player.location.getNpc(command);
	}

	@Override
	public Boolean nowIsFighting() {
		// TODO Auto-generated method stub
		return this.stopFight;
	}

	@Override
	public void setFightSpeed(int speed) {
		// TODO Auto-generated method stub
		this.fightSpeed = speed;
	}

}
