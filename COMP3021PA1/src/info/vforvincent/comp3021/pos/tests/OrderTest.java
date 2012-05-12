package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.entities.Order;
import info.vforvincent.comp3021.pos.entities.Product;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrderTest {
	static Product prod;
	static Order order;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		prod = new Product("testid", "testname", 1.0, 1);
		order = new Order(prod, 1);
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
		assertEquals(null, order.getName());
	}

	@Test
	public void testGetID() {
		assertEquals(null, order.getID());
	}

	@Test
	public void testGetPassword() {
		assertEquals(null, order.getPassword());
	}

	@Test
	public void testOrder() {
		Order o = new Order(prod, 1);
		assertTrue(prod.equals(order.getProduct()) && order.getQuantity() == 1);
	}

	@Test
	public void testGetProduct() {
		assertEquals(prod, order.getProduct());
	}

	@Test
	public void testGetQuantity() {
		assertEquals(1, order.getQuantity());
	}

	@Test
	public void testGetTotal() {
		assertEquals(1.0, order.getTotal(), 0.01);
	}

	@Test
	public void testToString() {
		assertEquals("testname * 1    = $1.0", order.toString());
	}

}
