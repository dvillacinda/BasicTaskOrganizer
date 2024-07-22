
# Task Organizer
This is an full stack application to use Java21, the spring framework for the backend and JS & CSS for the frontend. 
In the app you can make a CRUD for the task and save all of them into the MySQL database. Also, you can change the lenguage 
for the application to Spanish or English if you want. 
In this application you can do all of this activities: 

- HTTP Methots GET, PUT, POST, DELETE
- Using fetch to access the data
- Change lenguage to Spanish and English
- Make a CRUD of the tasks



## PART OF THE CODE 
### CRUD Task

```java
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
```
## Change Lenguage
```javascript
 fetch("/api/lang")
            .then(response => response.json())
            .then(data => {
                valData(data);
            })
            .catch(error => {
                console.error('Error:', error);
            });

        function valData(data) {
            data.forEach(item => {
                if (item.checked) {
                    writeAll(item.language);
                    return;
                }
            });
        }
function writeAll(lang) {
            for (let i = 0; i < ID_ARRAY.length; i++) {
                fetch(`/api/translator/${ID_ARRAY[i]}/${lang}`)
                    .then((response) => response.text())
                    .then(data => {
                        let doc = document.getElementById(ID_ARRAY[i]);
                        if (doc != null) {
                            doc.innerHTML = data;
                        }
                    })
                    .catch(error => {
                        console.error('Error:', error);
                    });
            }
        }
```

