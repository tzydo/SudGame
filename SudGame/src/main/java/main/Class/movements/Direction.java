package main.Class.movements;

public enum Direction {
	
	N("north"),S("south"),E("east"),W("weast");
	
	
	private String directionDesciption;

	
	
	private Direction(String directionDesciption) {
		this.directionDesciption = directionDesciption;
	}
	
	
	public String toString(){
		return directionDesciption;
	}
	
}
