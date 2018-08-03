package com.codemanship.marsrover;

class South implements Direction {

	@Override
	public String toString() {
		return "S";
	}

	@Override
	public void forward(Location location) {
		location.goSouth();
	}

	@Override
	public void back(Location location) {
		location.goNorth();
	}

}
