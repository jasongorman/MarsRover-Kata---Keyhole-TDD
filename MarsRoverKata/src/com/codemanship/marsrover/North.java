package com.codemanship.marsrover;

class North implements Direction {

	@Override
	public String toString() {
		return "N";
	}

	@Override
	public void forward(Location location) {
		location.goNorth();
	}

	@Override
	public void back(Location location) {
		location.goSouth();
	}

}
