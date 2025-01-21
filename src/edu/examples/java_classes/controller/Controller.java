package edu.examples.java_classes.controller;

public class Controller {
	private final char paramDelimeter = '\n';
	
	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request) {

		
		String commandName;
		Command executionCommand;
		
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = provider.getCommand(commandName.toUpperCase());//ADD
		
		String response;
		response = executionCommand.execute(request);
		
		return response;

	}

}


