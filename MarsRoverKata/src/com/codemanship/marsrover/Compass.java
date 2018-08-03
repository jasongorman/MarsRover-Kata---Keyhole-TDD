package com.codemanship.marsrover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Compass {
	
	private List<Direction> directions;

	Compass() {
		this.directions = Arrays.asList(new Direction[]{new North(), new East(), new South(), new West()});
	}

	Direction selectDirection(String initDirection) {
		return directions.stream()		
			.filter(d -> d.toString().equals(initDirection))
			.findFirst()
			.get();
	}
	
	Direction right(Direction currentDirection) {
		return turn(currentDirection, directions);
	}

	Direction left(Direction currentDirection) {
		return turn(currentDirection, reverseDirections());
	}	

	private Direction turn(Direction currentDirection, List<Direction> directions) {
		int nextIndex = (directions.indexOf(currentDirection)+1) % directions.size(); // if final Direction in array, loop to first
		return directions.get(nextIndex);
	}

	private List<Direction> reverseDirections() {
		List<Direction> reverseDirections = new ArrayList<>(directions);
		Collections.copy(reverseDirections, directions);
		Collections.reverse(reverseDirections);
		return reverseDirections;
	}
}