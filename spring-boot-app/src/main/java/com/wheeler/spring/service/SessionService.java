package com.wheeler.spring.service;

import com.wheeler.spring.dao.model.Session;
import com.wheeler.spring.dao.repository.SessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
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
        if(sessionRepository.existsById(session.getCode())){
            return Optional.empty();
        }
        return Optional.of(sessionRepository.save(session));
    }

    public List<Session> retrieve(){
        log.info("SessionService retrieve");
        return sessionRepository.findAll();
    }

    public Optional<Session> retrieve(final String code){
        log.info("SessionService retrieve: {}", code);
        return sessionRepository.findById(code);
    }

    public void delete(final String code){
        log.info("SessionService delete: {}", code);
        sessionRepository.deleteById(code);
    }
}
