package com.hendisantika.adminlte.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film_rating extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;

    	
        @Column(nullable = false, length = 50)
        private int score;
        
        @Column(nullable = false, length = 50)
        private String comment;
    	
        @ManyToOne
        @JoinColumn(name = "film_id")
        private Film film;

        @ManyToOne
        @JoinColumn(name = "customer_id")
        private Customers customer;
    	
    	
    	
}
