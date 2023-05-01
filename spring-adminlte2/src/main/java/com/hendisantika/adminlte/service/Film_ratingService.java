package com.hendisantika.adminlte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.hendisantika.adminlte.model.Film_rating;
import com.hendisantika.adminlte.repository.Film_ratingRepository;

@Service
public class Film_ratingService extends AbstractService<Film_rating, Long>  {

	@Autowired
    private Film_ratingRepository film_ratingRepository;

    @Override
    protected JpaRepository<Film_rating, Long> getRepository() {
        return film_ratingRepository;
    }
	
}
