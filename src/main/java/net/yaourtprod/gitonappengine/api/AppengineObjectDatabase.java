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
		return new AppengineObjectInserter(this);
	}

	public ObjectReader newReader() {
		return new AppengineObjectReader(this);
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public String getRepoId(){
		return repoId;
	}
}
