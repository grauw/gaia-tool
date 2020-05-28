package nl.grauw.gaia.midi.messages;

import static org.junit.Assert.*;

import nl.grauw.gaia.Address;
import nl.grauw.gaia.midi.messages.DataRequest1;
import nl.grauw.gaia.midi.messages.Message;

import org.junit.Test;

public class DataRequest1Test {

	@Test
	public void testDataRequest1AddressInt() {
		Message mm = new DataRequest1(new Address(0x01, 0x23, 0x45, 0x67), 0x17F);
		byte[] message = mm.getMessage();
		byte[] expected = {(byte)0xF0, 0x41, 0x7F, 0x00, 0x00, 0x41, 0x11,
				0x01, 0x23, 0x45, 0x67, 0x00, 0x00, 0x02, 0x7F, 0x2F, (byte)0xF7};
		assertArrayEquals(expected, message);
	}

	@Test
	public void testDataRequest1IntAddressInt() {
		Message mm = new DataRequest1(0x10, new Address(0x01, 0x23, 0x45, 0x67), 0x17F);
		byte[] message = mm.getMessage();
		byte[] expected = {(byte)0xF0, 0x41, 0x10, 0x00, 0x00, 0x41, 0x11,
				0x01, 0x23, 0x45, 0x67, 0x00, 0x00, 0x02, 0x7F, 0x2F, (byte)0xF7};
		assertArrayEquals(expected, message);
	}

}
