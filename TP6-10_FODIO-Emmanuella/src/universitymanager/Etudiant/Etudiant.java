/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanager.Etudiant;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import universitymanager.Cours.Cours;
import universitymanager.Departement.Departement;
import universitymanager.Personne.Personne;


@Entity
@Table(name = "Etudiants")
public class Etudiant extends Personne implements Serializable{
    @Column
    private String adresse;
    @Column(length = 120)
    private String tel;
    
    @ManyToOne()
    @JoinColumn(name = "departement_id")
    private Departement departement;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
        @JoinTable(name = "cours",joinColumns = 
            @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id"))
    private Set<Cours> cours;

    public Etudiant(String adresse, String tel) {
        this.adresse = adresse;
        this.tel = tel;
    }

    public Etudiant(String adresse, String tel, Long id, String nom, String prenom, String email) {
        super(id, nom, prenom, email);
        this.adresse = adresse;
        this.tel = tel;
    }
    
    public Etudiant() {
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
