package com.hendisantika.adminlte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hendisantika.adminlte.model.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long>{

}
