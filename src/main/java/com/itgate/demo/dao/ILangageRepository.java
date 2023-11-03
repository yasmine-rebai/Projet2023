package com.itgate.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itgate.demo.models.Langage;

@Repository
public interface ILangageRepository  extends JpaRepository<Langage,Long> {
}
