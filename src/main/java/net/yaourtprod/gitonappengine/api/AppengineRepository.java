package net.yaourtprod.gitonappengine.api;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.BaseRepositoryBuilder;
import org.eclipse.jgit.lib.ObjectDatabase;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.storage.file.ReflogReader;

public class AppengineRepository extends Repository {

	protected AppengineRepository(final BaseRepositoryBuilder options) {
		super(options);
		// TODO Auto-generated constructor stub
	}

	public void create(boolean bare) throws IOException {
		if (!bare) {
			throw new IOException("Only bare repository could be created.");
		}
		
		// TODO implement this ...
	}

	public File getObjectsDirectory() {
		return null;
	}

	public ObjectDatabase getObjectDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	public RefDatabase getRefDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	public StoredConfig getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public void openPack(final File pack, final File idx) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void scanForRepoChanges() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public ReflogReader getReflogReader(final String refName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
