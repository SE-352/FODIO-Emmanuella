
package TP4;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;





@Entity
@Table(name = "professeurs")
public class Professeur extends Personne {
	
	@Column(length = 30, nullable = false)
	private String grade;
	
	Professeur() {
		
	}
	
	@ManyToMany()
	@JoinTable(name = "interventions",
		joinColumns = @JoinColumn (name = "professeur_id"),
		inverseJoinColumns = @JoinColumn(name = "departement_id"))
	private Set<Departement> departements;
	
	

}
