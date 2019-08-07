package app.task;

import app.task.service.BaseEntity;
import app.task.service.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
//TODO:add lombok @Data and see sources of equals/hashCode methods
//TODO: разобраться в сериализации

public class Task extends BaseEntity {

	@JsonProperty("task")
	private String toDo;

	private Status status;

	public Task(){}

	public Task(String toDo, Status status) {
		this.toDo = toDo;
		this.status = status;
	}

	public String getToDo() {
		return toDo;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Task)) return false;
		Task task = (Task) o;
		return getToDo().equals(task.getToDo()) &&
				getStatus() == task.getStatus();
	}

	@Override
	public String toString() {
		return "Task{" +
				"toDo='" + toDo + '\'' +
				", status=" + status +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(getToDo(), getStatus());
	}

}
