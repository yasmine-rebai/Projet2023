package com.itgate.demo.dao;

import com.itgate.demo.models.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICandidatRepository extends JpaRepository<Candidat,Long> {
}
