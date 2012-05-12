package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import info.vforvincent.comp3021.pos.*;
import info.vforvincent.comp3021.pos.entities.Order;
import info.vforvincent.comp3021.pos.entities.Product;
import info.vforvincent.comp3021.pos.entities.Sales;
import info.vforvincent.comp3021.pos.storage.ProductStorage;
import info.vforvincent.comp3021.pos.storage.UserStorage;

public class FileInstructionTest {
	static Executor e;
	static UserStorage users = new UserStorage(POS.USER_FILE);
	static ProductStorage products = new ProductStorage(POS.PRODUCT_FILE);
	static Log logger = new Log(POS.LOG_FILE);
	static Sales actualSales;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		e = new Executor();
		e.setMode(new FileInstruction());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		actualSales = new Sales(new ArrayList<Order>());
		actualSales.resetCount();
	}

	@After
	public void tearDown() throws Exception {
		actualSales.resetCount();
	}

	@Test
	public void testProcess01() {
		StringReader reader = new StringReader("chunlin\nchunlin\n1\nID001\n311\nID003\n2\nc\n10000\n1\nID002\n2\nID003\n4\nc\n10000\n2");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}
	
	@Test
	public void testProcess02() {
		StringReader reader = new StringReader("chunl");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}
	
	@Test
	public void testProcess03() {
		StringReader reader = new StringReader("chunlin\nchun\n");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}
	
	@Test
	public void testProcess04() {
		StringReader reader = new StringReader("chunlin\nchunlin\nInvalidInput\n");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}
	
	@Test
	public void testProcess05() {
		StringReader reader = new StringReader("chunlin\nchunlin\n1\nNoSuchProduct\n");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}
	
	@Test
	public void testProcess06() {
		StringReader reader = new StringReader("chunlin\nchunlin\n1\nID001\n1\nNoSuchProduct\n");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}
	
	@Test
	public void testProcess07() {
		StringReader reader = new StringReader("chunlin\nchunlin\n1\nID001\n1\nID002\n2\nc\n1\n");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}
	
	@Test
	public void testProcess08() {
		StringReader reader = new StringReader("chunlin\nchunlin\n1\nID001\n1\nID002\n2\nc\n0\n2\n");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}
	
	@Test
	public void testProcess09() {
		StringReader reader = new StringReader("chunlin\nchunlin\n1\nID001\n1\nID002\n2\nc\n10000\nInvalidInput\n");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}
	
	@Test
	public void testProcess10() {
		StringReader reader = new StringReader("chunlin\nchunlin\n2\n");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}
	
	@Test
	public void testProcess11() {
		StringReader reader = new StringReader("chunlin\nchunlin\n1\nID001\n311\nID003\n2\nc\n10000\n1\nID002\n2\nID003\n4\nc\n10000\n2");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, actualSales);
		assertTrue(true);
	}

}
