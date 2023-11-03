package com.itgate.demo.dao;


import com.itgate.demo.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestRepository extends JpaRepository<Test,Long> {

}
