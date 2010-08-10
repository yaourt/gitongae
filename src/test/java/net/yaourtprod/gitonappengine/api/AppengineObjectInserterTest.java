package net.yaourtprod.gitonappengine.api;

import java.io.IOException;
import java.nio.charset.Charset;

import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;

public class AppengineObjectInserterTest {
	@Mock AppengineObjectDatabase dbMock;
	AppengineObjectInserter undertest;
	
	@BeforeClass(groups={"UT"})
	public void setup() {
		MockitoAnnotations.initMocks(this);
		undertest = new AppengineObjectInserter(dbMock);
	}
	
	@Test(groups={"UT"})
	public void insertTest() throws IOException {
		String strdata = "this is a blob !";
		byte[] rawdata = strdata.getBytes(Charset.defaultCharset());
		when(dbMock.has((AnyObjectId)Mockito.anyObject())).thenReturn(true);
		undertest.insert(Constants.OBJ_BLOB, rawdata);

		when(dbMock.has((AnyObjectId)Mockito.anyObject())).thenReturn(false);
		undertest.insert(Constants.OBJ_BLOB, rawdata);
	}
}