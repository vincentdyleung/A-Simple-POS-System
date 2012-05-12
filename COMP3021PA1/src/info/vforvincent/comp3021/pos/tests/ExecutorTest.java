package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import info.vforvincent.comp3021.pos.*;

public class ExecutorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecutor() {
		Executor e = new Executor();
		assertNull(e.getMode());
	}

	@Test
	public void testGetMode() {
		Executor e = new Executor();
		e.setMode(new InteractionInstruction());
		assertTrue(e.getMode() instanceof InteractionInstruction);
	}

	@Test
	public void testSetMode() {
		Executor e = new Executor();
		e.setMode(new InteractionInstruction());
		assertTrue(e.getMode() instanceof InteractionInstruction);
	}

}
