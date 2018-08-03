package com.codemanship.marsrover;

public class Rover {

	private Location location;
	private Direction direction;		
	private Compass compass;
	CommandProcessor commandProcessor;
	private final Output output;

	public Rover(int initX, int initY, String initDirection) {
		commandProcessor = new CommandProcessor(this);
		this.compass = new Compass();
		location = new Location(initX, initY);
		this.direction = compass.selectDirection(initDirection);
		output = new Output();
	}

	public Object[][] send(String commandSequence) {
		commandProcessor.execute(commandSequence);		
		return output.build(location.toArray(), direction.toString());
	}

	void left() {
		direction = compass.left(direction);
	}

	void right() {
		direction = compass.right(direction);
	}

	void back() {
		direction.back(location);
	}

	void forward() {
		direction.forward(location);
	}

}
