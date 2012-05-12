package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.POS;
import info.vforvincent.comp3021.pos.commands.PasswordCommand;
import info.vforvincent.comp3021.pos.storage.UserStorage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.istack.internal.logging.Logger;

public class PasswordCommandTest {

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
		new PasswordCommand(new UserStorage(POS.USER_FILE), new Log(POS.LOG_FILE)).addLog();
		assertTrue(true);
	}

}
