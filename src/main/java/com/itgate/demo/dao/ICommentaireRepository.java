package com.itgate.demo.dao;

import com.itgate.demo.models.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentaireRepository extends JpaRepository<Commentaire,Long> {
}
