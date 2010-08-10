package net.yaourtprod.gitonappengine.api;

import java.io.IOException;

import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;

public class AppengineObjectReader extends ObjectReader {

	public ObjectReader newReader() {
		// TODO Auto-generated method stub
		return null;
	}

	public ObjectLoader open(AnyObjectId objectId, int typeHint)
			throws MissingObjectException, IncorrectObjectTypeException,
			IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
