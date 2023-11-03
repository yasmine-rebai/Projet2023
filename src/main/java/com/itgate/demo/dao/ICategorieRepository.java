package com.itgate.demo.dao;

import com.itgate.demo.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategorieRepository extends JpaRepository<Categorie,Long> {
}
