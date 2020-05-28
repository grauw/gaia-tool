package nl.grauw.gaia.midi.messages;

import static org.junit.Assert.*;

import nl.grauw.gaia.midi.messages.GM2SystemOn;
import nl.grauw.gaia.midi.messages.Message;

import org.junit.Test;

public class GM2SystemOnTest {

	@Test
	public void testGM2SystemOn() {
		Message mm = new GM2SystemOn();
		byte[] message = mm.getMessage();
		byte[] expected = {(byte)0xF0, 0x7E, 0x7F, 0x09, 0x03, (byte)0xF7};
		assertArrayEquals(expected, message);
	}

}
