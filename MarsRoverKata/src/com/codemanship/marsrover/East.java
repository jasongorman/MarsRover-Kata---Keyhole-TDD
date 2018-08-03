package com.codemanship.marsrover;

class East implements Direction {

	@Override
	public String toString() {
		return "E";
	}

	@Override
	public void forward(Location location) {
		location.goEast();
	}

	@Override
	public void back(Location location) {
		location.goWest();
	}
}
