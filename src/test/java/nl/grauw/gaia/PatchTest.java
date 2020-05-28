package nl.grauw.gaia;

import static org.junit.Assert.*;

import nl.grauw.gaia.Patch;
import nl.grauw.gaia.Patch.PatchChangeListener;
import nl.grauw.gaia.parameters.ArpeggioCommonTest;
import nl.grauw.gaia.parameters.ArpeggioPatternTest;
import nl.grauw.gaia.parameters.DelayTest;
import nl.grauw.gaia.parameters.DistortionTest;
import nl.grauw.gaia.parameters.FlangerTest;
import nl.grauw.gaia.parameters.PatchCommonTest;
import nl.grauw.gaia.parameters.ReverbTest;
import nl.grauw.gaia.parameters.ToneTest;
import nl.grauw.gaia.parameters.ArpeggioCommon.ArpeggioDuration;

import org.junit.Test;

public class PatchTest {
	
	public static Patch createTestPatch() {
		Patch patch = new Patch();
		patch.setCommon(PatchCommonTest.createTestParameters());
		for (int tone = 1; tone <= 3; tone++)
			patch.setTone(tone, ToneTest.createTestParameters(tone));
		patch.setDistortion(DistortionTest.createTestParameters());
		patch.setFlanger(FlangerTest.createTestParameters());
		patch.setDelay(DelayTest.createTestParameters());
		patch.setReverb(ReverbTest.createTestParameters());
		patch.setArpeggioCommon(ArpeggioCommonTest.createTestParameters());
		for (int note = 1; note <= 16; note++)
			patch.setArpeggioPattern(note, ArpeggioPatternTest.createTestParameters(note));
		return patch;
	}
	
	@Test
	public void testIsComplete() {
		Patch patch = createTestPatch();
		
		assertEquals(true, patch.isComplete());
	}

	@Test
	public void testIsComplete_Incomplete() {
		Patch patch = createTestPatch();
		patch.setTone(3, null);
		
		assertEquals(false, patch.isComplete());
	}
	
	@Test
	public void testIsEqualTo() {
		Patch a = createTestPatch();
		Patch b = createTestPatch();
		
		assertEquals(true, a.isEqualTo(b));
	}
	
	@Test
	public void testIsEqualTo_ParameterDifference() {
		Patch a = createTestPatch();
		Patch b = createTestPatch();
		b.getArpeggioCommon().getArpeggioDuration().setValue(ArpeggioDuration._30);
		
		assertEquals(false, a.isEqualTo(b));
	}
	
	@Test
	public void testPatchChangeListener() {
		Patch p = createTestPatch();
		TestPatchChangeListener listener = new TestPatchChangeListener();
		
		p.addPatchChangeListener(listener);
		
		assertEquals(true, p.hasPatchChangeListener(listener));
		
		p.setFlanger(FlangerTest.createTestParameters());
		
		assertEquals(1, listener.callCount);
		assertEquals(p, listener.lastSource);
		assertEquals("flanger", listener.lastDetail);
		
		p.removePatchChangeListener(listener);
		
		assertEquals(false, p.hasPatchChangeListener(listener));
	}
	
	private static class TestPatchChangeListener implements PatchChangeListener {
		public int callCount = 0;
		public Patch lastSource = null;
		public String lastDetail = null;
		public void onPatchChange(Patch source, String detail) {
			callCount++;
			lastSource = source;
			lastDetail = detail;
		}
	}
	
}
