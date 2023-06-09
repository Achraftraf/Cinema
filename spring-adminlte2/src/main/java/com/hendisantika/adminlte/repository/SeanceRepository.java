package com.hendisantika.adminlte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hendisantika.adminlte.model.Seance;

@Repository
public interface SeanceRepository  extends JpaRepository<Seance, Long> {

}
