package nl.grauw.gaia.midi.messages;

public class ActiveSensingMessage extends Message {
	
	public ActiveSensingMessage(byte[] message) {
		super(message);
	}
	
	public String toString() {
		return "Active sensing message.";
	}

}
