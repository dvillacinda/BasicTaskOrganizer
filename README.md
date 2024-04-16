
# Task Organizer

- Microservices HTTP GET, PUT, POST, DELETE
- Using fetch to access the data
- Can change lenguage to Spanish and English
- Can make a CRUD of the tasks




## CRUD Task

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

## Demo
- Task organizer in English 

![App Screenshot](https://i.ibb.co/f1YDJrD/Captura-de-pantalla-2024-04-07-145845.png)

- Task organizer in Spanish

![App Screenshot](https://i.ibb.co/fGYJRb1/Captura-de-pantalla-2024-04-07-145829.png)

- Menu to go home or change lenguage
![App Screenshot](https://i.ibb.co/ZTdMmhG/Captura-de-pantalla-2024-04-08-154605.png)

- Lenguage options 
![App Screenshot](https://i.ibb.co/yYq6YPf/Captura-de-pantalla-2024-04-07-154041.png)

- Add task 
![App Screenshot](https://i.ibb.co/Xbk4MjC/Captura-de-pantalla-2024-04-08-154733.png)

- Update or Delete Task
![App Screenshot](https://i.ibb.co/Pw9TzW2/Captura-de-pantalla-2024-04-16-135455.png)
