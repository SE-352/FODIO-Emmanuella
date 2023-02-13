/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanager.Etudiant.Professeur;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import universitymanager.Personne.Personne;


@Entity
public class Professeur extends Personne implements Serializable{

    private String grade;

    public Professeur() {
    }

    public Professeur(String grade) {
        this.grade = grade;
    }

    public Professeur(String grade, Long id, String nom, String prenom, String email) {
        super(id, nom, prenom, email);
        this.grade = grade;
    }
    

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
