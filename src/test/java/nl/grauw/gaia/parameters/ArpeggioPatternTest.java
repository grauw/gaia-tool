package nl.grauw.gaia.parameters;

import static org.junit.Assert.*;

import nl.grauw.gaia.Address;
import nl.grauw.gaia.Note.NoteName;
import nl.grauw.gaia.parameters.ArpeggioPattern;

import org.junit.Test;

public class ArpeggioPatternTest {

	static Address testAddress = new Address(0x10, 0x00, 0x0D, 0x00);
	static byte[] testParameterData = {
		0x03, 0x0C, // 0x00
		0x00, 0x00, 0x07, 0x0F, 0x08, 0x00, 0x00, 0x00, // 0x02
		0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, // 0x0A
		0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, // 0x12
		0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, // 0x1A
		0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, // 0x22
		0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, // 0x2A
		0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, // 0x32
		0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x04, 0x00  // 0x3A
	};
	
	public static ArpeggioPattern createTestParameters() {
		return createTestParameters(1);
	}
	
	public static ArpeggioPattern createTestParameters(int note) {
		return new ArpeggioPattern(testAddress.add((note - 1) * 0x80), testParameterData.clone());
	}

	@Test (expected = RuntimeException.class)
	public void testPatchArpeggioPatternParameters() {
		new ArpeggioPattern(testAddress, new byte[65]);
	}

	@Test
	public void testGetNoteNumber() {
		ArpeggioPattern pattern = createTestParameters(9);
		assertEquals(9, pattern.getNoteNumber());
	}

	@Test
	public void testGetOriginalNote() {
		ArpeggioPattern papp = createTestParameters();
		assertEquals(NoteName.C, papp.getOriginalNote().getValue().getNote());
		assertEquals(4, papp.getOriginalNote().getValue().getOctave());
	}

	@Test
	public void testGetStepData() {
		ArpeggioPattern papp = createTestParameters();
		assertEquals(0, papp.getStepData(1).getValue());
		assertEquals(127, papp.getStepData(2).getValue());
		assertEquals(128, papp.getStepData(3).getValue());
		assertEquals(64, papp.getStepData(32).getValue());
	}

	@Test (expected = RuntimeException.class)
	public void testGetStepDataInvalidLow() {
		ArpeggioPattern papp = createTestParameters();
		papp.getStepData(0);
	}

	@Test (expected = RuntimeException.class)
	public void testGetStepDataInvalidHigh() {
		ArpeggioPattern papp = createTestParameters();
		papp.getStepData(33);
	}

}
