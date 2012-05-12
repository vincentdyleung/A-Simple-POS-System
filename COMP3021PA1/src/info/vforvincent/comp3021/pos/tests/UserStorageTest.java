package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.POS;
import info.vforvincent.comp3021.pos.entities.User;
import info.vforvincent.comp3021.pos.storage.UserStorage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserStorageTest {

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
	public void testAdd() {
		UserStorage users = new UserStorage(POS.USER_FILE);
		User u = new User("username", "password");
		users.add(u);
		assertTrue(users.contains(u.getName()));
	}

}
