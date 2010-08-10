package net.yaourtprod.gitonappengine.api;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

import org.eclipse.jgit.errors.ObjectWritingException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class AppengineObjectInserter extends ObjectInserter {
    static {
        ObjectifyService.register(AppengineObject.class);
    }

	private AppengineObjectDatabase db;
	private Deflater deflate;

	AppengineObjectInserter(final AppengineObjectDatabase dest){
		this.db = dest;
	}

	public ObjectId insert(final int type, final long len, final InputStream is)
			throws IOException {
		final MessageDigest md = digest();
		final AppengineObject tmp = toTemp(md, type, len, is);
		final ObjectId id = ObjectId.fromString(tmp.getObjectId());
		if (db.has(id)) {
			// Object is already in the repository ...
			return id;
		}

		// Need to store it ...
		try {
			Objectify ofy = ObjectifyService.begin();
			ofy.put(tmp);
			return id;
		} catch(final Throwable t) {
			throw new ObjectWritingException("Unable to create new object: " + id.getName(), t);
		}
	}

	public void flush() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void release() {
		// TODO Auto-generated method stub
		
	}

	private AppengineObject toTemp(final MessageDigest md, final int type, long len, final InputStream is)
	throws IOException, FileNotFoundException, Error {
		AppengineObject tmp = new AppengineObject();
		ByteArrayOutputStream baos = new ByteArrayOutputStream((int) len);

		DigestOutputStream dOut = new DigestOutputStream(compress(baos), md);
		try {
			dOut.write(Constants.encodedTypeString(type));
			dOut.write((byte) ' ');
			dOut.write(Constants.encodeASCII(len));
			dOut.write((byte) 0);

			final byte[] buf = buffer();
			while (len > 0) {
				int n = is.read(buf, 0, (int) Math.min(len, buf.length));
				if (n <= 0)
					throw shortInput(len);
				dOut.write(buf, 0, n);
				len -= n;
			}
		} finally {
			dOut.close();
		}

		tmp.setObjectId(ObjectId.fromRaw(md.digest()).name());
		tmp.setRepoId(db.getRepoId());
		tmp.setRawContent(baos.toByteArray());
		baos.close();
		baos = null;
		return tmp;
	}

	private DeflaterOutputStream compress(final OutputStream out) {
		if (deflate == null)
			deflate = new Deflater(Deflater.DEFAULT_COMPRESSION);
		else
			deflate.reset();
		return new DeflaterOutputStream(out, deflate);
	}

	private static EOFException shortInput(long missing) {
		return new EOFException("Input did not match supplied length. "
				+ missing + " bytes are missing.");
	}

}
