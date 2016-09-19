package main.Class;
import java.util.Random;;


public class NPC {

	private String name;
	private int healt = 100;
	private int strenth;
	private String level ="";
	
	
	private String[] tab = { "Dexter Taylor", "Jordan Watson", "Brandon Miller", "Noah Clarke", "Joel Russell",
			"Walker Paul", "Luciano Meyers", "Jasiah Mccoy", "Francisco Barber", "Dylan Knight", "Christopher Fox",
			"Jordan Henderson", "Frankie Holland", "Jonathan Price", "Isaias Valencia", "Brody Wilson",
			"Mustafa Holman", "Yael Mckinney", "Royce Duran", "Joel Khan", "Rhys Hawkins", "Brandon Armstrong",
			"Luca Kaur", "Dexter Wilson", "Izayah Pickett", "August Long", "Marvin Richardson", "Jackson Palmer",
			"Mauricio York", "Ollie Parry", "Gabriel Parry", "Alfie Parker", "Jacob King", "Sebastian Mitchell",
			"Kian Christensen", "Richard Espinoza", "Mayson Castaneda", "Zachariah Lynch", "Malcolm Macdonald",
			"Augustus Flores" };
	private Random random = new Random();

	
	
	public NPC() {
		setName();
		setStrenght();
		setLevel();
		showNPC();
	}
	
	
	
	private void setLevel() {
		if(this.strenth>30 && this.strenth <=40)this.level = "Extremal";
		if(this.strenth>20 && this.strenth <=30)this.level = "Hard";
		if(this.strenth>10 && this.strenth <=20)this.level = "Medium";
		if(this.strenth>=0 && this.strenth <=10)this.level = "Eazy";
	}



	private void setStrenght() {
		int strenth = random.nextInt(40);
		this.strenth = strenth;
	}



	private void setName(){
		int nr = random.nextInt(tab.length);
		this.name = tab[nr];
	}
	
	
	
	public String showNPC(){
		return(this.name +"("+ this.level + ")");
	}
	
	
	
	public String getName(){
		return this.name;	
	}
	
	
	
	public void setLife(int life){
		this.healt = life;
	}
	
	
	public int getLife(){
		return this.healt;
	}
	
	
	
	public void attack(Player player){
		int hit = random.nextInt(5);
		player.hit(hit);
	}



	public void hit(int hit) {
		this.healt -= hit;
		System.out.println(this.name + " loses : " + hit +" point life , his life :" +this.healt);
	}
}