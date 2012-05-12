package info.vforvincent.comp3021.pos.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EntityTest.class, ExecutorTest.class,
		FileInstructionTest.class, OrderTest.class, ProductTest.class,
		UserTest.class, SalesTest.class, UserStorageTest.class,
		ProductStorageTest.class, LogTest.class, InteractionInstructionTest.class,
		POSTest.class})
public class AllTests {
	
}
