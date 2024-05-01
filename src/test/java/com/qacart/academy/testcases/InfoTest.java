package com.qacart.academy.testcases;

import io.restassured.http.Header;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasEntry;

public class InfoTest {
    @Test
    public void shouldBeAbleToGetCoursesInfo1() {
        System.out.println("Test Case 1");

        given()
                .baseUri("https://todo.qacart.com")
                .headers("type", "WEB","language", "JAVA")
                .log().all()
        .when()
                .get("api/v1/info/courses")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    @Test
    public void shouldBeAbleToGetCoursesInfo() {
        System.out.println("Test Case 2");

        Header typeHeader = new Header("type", "WEB");

        given()
                .baseUri("https://todo.qacart.com")
                .header(typeHeader)
                .log().all()
        .when()
                .get("api/v1/info/courses")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }
}
