package com.itgate.demo.dao;

import com.itgate.demo.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<Education,Long> {
}
