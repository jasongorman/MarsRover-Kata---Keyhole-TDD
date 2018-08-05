package com.codemanship.marsrover;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;

import static com.codemanship.marsrover.TestUtils.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class MarsRoverRandomTests {

	private final String[] commands = new String[] {"F", "B", "L", "R"};
	private static String[] compass = new String[] {"N","E","S","W"};
	private final String[] compassLeft = new String[] {"W","N","E","S"};
	private final String[] compassRight = new String[] {"E","S","W","N"};
	private final int[][] vectors = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
	private int initX;
	private int initY;
	private String initDirection;
	private String commandSequence;
	private int x;
	private int y;
	private String direction;

	@Test
	@Parameters
	public void randomCommandSequence(int initX, int initY, String initDirection, String commandSequence, int endX, int endY, String endDirection) {
		Rover rover = new Rover(initX, initY, initDirection);
		Object[][] response = rover .send(commandSequence);
		assertThat(location(response)[0], is(endX));
		assertThat(location(response)[1], is(endY));
		assertThat(direction(response), is(endDirection));
	}
	
	private Object[] parametersForRandomCommandSequence() {		
		return generateTestCases().toArray();
	}

	private List<Object[]> generateTestCases() {
		List<Object[]> testCases = new ArrayList<Object[]>();
		for(int i = 0;i < 1000;i++) {
			int sequenceLength = initialiseSequence();			
			initialiseRover();						
			generateSequence(sequenceLength);			
			testCases.add(new Object[] {initX,initY,initDirection,commandSequence,x,y,direction});
		}
		return testCases;
	}

	private int initialiseSequence() {
		int sequenceLength = randomInteger(100);			
		commandSequence = "";
		return sequenceLength;
	}

	private void initialiseRover() {
		initX = randomInteger(10);
		initY = randomInteger(10);
		initDirection = compass[randomInteger(4)];
	}

	private void generateSequence(int sequenceLength) {
		x = initX;
		y = initY;
		direction = initDirection;
		for(int j = 0;j < sequenceLength;j++) {
			String command = randomCommand();
			int directionIndex = Arrays.asList(compass).indexOf(direction);
			int[] vector = vectors[directionIndex];
			evaluateCommand(command, directionIndex, vector);
			commandSequence += command;
		}
	}

	private String randomCommand() {
		return commands[randomInteger(4)];
	}

	private void evaluateCommand(String command, int directionIndex, int[] vector) {
		forward(command, vector);
		backward(command, vector);
		left(command, directionIndex);
		right(command, directionIndex);
	}

	private void right(String command, int directionIndex) {
		if(command.equals("R")) {
			direction = compassRight[directionIndex];
		}
	}

	private void left(String command, int directionIndex) {
		if(command.equals("L")) {
			direction = compassLeft[directionIndex];
		}
	}

	private void backward(String command, int[] vector) {
		if(command.equals("B")) {
			x -= vector[0];
			y -= vector[1];
		}
	}

	private void forward(String command, int[] vector) {
		if(command.equals("F")) {
			x += vector[0];
			y += vector[1];
		}
	}

	private int randomInteger(int max) {
		return (int) Math.floor(Math.random()*max);
	}
}
