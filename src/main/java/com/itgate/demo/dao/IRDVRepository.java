package com.itgate.demo.dao;

import com.itgate.demo.models.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRDVRepository extends JpaRepository<RDV,Long> {
}
