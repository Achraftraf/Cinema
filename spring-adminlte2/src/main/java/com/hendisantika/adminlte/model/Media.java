package com.hendisantika.adminlte.model;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Media extends AbstractModel<Long> {

	private static final long serialVersionUID = -2974953413266908441L;
	public enum TypeMedia {TELE,CINEMA} 

	@Column(name = "added_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date addedDate;
	
	@Column(nullable = false, length = 50)
    private String media;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
    @JsonIgnore
    private Film film;

	
    
    
    
    
    
    
    
	
}
