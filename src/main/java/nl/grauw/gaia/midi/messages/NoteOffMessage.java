package nl.grauw.gaia.midi.messages;

import nl.grauw.gaia.Note;

public class NoteOffMessage extends ChannelMessage {
	
	public NoteOffMessage(byte[] message) {
		super(message);
	}
	
	public NoteOffMessage(int channel, Note note, int velocity) {
		super(NOTE_OFF, channel, note.getNoteNumber(), velocity);
	}
	
	public Note getNote() {
		return new Note(getData(0));
	}
	
	public int getVelocity() {
		return getData(1);
	}
	
	public String toString() {
		return "Note off message. Channel: " + (getChannel() + 1) + ". Note: " + getNote() +
				". Velocity: " + getVelocity() + ".";
	}

}
