package mx.com.gm.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.gm.spring.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
	public Optional<Status> findByName(String name); 
}
