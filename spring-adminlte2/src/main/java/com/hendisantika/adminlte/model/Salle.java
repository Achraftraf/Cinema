package com.hendisantika.adminlte.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Salle extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;

    @Column(name = "added_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date addedDate;
    
    @Column(nullable = false, length = 50)
	private int capacite;
    
    @Column(nullable = false, length = 50)
	private int numero;
    
    @OneToOne(mappedBy="salle")
    private Seance seance;
    
}
