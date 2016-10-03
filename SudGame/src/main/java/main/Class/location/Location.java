package main.Class.location;

import java.util.HashMap;
import java.util.Map;
import com.google.common.base.Joiner;
import main.Class.NPC;
import main.Class.movements.*;

public class Location {

	private String shortDesc;
	private String longDesc;
	Map<Direction, Location> exit = new HashMap<>();
	private static Map<NPC, Integer> npcList = new HashMap<>();

	public Location() {
		this.shortDesc = "short Description";
		this.longDesc = "long Description";
	}

	public Location(String shortDesc, String longDesc) {
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
	}

	public String printDescription() {
		npcList.clear();
		generateList();
		return(this.shortDesc + this.longDesc + "\n " + getExitString() + "\n" +showEnemys());
	}

	public void addExit(Direction w, Location l) {
		exit.put(w, l);
	}

	public Location getNextLocation(Direction direction) {
		boolean exist = this.exit.containsKey(direction);
		if (exist) {
			return this.exit.get(direction);
		} else {
			return null;
		}

	}

	public String getExitString() {
		String ex = Joiner.on(", ").join(exit.keySet());
		return (" Visible exits : " + ex);
	}

	public void generateList() {
		for (int i = 0; i < 5; i++) {
			NPC a = new NPC();
			npcList.put(a, i);
		}
	}

	public String showEnemys() {
		String enemys = Joiner.on(", ").join(npcList.keySet());
		return("Enemys in this place : \n" + enemys);
	}

	public Boolean npcInNpcList(String command) {
		Boolean ret = false;
		for (NPC npc : npcList.keySet()) {
			if (npc.getName().equals(command))
				ret = true;
		}
		return ret;
	}

	public NPC getNpc(String nameNpc) {
		for (NPC npc : npcList.keySet()) {
			if (npc.getName().equals(nameNpc))
				return npc;
		}
		return null;
	}

	public void deleteNPC(NPC npc) {
		npcList.remove(npc);
	}
	
	
	public void addNpc(NPC npc){
		npcList.put(npc,npcList.size()+1);
	}

	public Boolean checkInList(NPC npc) {
		return npcList.containsKey(npc);		
	}
}
