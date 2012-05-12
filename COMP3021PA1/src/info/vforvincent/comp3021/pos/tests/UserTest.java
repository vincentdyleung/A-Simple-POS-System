package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.entities.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

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
	public void testGetID() {
		User u = new User("username", "password");
		assertEquals(null, u.getID());
	}

}
