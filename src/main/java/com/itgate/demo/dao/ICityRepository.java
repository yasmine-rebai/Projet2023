package com.itgate.demo.dao;

import com.itgate.demo.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository  extends JpaRepository<City,Long> {
}
