package main.Class.commandParser;

import main.Class.Player;
import main.Class.Conversations.Conversation;
import main.Class.Conversations.ConversationWithHarun;


public class TalkWithNPCQuest implements Command{

	private String target;
	private Player player;
	private Conversation conversation;

	public TalkWithNPCQuest(String target, Player player) {
		this.target = target;
		this.player = player;
	}

	@Override
	public String execute() {
		return checkNPC();
	}

	private String checkNPC() {
		String back="";
		if (!this.player.getLocation().npcInNpcList(this.target)) {
			back = "wrong npc Quest name";
		} else {
			loadConwersation(this.target);
			back = "Good bye my friend";
		}

		return back;
	}

	private void loadConwersation(String name) {
		System.out.println(name);
		if (name.equals("NPC Harun")) {
			conversation = new ConversationWithHarun();
			conversation.talk();
			
		}
	}

}
