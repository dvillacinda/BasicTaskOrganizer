package mx.com.gm.spring.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import mx.com.gm.spring.entity.Icon;
import mx.com.gm.spring.repository.IconRepository;


@Service
public class IconService {
	@Autowired
	IconRepository iconRepository;
	
	public Icon add (@NonNull Icon icon) {
		iconRepository.save(icon);
		return icon; 
	}
	
	public void delete(@NonNull Long id) {
		iconRepository.deleteById(id);
	}
	
	public List<Icon> findAll(){
		return iconRepository.findAll();
	}
	
	public Optional<Icon> findById(@NonNull Long id){
		return iconRepository.findById(id);
	}
}
