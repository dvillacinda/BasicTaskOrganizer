package mx.com.gm.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.gm.spring.entity.Icon;

@Repository
public interface IconRepository extends JpaRepository<Icon, Long> {

}
