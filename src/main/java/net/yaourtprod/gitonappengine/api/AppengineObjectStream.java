package net.yaourtprod.gitonappengine.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.eclipse.jgit.lib.ObjectStream;

public class AppengineObjectStream extends ObjectStream {
	private int type;
	private long size;
	private ByteArrayInputStream bais;
	
	AppengineObjectStream(final AppengineObject obj) {
		this.type = obj.getTypeHint();
		this.size = obj.getRawContent().length;
		this.bais = new ByteArrayInputStream(obj.getRawContent());
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public int read() throws IOException {
		return bais.read();
	}

}
