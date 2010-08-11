package net.yaourtprod.gitonappengine.api;

import java.io.IOException;

import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class AppengineObjectReader extends ObjectReader {
	static {
		ObjectifyService.register(AppengineObject.class);
	}

	private AppengineObjectDatabase db;

	AppengineObjectReader(final AppengineObjectDatabase db) {
		this.db = db;
	}

	public ObjectReader newReader() {
		return new AppengineObjectReader(db);
	}

	public ObjectLoader open(final AnyObjectId objectId, final int typeHint)
			throws MissingObjectException, IncorrectObjectTypeException,
			IOException {
		Objectify ofy = ObjectifyService.begin();
		AppengineObject obj = ofy.get(AppengineObject.class, objectId.name());

		if (obj == null) {
			if (typeHint == OBJ_ANY) {
				throw new MissingObjectException(objectId.copy(), "unknown");
			} else {
				throw new MissingObjectException(objectId.copy(), typeHint);
			}
		}
		if (typeHint != OBJ_ANY && obj.getTypeHint() != typeHint) {
			throw new IncorrectObjectTypeException(objectId.copy(), typeHint);
		}
		AppengineObjectLoader ldr = new AppengineObjectLoader(obj);
		return ldr;
	}

}
