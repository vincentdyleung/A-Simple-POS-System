package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.entities.Entity;
import info.vforvincent.comp3021.pos.entities.Product;
import info.vforvincent.comp3021.pos.entities.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityTest {

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
	public void testGetName() {
		Entity en = new User("name", "password");
		assertEquals(en.getName(), "name");
	}

	@Test
	public void testGetID() {
		Entity en = new Product("testid", "testname", 12.0, 100);
		assertEquals(en.getID(), "testid");
	}

	@Test
	public void testGetPassword() {
		Entity en = new User("name", "password");
		assertEquals(en.getPassword(), "password");
	}

}
