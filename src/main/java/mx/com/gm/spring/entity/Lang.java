package mx.com.gm.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Lang {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long language_id;
	@Column(nullable = false)
	String language;
	@Column(nullable=false)
	Boolean checked; 
}
