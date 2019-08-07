package app.controllers;


import app.task.Task;
import app.task.service.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//TODO: make program that use this api
@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final Map<Long, Task> repo = new HashMap<>();

	TaskController(){}

	@Autowired
	TaskController(@Qualifier("defaultTasks") List<Task> tasks){
		for (Task task :
				tasks) {
			repo.put(task.getId(), task);
		}
	}

	@GetMapping
	public Map getAllTasks(){
		return repo;
	}

	@PostMapping
	public Task addTask(@RequestBody Task task){
		repo.put(task.getId(), task);
		return task;
	}

	@GetMapping("/{id:\\d+}")
	public Task getTask(@PathVariable Long id){
		Task task = repo.get(id);
		if (task == null)
			throw new TaskNotFoundException(id);
		return task;
	}

	@PutMapping("/{id:\\d+}")
	public Task replaceTask(@RequestBody Task newTask,@PathVariable Long id){
		System.out.println(newTask.getStatus());
		Task task = repo.get(id);
		if (task == null)
		{
			newTask.setId(id);
			repo.put(id, newTask);
			return newTask;
		}
		task.setStatus(newTask.getStatus());
		task.setToDo(newTask.getToDo());
		//repo.put(id, task) not needed because there is no database(just hashmap)
		return task;
	}

	@DeleteMapping("/{id:\\d+}")
	public Task removeTask(@PathVariable Long id)
	{
		return repo.remove(id);
	}

	@GetMapping("/error")
	public String errorHandler(){
		return "something bad happen";
	}
}
