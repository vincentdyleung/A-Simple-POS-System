package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.entities.Order;
import info.vforvincent.comp3021.pos.entities.Product;
import info.vforvincent.comp3021.pos.entities.Sales;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SalesTest {
	static Sales sales;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Product p1 = new Product("testid1", "testname1", 1.0, 1);
		Product p2 = new Product("testid2", "testname2", 2.0, 2);
		Order o1 = new Order(p1, 1);
		Order o2 = new Order(p2, 2);
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(o1);
		orders.add(o2);
		sales = new Sales(orders);
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
		assertEquals(null, sales.getName());
	}

	@Test
	public void testGetID() {
		int count = sales.getCount() - 1;
		String prefix = "SalesID";
		prefix += "0" + Integer.toString(count);
		assertEquals(prefix, sales.getID());
	}

	@Test
	public void testGetPassword() {
		assertEquals(null, sales.getPassword());
	}

	@Test
	public void testAddOrder() {
		Product p = new Product("testid3", "testname3", 2.0, 2);
		Order o = new Order(p, 3);
		sales.addOrder(o);
	}

	@Test
	public void testSetPayment() {
		assertFalse(sales.setPayment(0));
	}

}
