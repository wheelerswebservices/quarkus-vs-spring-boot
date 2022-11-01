package com.wheeler.spring.controller;

import com.wheeler.spring.dao.model.Session;
import com.wheeler.spring.service.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("session/")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(final SessionService sessionService){
        this.sessionService = sessionService;
    }

    @PostMapping("create")
    public Session create(@RequestBody Session request, HttpServletResponse httpResponse) {
        final Optional<Session> session = sessionService.create(request);
        if(session.isPresent()){
            return session.get();
        }
        httpResponse.setStatus(HttpStatus.CONFLICT.value());
        return null;
    }

    @PostMapping("retrieve")
    public List<Session> retrieve() {
        return sessionService.retrieve();
    }

    @GetMapping("retrieve/{code}")
    public Session retrieve(@PathVariable String code, HttpServletResponse httpResponse) {
        final Optional<Session> session = sessionService.retrieve(code);
        if(session.isPresent()){
            return session.get();
        }
        httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
        return null;
    }

    @DeleteMapping("delete/{code}")
    public void delete(@PathVariable String code, HttpServletResponse httpResponse) {
        sessionService.delete(code);
        httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
    }
}
