package mx.com.gm.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.gm.spring.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	public Optional<Task> findByName(String name); 
}
