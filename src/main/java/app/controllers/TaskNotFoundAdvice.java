package app.controllers;

import app.task.service.TaskNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class TaskNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(TaskNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String taskNotFoundHandler(TaskNotFoundException e)
	{
		log.warn("Oh no, what is it down there ↓");
		return e.getMessage();
	}
}
