package mx.com.gm.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import mx.com.gm.spring.entity.Status;
import mx.com.gm.spring.repository.StatusRepository;

@Service
public class StatusService {
	@Autowired
	StatusRepository statusRepository; 
	
	//save

	public Status saveUpdateStatus(@NonNull Status status) {
		return statusRepository.save(status); 
	}
	//delete 
	public void delete(@NonNull Long Id) {
		statusRepository.deleteById(Id); 
	}
	
	//find all 
	public List<Status> findAll(){
		return statusRepository.findAll(); 
	}
	//find by id
	public Optional<Status>findById(@NonNull Long id){
		return statusRepository.findById(id); 
	}
	//find by name
	public Optional<Status>findByName(String name){
		return statusRepository.findByName(name); 
	}
}
