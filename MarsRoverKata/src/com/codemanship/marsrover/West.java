package com.codemanship.marsrover;

class West implements Direction {

	@Override
	public String toString() {
		return "W";
	}

	@Override
	public void forward(Location location) {
		location.goWest();
	}

	@Override
	public void back(Location location) {
		location.goEast();
	}
}
