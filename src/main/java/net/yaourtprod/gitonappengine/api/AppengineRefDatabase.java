package net.yaourtprod.gitonappengine.api;

import java.io.IOException;
import java.util.Map;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.lib.RefRename;
import org.eclipse.jgit.lib.RefUpdate;

public class AppengineRefDatabase extends RefDatabase {

	public void create() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public boolean isNameConflicting(String name) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	public RefUpdate newUpdate(String name, boolean detach) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public RefRename newRename(String fromName, String toName)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Ref getRef(String name) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Map getRefs(String prefix) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Ref peel(Ref ref) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
