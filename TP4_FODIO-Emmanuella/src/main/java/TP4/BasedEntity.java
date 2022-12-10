
package TP4;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.persistence.MappedSuperclass;


@MappedSuperclass

public class BasedEntity {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
}
