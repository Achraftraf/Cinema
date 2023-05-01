package com.hendisantika.adminlte.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seance extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "date_projection", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date date_projection;
    
    @Column(name="heure_debut")
    private Time heure_debut;
    
    @Column(name="heure_fin")
    private Time heure_fin;
    
    @ManyToOne
    @JoinColumn(name="FILM_ID")
    private Film film;
    
    @OneToOne
    @JoinColumn(name="SALLE_ID")
    private Salle salle;
}
