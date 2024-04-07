package mx.com.gm.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.gm.spring.entity.Lang;
@Repository
public interface LangRepository extends JpaRepository<Lang, Long> {

}
