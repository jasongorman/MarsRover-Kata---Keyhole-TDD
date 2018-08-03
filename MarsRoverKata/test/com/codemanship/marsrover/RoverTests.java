package com.codemanship.marsrover;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@RunWith(JUnitParamsRunner.class)
public class RoverTests {

	private static int X = 0;
	private static int Y = 1;

	@Test
	public void initialisedWithLocation() {
		Rover rover = new Rover(1,2,"N");
		Object[][] response = rover.send("");
		assertThat(location(response)[X], is(1));
		assertThat(location(response)[Y], is(2));
	}
	
	@Test
	public void initialisedWithDirection() {
		Rover rover = new Rover(0,0,"N");
		Object[][] response = rover .send("");
		assertThat(direction(response), is("N"));
	}

	@Test
	@Parameters({"N,0,1", "E,1,0", "S,0,-1", "W,-1,0"})
	public void movesForwardOneInDirectionIsFacing(String direction, int finalX, int finalY) {
		Rover rover = new Rover(0,0,direction);
		Object[][] response = rover .send("F");
		assertThat(location(response)[X], is(finalX));
		assertThat(location(response)[Y], is(finalY));
	}
	
	@Test
	@Parameters({"N,0,-1", "E,-1,0", "S,0,1", "W,1,0"})
	public void movesBackOneInOppositeDirection(String direction, int finalX, int finalY) {
		Rover rover = new Rover(0,0,direction);
		Object[][] response = rover .send("B");
		assertThat(location(response )[X], is(finalX));
		assertThat(location(response)[Y], is(finalY));
	}
	
	@Test
	@Parameters({"N,E", "E,S", "S,W", "W,N"})
	public void turnsRightClockwise(String startDirection, String finalDirection) {
		Rover rover = new Rover(0,0,startDirection);
		Object[][] response = rover .send("R");
		assertThat(direction(response ), is(finalDirection));
	}
	
	@Test
	@Parameters({"N,W", "W,S", "S,E", "E,N"})
	public void turnsLeftAnticlockwise(String startDirection, String finalDirection) {
		Rover rover = new Rover(0,0,startDirection);
		Object[][] response = rover .send("L");
		assertThat(direction(response ), is(finalDirection));
	}
	
	@Test
	public void executesSequenceOfCommands() {
		Rover rover = new Rover(0,0,"N");
		Object[][] response = rover .send("FFRFFLBRF");
		assertThat(location(response )[X], is(3));
		assertThat(location(response )[Y], is(1));
		assertThat(direction(response), is("E"));
	}
	
	private Object direction(Object[][] response) {
		return response [1][0];
	}
	
	private Object[] location(Object[][] response) {
		return response [0];
	}

}
