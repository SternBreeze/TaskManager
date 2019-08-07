package app.task.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

//@MappedSuperclass

public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public boolean isNew(){
		return id == null;
	}

}
