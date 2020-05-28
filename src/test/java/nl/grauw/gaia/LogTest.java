package nl.grauw.gaia;

import static org.junit.Assert.*;

import nl.grauw.gaia.Log;

import org.junit.Test;

public class LogTest {

	@Test
	public void testGetLog() {
		Log l = new Log();
		assertTrue("".equals(l.getLog()));
	}

	@Test
	public void testLog() {
		Log l = new Log();
		l.log("test1");
		l.log("test2");
		l.log(3);
		assertTrue("test1\ntest2\n3\n".equals(l.getLog()));
	}

}
