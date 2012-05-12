package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.POS;
import info.vforvincent.comp3021.pos.commands.PaymentCommand;
import info.vforvincent.comp3021.pos.storage.ProductStorage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PaymentCommandTest {

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
	public void testAddLog() {
		new PaymentCommand(new ProductStorage(POS.PRODUCT_FILE), new Log(POS.LOG_FILE)).addLog();
		assertTrue(true);
	}

}
