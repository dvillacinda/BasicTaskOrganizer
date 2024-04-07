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

import mx.com.gm.spring.entity.Status;
import mx.com.gm.spring.service.StatusService;

@RestController
@RequestMapping(path = "/api/status")
public class StatusController {
	@Autowired 
	private StatusService statusService; 
	
	// get all
		@GetMapping
		public List<Status> findAll() {
			return statusService.findAll();
		}

		// delte by id
		@DeleteMapping("/{taskId}")
		public void delete(@PathVariable @NonNull Long id) {
			statusService.delete(id); 
		}

		// find by id
		@GetMapping("/{statusId}")
		public Optional<Status> findById(@PathVariable @NonNull Long id) {
			return statusService.findById(id);
		}

		// find by name
		@GetMapping("/name/{name}")
		public Optional<Status> findByName(@PathVariable String name){
			return statusService.findByName(name); 
		}
		
		//save 
		@PostMapping
		public Status save(@RequestBody @NonNull Status status) {
			return statusService.saveUpdateStatus(status);
		}
		
		//update 
		@PutMapping("/{statusId}")
		public Status update(@RequestBody Status statusRequest, @PathVariable @NonNull Long id) {
			Optional<Status> optionalStatus = statusService.findById(id); 
			Status status = null; 
			if(optionalStatus.isPresent()) {
				status = optionalStatus.get();  
				status.setName(statusRequest.getName()); 
			}
			return status; 
		}
}
