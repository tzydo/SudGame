package main.Class;
import java.util.HashMap;
import java.util.Map;


public class Location {

	private String shortDesc;
	private String longDesc;
	private Map<Direction,Location> exit = new HashMap<>();
	private Map<NPC,Integer>npcList = new HashMap<>();
	
	
	
	public Location(){
		this.shortDesc = "short Description";
		this.longDesc = "long Description";
	}
	
	
	
	
	public Location(String shortDesc, String longDesc){
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
	}
	
	
	
	
	public void printDescription(){
		npcList.clear();
		generateList();
		System.out.println ( this.shortDesc	+ this.longDesc + "\n " + getExitString());
		showEnemys();
	}
	
	
	
	
	public void addExit(Direction w , Location l){
		exit.put(w, l);
	}
	
	
	
	public Location getNextLocation(Direction direction){
		boolean exist = this.exit.containsKey(direction);
		if(exist){
			return this.exit.get(direction);
		}else{
			return null;
		}
		
	}
	
	
	
	public String getExitString(){
	String ex = "";
		for (Direction direction : exit.keySet()){
			ex += direction.getDirectionDesc()	 + " ";
		}
		
		return (" Visible exits : "+ ex );
	}
	
	
	
	public void generateList(){
		for (int i = 0; i < 5; i++) {
			NPC a = new NPC();
			npcList.put(a,i);
		}
	}

	
	
	public void showEnemys(){
		System.out.println("Enemys in this place : \n");
		String enemys = "";
		for(NPC npc: npcList.keySet()){
			enemys += npc.showNPC() + ", ";
		}
		
		System.out.println(enemys);
	}
	
	
	
	
	public Boolean npcInNpcList(String command){
		Boolean ret = false;
		for (NPC npc : npcList.keySet()){
			if(npc.getName().equals(command)) ret = true;
		}
		return ret;
	}
	
	
	public NPC getNpc(String nameNpc){
		for(NPC npc : npcList.keySet()){
			if(npc.getName().equals(nameNpc))return npc;
		}
		return null;		
	}
	
	
	
	public void deleteNPC(NPC npc){
			npcList.remove(npc);

	}
	/*
	public static void main(String[]Args){
		Location n = new Location();
		n.generateList();
		n.showEnemys();
	}
*/}
