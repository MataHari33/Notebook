package edu.examples.java_classes.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class UpdateNoteCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		Note resNote;

		// validate request
		params = request.split("\n");
		resNote = new Note();

		resNote.setId(Integer.parseInt(params[1].split("=")[1]));
		resNote.setTitle(params[2].split("=")[1]);
		resNote.setContent(params[3].split("=")[1]);

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-mm-dd");
		Date date;
		try {
			date = format.parse(params[4].split("=")[1]);
			resNote.setD(date);

			logic.update(resNote);
			response = "Запись "+resNote.getContent()+" обновлена успешно.";
		} catch (ParseException e) {
			e.printStackTrace();
			response = "Error occured when updated message "+e.getMessage();
		}
		
		return response;
	}

}
