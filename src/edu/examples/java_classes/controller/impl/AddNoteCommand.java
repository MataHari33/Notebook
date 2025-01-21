package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class AddNoteCommand implements Command {
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		Note newNote;

		// validate request
		params = request.split("\n");
		newNote = new Note();
		newNote.setTitle(params[1].split("=")[1]);
		newNote.setContent(params[2].split("=")[1]);
	try {
		logic.add(newNote);
		response = "Запись "+ newNote.getContent()+" сохранена успешно.";
	} catch (Exception e) {
		e.printStackTrace();
		return "Error occured when added a note " + e.getMessage();
	}
		return response;
	}

}
