
package TP4;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "PersonneType")


public class Personne extends BasedEntity {
	
	@Column (length = 60, nullable = false)
	protected String nom;
	
	@Column (length = 60, nullable = false)
	protected String prenom;
	
	@Column (length = 30)
	protected  String email;

	public Personne() {
		
	}

}
