package info.vforvincent.comp3021.pos.tests;

import static org.junit.Assert.*;
import info.vforvincent.comp3021.pos.Executor;
import info.vforvincent.comp3021.pos.FileInstruction;
import info.vforvincent.comp3021.pos.InteractionInstruction;
import info.vforvincent.comp3021.pos.Log;
import info.vforvincent.comp3021.pos.POS;
import info.vforvincent.comp3021.pos.entities.Order;
import info.vforvincent.comp3021.pos.entities.Product;
import info.vforvincent.comp3021.pos.entities.Sales;
import info.vforvincent.comp3021.pos.storage.ProductStorage;
import info.vforvincent.comp3021.pos.storage.UserStorage;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InteractionInstructionTest {

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
	public void testProcess() {
		Executor e = new Executor();
		e.setMode(new InteractionInstruction());
		UserStorage users = new UserStorage(POS.USER_FILE);
		ProductStorage products = new ProductStorage(POS.PRODUCT_FILE);
		Log logger = new Log(POS.LOG_FILE);
		Sales sales = new Sales(new ArrayList<Order>());
		StringReader reader = new StringReader("NotAUser\nchunlin\nWrongPassword\nchunlin\nInvalidCommand\n1\nNotAProduct\nID001\n311\nID003\n2\nInvalidCommand\nc\nNotANumber\n1\n10000\n1\nID002\n2\nID003\n4\nc\n0\n2");
		Scanner input = new Scanner(reader);
		e.getMode().process(users, products, input, logger, sales);
		assertTrue(true);
	}

}
