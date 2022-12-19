package com.oy.tech;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpHead;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class StudentAppTest {

    @Test
    public void shouldAppSTDCount() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .when().get("/api/count")
                .then()
                .statusCode(200)
                .body(is("2"));
    }

}