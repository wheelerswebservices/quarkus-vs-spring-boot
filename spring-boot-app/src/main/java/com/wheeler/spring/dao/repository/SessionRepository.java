package com.wheeler.spring.dao.repository;

import com.wheeler.spring.dao.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, String> { }
