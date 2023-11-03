package com.itgate.demo.dao;

import com.itgate.demo.models.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocieteRepository extends JpaRepository<Societe,Long> {
}
