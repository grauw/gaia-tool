package nl.grauw.gaia.midi.messages;

public class PitchBendChangeMessage extends ChannelMessage {
	
	public PitchBendChangeMessage(byte[] message) {
		super(message);
	}
	
	public PitchBendChangeMessage(int channel, int value) {
		super(PITCH_BEND, channel, value + 8192 & 0x7F, value + 8192 >> 7);
	}
	
	public int getValue() {
		return (getData(1) << 7 | getData(0)) - 8192;
	}
	
	public String toString() {
		return "Pitch bend change message. Channel: " + (getChannel() + 1) +
				". Value: " + getValue() + ".";
	}

}
