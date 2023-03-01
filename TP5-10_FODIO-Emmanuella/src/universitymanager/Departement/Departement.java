/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanager.Departement;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import universitymanager.Etudiant.Etudiant;


@Entity
public class Departement {
    @Id
    private Long ID;
    @Column(length = 60)
    private String nom;
    @Column(length = 120)
    private String adresseWeb;
    
    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY /*Pour ne pas charger les etudiants lorsqu'on recupère un departement*/)
    private Set<Etudiant> etudiants;

    public Departement() {
    }

    public Departement(String nom, String adresseWeb) {
        this.nom = nom;
        this.adresseWeb = adresseWeb;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresseWeb() {
        return adresseWeb;
    }

    public void setAdresseWeb(String adresseWeb) {
        this.adresseWeb = adresseWeb;
    }
    
    
    
}
