package com.codemanship.marsrover;

public class TestUtils {

	static Object direction(Object[][] response) {
		return response [1][0];
	}

	static Object[] location(Object[][] response) {
		return response [0];
	}

}
