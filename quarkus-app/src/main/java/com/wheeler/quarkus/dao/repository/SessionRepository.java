package com.wheeler.quarkus.dao.repository;


import com.wheeler.quarkus.dao.model.Session;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public interface SessionRepository extends PanacheRepositoryBase<Session, String> { }
