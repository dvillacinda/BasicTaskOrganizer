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

import mx.com.gm.spring.entity.Icon;
import mx.com.gm.spring.service.IconService;


@RestController
@RequestMapping(path="/api/icon")
public class IconController {
	@Autowired
	private IconService iconService; 
	
	@GetMapping
	public List<Icon> findAll(){
		return iconService.findAll();
	}
	
	@PostMapping
	public Icon save(@RequestBody @NonNull Icon icon) {
		return iconService.add(icon); 
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable @NonNull Long id) {
		iconService.delete(id); 
	}
	@PutMapping("/{id}")
	public Icon update(@PathVariable Long id, @RequestBody Icon iconRequest) {
		Optional<Icon>optionalIcon = iconService.findById(id); 
		Icon icon = null; 
		if(optionalIcon.isPresent()) {
			icon = optionalIcon.get(); 
			icon.setPath(iconRequest.getPath()); 
		}
		return icon; 
	}
}
