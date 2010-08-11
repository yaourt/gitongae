package net.yaourtprod.gitonappengine.api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public abstract class AbstractTestCase {
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());

	@BeforeClass(groups="UT")
	public final void setup() {
		helper.setUp();
	}
	
	@AfterClass(groups="UT")
	public final void tearDown(){
		helper.tearDown();
	}
}
