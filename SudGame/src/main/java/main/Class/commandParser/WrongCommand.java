package main.Class.commandParser;

public class WrongCommand implements Command {

	@Override
	public String execute() {
		return ("Wrong Command!");
	}

}
