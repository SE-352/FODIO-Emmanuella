
package TP4;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "etudiants")
@DiscriminatorValue(value = "ETUDIANT")
public class Etudiant  extends Personne {
	
	@Column(nullable = false) 
	private String address;
	
	private int telephone;
	
	
	@ManyToOne
	@JoinColumn(name = "departement_id")
	private Departement departement;
	
	@ManyToMany(mappedBy = "etudiants")
	private Set<Cours> cours;
	
	public Etudiant() {
		
	}
}
