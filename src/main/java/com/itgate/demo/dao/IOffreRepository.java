package com.itgate.demo.dao;

import com.itgate.demo.models.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOffreRepository extends JpaRepository<Offre,Long> {
}
