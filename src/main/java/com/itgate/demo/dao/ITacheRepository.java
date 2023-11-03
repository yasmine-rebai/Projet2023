package com.itgate.demo.dao;

import com.itgate.demo.models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITacheRepository extends JpaRepository<Tache,Long> {
}
