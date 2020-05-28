package nl.grauw.gaia.midi.messages;

public class GMSystemOff extends UniversalSysex {
	
	final static byte GENERAL_MIDI_MESSAGE = 0x09;
	final static byte GENERAL_MIDI_OFF = 0x02;
	
	public GMSystemOff() {
		super(GENERAL_MIDI_MESSAGE, GENERAL_MIDI_OFF);
	}
	
	public GMSystemOff(int device_id) {
		super(device_id, GENERAL_MIDI_MESSAGE, GENERAL_MIDI_OFF);
	}
	
}
