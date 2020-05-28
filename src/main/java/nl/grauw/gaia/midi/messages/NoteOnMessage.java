package nl.grauw.gaia.midi.messages;

import nl.grauw.gaia.Note;

public class NoteOnMessage extends ChannelMessage {
	
	public NoteOnMessage(byte[] message) {
		super(message);
	}
	
	public NoteOnMessage(int channel, Note note, int velocity) {
		super(NOTE_ON, channel, note.getNoteNumber(), velocity);
	}
	
	public Note getNote() {
		return new Note(getData(0));
	}
	
	public int getVelocity() {
		return getData(1);
	}
	
	public String toString() {
		return "Note on message. Channel: " + (getChannel() + 1) + ". Note: " + getNote() +
				". Velocity: " + getVelocity() + ".";
	}

}
