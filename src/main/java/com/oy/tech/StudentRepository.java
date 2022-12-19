package com.oy.tech;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class StudentRepository {

    public List<StudentApp> getAllStudents() {

        return List.of(
                new StudentApp(1, "Jack", 1111, "Java"),
                new StudentApp(2, "Rahul", 2222, "MicroService")
        );
    }

    public int countAllStudents() {
        return getAllStudents().size();
    }

    public Optional<StudentApp> getStudent( int id) {
        return getAllStudents().stream()
                .filter(StudentApp -> StudentApp.id == id).findFirst();
    }
}
