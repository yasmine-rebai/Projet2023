package com.itgate.demo.dao;

import com.itgate.demo.models.JobSaved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobSavedRepository extends JpaRepository<JobSaved,Long> {
}
