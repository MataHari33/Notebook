package edu.examples.java_classes.dao;

import java.util.List;
import edu.examples.java_classes.entity.Note;

public interface NoteBookDao {

	List<Note> save(Note n) throws DaoException;

	List<Note> allNotes() throws DaoException;

}
