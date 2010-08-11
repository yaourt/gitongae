package net.yaourtprod.gitonappengine.api;

import java.io.IOException;
import java.nio.charset.Charset;

import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AppengineObjectInserterTest extends AbstractTestCase {
	@Mock AppengineObjectDatabase dbMock;
	AppengineObjectInserter undertest;
	
	@BeforeClass(groups={"UT"})
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		undertest = new AppengineObjectInserter(dbMock);
	}
	
	@Test(groups={"UT"})
	public void insertTest() throws IOException {
		final String expectedId = "7fdc3a7439847844b4fccc4b9e4700ab72c7e11e";
		String strdata = "this is a blob !";
		byte[] rawdata = strdata.getBytes(Charset.defaultCharset());
		when(dbMock.has((AnyObjectId)Mockito.anyObject())).thenReturn(true);
		undertest.insert(Constants.OBJ_BLOB, rawdata);

		when(dbMock.has((AnyObjectId)Mockito.anyObject())).thenReturn(false);
		ObjectId id = undertest.insert(Constants.OBJ_BLOB, rawdata);
		assertNotNull(id);
		assertEquals(id.name(), expectedId);
		Objectify ofy = ObjectifyService.begin();
		AppengineObject obj = ofy.get(AppengineObject.class, expectedId);
		assertNotNull(obj);
		assertEquals(obj.getObjectId(), expectedId);
	}
}