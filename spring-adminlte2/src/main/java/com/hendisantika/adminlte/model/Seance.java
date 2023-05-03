package com.hendisantika.adminlte.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
    
    @Column(name = "date_projection")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date_projection;
    
    @Column(name="heure_debut")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date heure_debut;
    
    @Column(name="heure_fin")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date heure_fin;
    
    @ManyToOne
    @JoinColumn(name="FILM_ID")
    private Film film;
    
    @OneToOne
    @JoinColumn(name="SALLE_ID")
    private Salle salle;
}
