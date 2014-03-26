package ee.playtech.trial.server.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Version
	private Long version;
	@NotNull
	@Column(name = "update_timestamp")
	private Date updateTimestamp;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getUpdateTimestamp() {
		return updateTimestamp != null ? new Date(updateTimestamp.getTime()) : null;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	@PrePersist
	protected void prePersist() {
		Date date = new Date(System.currentTimeMillis());
		this.setUpdateTimestamp(date);
	}

	@PreUpdate
	protected void preUpdate() {
		this.setUpdateTimestamp(new Date(System.currentTimeMillis()));
	}
}