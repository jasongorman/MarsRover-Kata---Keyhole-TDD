package com.codemanship.marsrover;

import java.util.HashMap;
import java.util.Map;

class CommandProcessor {
	
	private Map<Character, Runnable> commands = new HashMap<>();

	public CommandProcessor(Rover rover) {
		commands.put('F', rover::forward);
		commands.put('B', rover::back);
		commands.put('R', rover::right);
		commands.put('L', rover::left);
	}

	void execute(String commandSequence) {
		execute(parse(commandSequence));
	}
	
	private void execute(char[] commandArray) {
		for (char command : commandArray) {
			commands.get(command).run();
		}
	}
	
	private char[] parse(String commandSequence) {
		return commandSequence.toCharArray();
	}
}