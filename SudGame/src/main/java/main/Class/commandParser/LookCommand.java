package main.Class.commandParser;

import main.Class.NPC;
import main.Class.Player;

public class LookCommand implements Command {

	private Player player;
	private NPC npc;
	private int number;
	private String target;

	public LookCommand(Player player) {
		this.player = player;
		number = 0;
	}

	public LookCommand(Player player, String target) {
		this.player = player;
		this.target = target;
		number = 1;
	}

	@Override
	public String execute() {
		String text = "";
		if (number == 0)
			text = player.getDescription();
		else {
			if (player.getLocation().npcInNpcList(target)) {
				npc = player.getLocation().getNpc(target);
				text += target + " " + npc.getDescription() +"\n";
			}
			if(player.getLocation().checkInItemList(target)){
				text += target + " " + player.getLocation().getItemDescription(target);
			}
			if(text == "")text = "Incorect npc name!";

		}

		return text;
	}

}
