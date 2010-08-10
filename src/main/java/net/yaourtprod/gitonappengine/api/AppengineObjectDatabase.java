package net.yaourtprod.gitonappengine.api;

import org.eclipse.jgit.lib.ObjectDatabase;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;

public class AppengineObjectDatabase extends ObjectDatabase {
	private String repoId;
	
	public AppengineObjectDatabase(final String repoId) {
		this.repoId = repoId;
	}

	public ObjectInserter newInserter() {
		// TODO Auto-generated method stub
		return null;
	}

	public ObjectReader newReader() {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public String getRepoId(){
		return repoId;
	}
}
