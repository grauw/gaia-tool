package nl.grauw.gaia.midi.messages;

public class ProgramChangeMessage extends ChannelMessage {
	
	public ProgramChangeMessage(byte[] message) {
		super(message);
	}
	
	public ProgramChangeMessage(int channel, int program) {
		super(PROGRAM_CHANGE, channel, program);
	}
	
	public int getProgram() {
		return getData(0);
	}
	
	public String toString() {
		return "Program change message. Channel: " + (getChannel() + 1) +
				". Program: " + (getProgram() + 1) + ".";
	}

}
