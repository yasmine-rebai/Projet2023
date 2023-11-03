package com.itgate.demo.dao;

import com.itgate.demo.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository  extends JpaRepository<Country,Long> {
}
