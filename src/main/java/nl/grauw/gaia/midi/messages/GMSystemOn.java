package nl.grauw.gaia.midi.messages;

public class GMSystemOn extends UniversalSysex {
	
	final static byte GENERAL_MIDI_MESSAGE = 0x09;
	final static byte GENERAL_MIDI_ON = 0x01;
	
	public GMSystemOn() {
		super(GENERAL_MIDI_MESSAGE, GENERAL_MIDI_ON);
	}
	
	public GMSystemOn(int device_id) {
		super(device_id, GENERAL_MIDI_MESSAGE, GENERAL_MIDI_ON);
	}
	
}
