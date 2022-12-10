
package TP4;
import java.util.Set;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;



@Entity
@Table (name = "departements")
public class Departement extends BasedEntity {
	
	
	private String nom_dep;
	
	private String address_web;
	
	@OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
	private Set<Etudiant> etudiants;
	
	public Departement() {
		
	}
	
}
