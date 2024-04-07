package mx.com.gm.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	
	@Column(nullable = false, length=250)
	private String name; 
	@Column(length=200)
	private String description; 
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "statusId",nullable=false)
	
	private Status status; 
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "IconId",nullable=false)
	
	private Icon icon; 
}
