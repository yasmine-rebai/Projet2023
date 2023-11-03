package com.itgate.demo.dao;

import com.itgate.demo.models.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompetenceRepository extends JpaRepository<Competence,Long> {
}
