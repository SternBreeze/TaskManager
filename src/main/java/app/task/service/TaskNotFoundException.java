package app.task.service;

public class TaskNotFoundException extends RuntimeException {
	public TaskNotFoundException(Long id){
		super("Could not find task");
	}
}
