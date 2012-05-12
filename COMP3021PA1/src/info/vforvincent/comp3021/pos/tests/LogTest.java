package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.POS;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LogTest {
	static Log logger;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger = new Log(POS.LOG_FILE);
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
	public void testAdd() {
		logger.add("test", true);
	}

	@Test
	public void testGetWriter() {
		logger.getWriter();
	}

}
