package nl.grauw.gaia.midi.messages;

import static org.junit.Assert.*;

import nl.grauw.gaia.midi.messages.GMSystemOn;
import nl.grauw.gaia.midi.messages.Message;

import org.junit.Test;

public class GM1SystemOnTest {

	@Test
	public void testGM1SystemOn() {
		Message mm = new GMSystemOn();
		byte[] message = mm.getMessage();
		byte[] expected = {(byte)0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte)0xF7};
		assertArrayEquals(expected, message);
	}

}
