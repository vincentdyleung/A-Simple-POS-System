package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.entities.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

	User user;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user = new User("testname", "testpassword");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		assertEquals("testname", user.getName());
	}

	@Test
	public void testGetPassword() {
		assertEquals("testpassword", user.getPassword());
	}

	@Test
	public void testUser() {
		String[] expected = new String[2];
		expected[0] = "testname";
		expected[1] = "testpassword";
		String[] result = new String[2];
		result[0] = user.getName();
		result[1] = user.getPassword();
		assertArrayEquals(expected, result);
	}

}
