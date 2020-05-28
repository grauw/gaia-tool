package nl.grauw.gaia;

import static org.junit.Assert.*;

import java.io.File;

import nl.grauw.gaia.Library;

import org.junit.Test;

public class LibraryTest {

	@Test
	public void testGetName() {
		Library library = new Library(new File("/test/xxx"));
		assertEquals("xxx", library.getName());
	}

	@Test
	public void testPopulateNonExistantPath() {
		Library library = new Library(new File("non-existant-test-path"));
		library.refresh();
		assertEquals(true, library.getPatches().isEmpty());
		assertEquals(true, library.getLibraries().isEmpty());
	}

}
