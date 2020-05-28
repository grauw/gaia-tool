package nl.grauw.gaia;

import static org.junit.Assert.*;

import nl.grauw.gaia.Note;
import nl.grauw.gaia.Note.NoteName;

import org.junit.Test;

public class NoteTest {

	@Test
	public void testGetNote() {
		Note note = new Note(60);
		assertEquals(NoteName.C, note.getNote());
		assertEquals(4, note.getOctave());
	}

	@Test
	public void testGetOctave() {
		Note note = new Note(60);
		assertEquals(4, note.getOctave());
	}

	@Test
	public void testGetNoteNumber() {
		Note note = new Note(NoteName.C, 4);
		assertEquals(60, note.getNoteNumber());
	}

}
