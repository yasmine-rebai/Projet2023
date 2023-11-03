package com.itgate.demo.dao;

import com.itgate.demo.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository  extends JpaRepository<State,Long> {
}
