package net.yaourtprod.gitonappengine.api;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Indexed;
import com.googlecode.objectify.annotation.Unindexed;

@Entity(name="Objects")
public class AppengineObject {
	private @Id String objectId;
	private @Indexed String repoId;
	private @Unindexed byte[] rawContent;
	
	public AppengineObject() {
		super();
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getRepoId() {
		return repoId;
	}

	public void setRepoId(String repoId) {
		this.repoId = repoId;
	}

	public byte[] getRawContent() {
		return rawContent;
	}

	public void setRawContent(byte[] rawContent) {
		this.rawContent = rawContent;
	}
}
