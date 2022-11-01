package com.wheeler.quarkus.service;

import com.wheeler.quarkus.dao.model.Session;
import com.wheeler.quarkus.dao.repository.SessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(final SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public Optional<Session> create(final Session session){
        log.info("SessionService create: {}", session);

        final String code = session.getCode();
        final boolean exists = retrieve(code).isPresent();
        if(exists){
            return Optional.empty();
        }
        sessionRepository.persist(session);
        return retrieve(code);
    }

    public List<Session> retrieve(){
        log.info("SessionService retrieve");
        return sessionRepository.findAll().stream().toList();
    }

    public Optional<Session> retrieve(final String code){
        log.info("SessionService retrieve: {}", code);
        return sessionRepository.findByIdOptional(code);
    }

    public void delete(final String code){
        log.info("SessionService delete: {}", code);
        sessionRepository.deleteById(code);
    }
}
