package mx.com.gm.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import mx.com.gm.spring.entity.Task;
import mx.com.gm.spring.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	TaskRepository taskRepository;  
	//save
	public Task saveUpdateTask(@NonNull Task task) {
		return taskRepository.save(task); 
	}
	//delete
	public void deleteTask(@NonNull Long id) {
		taskRepository.deleteById(id);
	}
	
	//search all 
	public List<Task> findAll(){
		return taskRepository.findAll(); 
	}
	//find by id
	public Optional<Task> findById(@NonNull Long id){
		return taskRepository.findById(id); 
	}
	
	//find by name
	public Optional<Task> findByName(String name){
		return taskRepository.findByName(name); 
	}
}
