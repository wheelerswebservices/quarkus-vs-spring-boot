package com.wheeler.quarkus.controller;

import com.wheeler.quarkus.dao.model.Session;
import com.wheeler.quarkus.service.SessionService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;


@Path("session/")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(final SessionService sessionService){
        this.sessionService = sessionService;
    }

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Session create(Session request) {
        final Optional<Session> session = sessionService.create(request);
        if(session.isPresent()){
            return session.get();
        }
        // httpResponse.setStatus(HttpStatus.CONFLICT.value());
        return null;
    }

    @POST
    @Path("retrieve")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Session> retrieve() {
        return sessionService.retrieve();
    }

    @GET
    @Path("retrieve/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Session retrieve(@PathParam("code") String code) {
        final Optional<Session> session = sessionService.retrieve(code);
        if(session.isPresent()){
            return session.get();
        }
        // httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
        return null;
    }

    @DELETE
    @Path("delete/{code}")
    public void delete(@PathParam("code") String code) {
        sessionService.delete(code);
        // httpResponse.setStatus(HttpStatus.NO_CONTENT.value());
    }
}
