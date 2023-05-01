package com.hendisantika.adminlte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hendisantika.adminlte.model.Film_rating;

@Repository
public interface Film_ratingRepository extends JpaRepository<Film_rating, Long> {

}
