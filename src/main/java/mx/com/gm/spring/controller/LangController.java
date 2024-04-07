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


import mx.com.gm.spring.entity.Lang;
import mx.com.gm.spring.service.LangService;

@RestController
@RequestMapping(path="/api/lang")
public class LangController {
	@Autowired
	private LangService langService; 
	
	@GetMapping
	public List<Lang> findAll(){
		return langService.findAll();
	}
	
	@PostMapping
	public Lang save(@RequestBody @NonNull Lang lang) {
		return langService.add(lang); 
	}
	
	@PutMapping("/{id}")
	public Lang update(@PathVariable @NonNull Long id, @RequestBody Lang langRequest) {
		Optional<Lang> optionalLang = langService.findById(id);
		Lang lang = null;
		if(optionalLang.isPresent()) {
			lang = optionalLang.get(); 
			lang.setChecked(langRequest.getChecked()); 
			langService.add(lang); 
		}
		return lang; 
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable @NonNull Long id) {
		langService.delete(id); 
	}
}
