/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intervention;

import javax.persistence.Embeddable;

/**
 *
 * @author MATHURINS KIBALO
 */
@Embeddable
public class InterventionPK {
    private Long coursId;
    private Long departementId;
    private Long professeurId;

    public InterventionPK() {
    }

    public InterventionPK(Long coursId, Long departementId, Long professeurId) {
        this.coursId = coursId;
        this.departementId = departementId;
        this.professeurId = professeurId;
    }

    public Long getCoursId() {
        return coursId;
    }

    public void setCoursId(Long coursId) {
        this.coursId = coursId;
    }

    public Long getDepartementId() {
        return departementId;
    }

    public void setDepartementId(Long departementId) {
        this.departementId = departementId;
    }

    public Long getProfesseurId() {
        return professeurId;
    }

    public void setProfesseurId(Long professeurId) {
        this.professeurId = professeurId;
    }
    
    
    
}
