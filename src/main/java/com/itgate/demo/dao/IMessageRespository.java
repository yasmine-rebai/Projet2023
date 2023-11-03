package com.itgate.demo.dao;

import com.itgate.demo.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRespository extends JpaRepository<Message,Long> {
}
