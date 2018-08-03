package com.codemanship.marsrover;

class Location {
	
	public int x;
	public int y;

	Location(int initX, int initY) {
		x = initX;
		y = initY;
	}

	void goNorth() {
		y++;
	}

	void goEast() {
		x++;
	}

	void goSouth() {
		y--;
	}

	void goWest() {
		x--;
	}

	Object[] toArray() {
		return new Object []{x,y};
	}
}