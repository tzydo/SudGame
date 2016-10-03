package main.Class.commandParser;

import main.Class.Player;
import main.Class.movements.Direction;

public class MoveCommand implements Command {

	private Direction direction;
	private Player player;
	

	public MoveCommand(Direction direction, Player player) {
		this.direction = direction;
		this.player = player;
	}
	

	public String move() {
		boolean travel = player.move(direction);
		if (!travel) {
			return("Wrong direction!");
		} else{
			return(direction.toString() + "\n" +player.getLocation().printDescription());
		}
			
	}

	@Override
	public String execute() {
		return move();
	}

}
