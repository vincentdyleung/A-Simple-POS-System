package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.POS;
import info.vforvincent.comp3021.pos.entities.Product;
import info.vforvincent.comp3021.pos.storage.ProductStorage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductStorageTest {

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
		ProductStorage products = new ProductStorage(POS.PRODUCT_FILE);
		Product p = new Product("testid", "testname", 1.0, 1);
		products.add(p);
		assertTrue(products.contains(p.getID()));
	}

}
