package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.entities.Product;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductTest {
	static Product prod;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		prod = new Product("testid", "testname", 1.0, 1);
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
		assertEquals("testid", prod.getID());
	}

	@Test
	public void testGetPassword() {
		assertEquals(null, prod.getPassword());
	}

}
