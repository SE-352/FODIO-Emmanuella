/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intervention;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import universitymanager.Cours.Cours;
import universitymanager.Departement.Departement;
import universitymanager.Etudiant.Professeur.Professeur;

/**
 *
 * @author MATHURINS KIBALO
 */
@Entity
public class Intervention {
    @EmbeddedId
    private InterventionPK id;
    
    @ManyToOne
    private Departement departement;
    
    @ManyToOne
    private Cours cours;
    
    @ManyToOne
    private Professeur professeur;
    
    public Intervention(){
        this.id.setCoursId(this.cours.getID());
        this.id.setDepartementId(this.departement.getID());
        this.id.setProfesseurId(this.professeur.getId());
    }
    
    public InterventionPK getId(){
        return id;
    }
}
