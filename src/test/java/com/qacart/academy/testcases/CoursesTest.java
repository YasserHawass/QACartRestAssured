package com.qacart.academy.testcases;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * The type Courses test.
 */
public class CoursesTest {
    /**
     * Should be able to get course details 1.
     */
    @Test
    public void shouldBeAbleToGetCourseDetails1() {
        System.out.println("Test Case 1");

        given()
                .baseUri("https://todo.qacart.com")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY2MjFiNWJmYTI5MzRhMDAxNDI4ZDRhNyIsImZpcnN0TmFtZSI6IkhhdGVtIiwiaWF0IjoxNzE0ODU1NTgxfQ.IxOjsMEL57ciAnGpSpBIzciUfZsVmnovayIlR9Rb07I")
        .when()
                .get("api/v1/courses")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Should be able to get course details 2.
     */
    @Test
    public void shouldBeAbleToGetCourseDetails2() {
        System.out.println("Test Case 2");

        given()
                .baseUri("https://todo.qacart.com")
                .auth().oauth2("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY2MjFiNWJmYTI5MzRhMDAxNDI4ZDRhNyIsImZpcnN0TmFtZSI6IkhhdGVtIiwiaWF0IjoxNzE0ODU1NTgxfQ.IxOjsMEL57ciAnGpSpBIzciUfZsVmnovayIlR9Rb07I")
                .when()
                .get("api/v1/courses")
                .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }
}
