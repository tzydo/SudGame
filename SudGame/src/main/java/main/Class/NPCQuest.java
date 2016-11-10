package main.Class;

import java.util.Random;

import main.Class.Statistic.Statistic;

public class NPCQuest extends NPC {
	private Statistic stat;
	private Random random = new Random();

	private String tab[] = { "Harun", "Bogdan", "Czeslaw", "Andrzej", "Kalkam" };

	private String descriptionList[] = { "is man who help you", "is waiting for you", "is blessing you" };

	public NPCQuest() {
		stat = new Statistic(choiceName(), choiceDescription());
	}

	private String choiceName() {
		String name = "NPC ";
		int x = random.nextInt(tab.length);
		name += tab[x];
		return name;
	}

	private String choiceDescription() {
		String desc = "";
		int x = random.nextInt(descriptionList.length);
		desc = descriptionList[x];
		return desc;
	}

	public String getName() {
		return stat.getName();
	}

	public String getDescription() {
		return stat.getDescription();
	}
}
