package main.Class;
import java.util.Random;

import main.Main;


public class Fight implements Runnable {
	public Boolean stopFight = false;
	private Player player;
	private NPC npc;
	private Random random = new Random();
	private int whoAttack = 0;

	
	
	/*public Fight(Player player , NPC npc) {
		this.player = player;
		this.npc = npc;
	};
*/

	
	public Fight(){};
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("START FIGHT ! \n " + player.getName() + " VS " + npc.getName());
		whoFirstAttack();
		while(!stopFight){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(whoAttack == 0){
				player.attack(npc);
				npc.attack(player);
			}
			else{
				npc.attack(player);
				player.attack(npc);
			}
			
			
			
			if(player.getLife()<=0){
				System.out.println("Winner Fight is "+ npc.getName() + "You loose!");
				stopFight = true;
				Main.command="zakoncz";
			}
			if(npc.getLife()<=0){
				System.out.println("Winner Fight is "+ player.getName());
				stopFight = true;
				player.location.printDescription();
			}
		
		}
	
	}
	
	
	
	private void whoFirstAttack() {
		// TODO Auto-generated method stub
		whoAttack = random.nextInt(2);
		System.out.println(whoAttack);
	}


	public void setFighters(Player player, String command){
		this.player = player;
		this.npc = player.location.getNpc(command);
		
	}
	
	
	public void stopFightAndRun(){
		System.out.println("You are crying like BITCH!");
		this.stopFight = true;
	}
	
	
	
	public Boolean nowIsFighting(){
		return this.stopFight;
	}

}
