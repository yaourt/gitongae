package net.yaourtprod.gitonappengine.api;

import java.io.IOException;

import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectStream;

public class AppengineObjectLoader extends ObjectLoader {
	private AppengineObject obj;
	
	AppengineObjectLoader(final AppengineObject obj) {
		this.obj = obj;
	}

	@Override
	public int getType() {
		return obj.getTypeHint();
	}

	@Override
	public long getSize() {
		return obj.getRawContent().length;
	}

	@Override
	public byte[] getCachedBytes() throws LargeObjectException {
		return obj.getRawContent();
	}

	@Override
	public ObjectStream openStream() throws MissingObjectException, IOException {
		return new AppengineObjectStream(obj);
	}

}
