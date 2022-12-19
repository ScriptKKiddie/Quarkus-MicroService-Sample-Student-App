package com.oy.tech;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api")
public class StudentResources {

    @Inject
    StudentRepository repository;

    @Inject
    Logger logger;

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int AppSTDCount() {
        logger.info("Counting Students");
        return repository.countAllStudents();
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentApp> AppSTDAll() {
        return repository.getAllStudents();
    }

    @GET()
    @Path("/students/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<StudentApp> AppSTDGetStudent( @PathParam("id") int id) {

        return repository.getStudent(id);
    }

}
