package app.configs;

import app.task.service.Status;
import app.task.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

@Configuration
public class MainConfig {
	@Bean("thirdTask")
	public Task getThirdTask(){
		Task task = new Task("third task", Status.IN_PROGRESS);
		task.setId(3L);
		return task;
	}

	@Bean({"firstTask", "alsoFirstTask"})
	@Qualifier("defaultTasks")
	@Order(1)
	@Scope("singleton")
	public Task getFirstTask(){
		Task task = new Task("first task", Status.IN_PROGRESS);
		task.setId(1L);
		return task;
	}

	@Bean("secondTask")
	@Qualifier("defaultTasks")
	@Order(2)
	public Task getSecondTask(){
		Task task = new Task("second task", Status.IN_PROGRESS);
		task.setId(2L);
		return task;
	}

}
