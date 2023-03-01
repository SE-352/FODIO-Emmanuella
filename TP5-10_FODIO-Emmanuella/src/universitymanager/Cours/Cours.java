/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanager.Cours;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import universitymanager.Etudiant.Etudiant;


@Entity
public class Cours implements Serializable {

    @Id
    private Long ID;

    @Column(length = 60, nullable = false)
    private String libelle;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;
    
    @ManyToMany(mappedBy = "cours")
    @JoinTable(name = "etudiants_cours",joinColumns = 
            @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id"))
    private Set<Etudiant> etudiant;

    public Cours() {
    }

    public Cours(String libelle, Date dateCreation) {
        this.libelle = libelle;
        this.dateCreation = dateCreation;
    }

    public String getLibelle() {
        return libelle;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Set<Etudiant> getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Set<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

}
