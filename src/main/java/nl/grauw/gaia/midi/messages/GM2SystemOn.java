package nl.grauw.gaia.midi.messages;

public class GM2SystemOn extends UniversalSysex {
	
	final static byte GENERAL_MIDI_MESSAGE = 0x09;
	final static byte GENERAL_MIDI_2_ON = 0x03;
	
	public GM2SystemOn() {
		super(GENERAL_MIDI_MESSAGE, GENERAL_MIDI_2_ON);
	}
	
	public GM2SystemOn(int device_id) {
		super(device_id, GENERAL_MIDI_MESSAGE, GENERAL_MIDI_2_ON);
	}
	
}
