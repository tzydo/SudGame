package main.Class.fight;

import main.Class.Player;

public interface Combat{
	public void whoFirstAttack();

	public void setFighters(Player player, String command);

	public void stopFightAndRun();

	public Boolean nowIsFighting();

	public void setFightSpeed(int speed);
}
