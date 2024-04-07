package mx.com.gm.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import mx.com.gm.spring.entity.Lang;
import mx.com.gm.spring.repository.LangRepository;

@Service
public class LangService {
	@Autowired
	LangRepository langRepository;
	
	public Lang add (@NonNull Lang lang) {
		langRepository.save(lang);
		return lang; 
	}
	
	public void delete(@NonNull Long id) {
		langRepository.deleteById(id);
	}
	
	public List<Lang> findAll(){
		return langRepository.findAll();
	}
	
	public Optional<Lang> findById(@NonNull Long id){
		return langRepository.findById(id);
	}
}
