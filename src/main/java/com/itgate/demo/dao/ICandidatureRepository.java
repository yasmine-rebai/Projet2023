package com.itgate.demo.dao;

import com.itgate.demo.models.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICandidatureRepository extends JpaRepository<Candidature,Long> {
}
