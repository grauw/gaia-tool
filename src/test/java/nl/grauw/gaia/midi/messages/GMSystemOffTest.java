package nl.grauw.gaia.midi.messages;

import static org.junit.Assert.*;

import nl.grauw.gaia.midi.messages.GMSystemOff;
import nl.grauw.gaia.midi.messages.Message;

import org.junit.Test;

public class GMSystemOffTest {

	@Test
	public void testGMSystemOff() {
		Message mm = new GMSystemOff();
		byte[] message = mm.getMessage();
		byte[] expected = {(byte)0xF0, 0x7E, 0x7F, 0x09, 0x02, (byte)0xF7};
		assertArrayEquals(expected, message);
	}

}
