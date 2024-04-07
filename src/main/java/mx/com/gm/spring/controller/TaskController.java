package mx.com.gm.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.gm.spring.entity.Task;
import mx.com.gm.spring.service.TaskService;

@RestController
@RequestMapping(path = "/api/task")
public class TaskController {
	@Autowired
	private TaskService taskService;

	// get all
	@GetMapping
	public List<Task> findAll() {
		return taskService.findAll();
	}

	// delte by id
	@DeleteMapping("/{taskId}")
	public void delete(@PathVariable @NonNull Long taskId) {
	    taskService.deleteTask(taskId);
	}


	// find by id
	@GetMapping("/{id}")
	public Optional<Task> findById(@PathVariable @NonNull Long id) {
		return taskService.findById(id);
	}

	// find by name
	@GetMapping("/name/{name}")
	public Optional<Task> findByName(@PathVariable String name){
		return taskService.findByName(name); 
	}
	
	//save 
	@PostMapping
	public Task save(@RequestBody @NonNull Task task) {
		return taskService.saveUpdateTask(task);
	}
	
	//update 
	@PutMapping("/{id}")
	public Task update(@RequestBody Task taskRequest, @PathVariable @NonNull Long id) {
		Optional<Task> optionalTask = taskService.findById(id); 
		Task task = null; 
		if(optionalTask.isPresent()) {
			task = optionalTask.get(); 
			task.setDescription(taskRequest.getDescription()); 
			task.setName(taskRequest.getName()); 
			task.setStatus(taskRequest.getStatus()); 
			task.setIcon(taskRequest.getIcon()); 
			return taskService.saveUpdateTask(task); 
		}
		return task; 
	}
}
