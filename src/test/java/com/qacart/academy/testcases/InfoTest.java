package com.qacart.academy.testcases;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;

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
    public void shouldBeAbleToGetCoursesInfo2() {
        System.out.println("Test Case 2");

        Header typeHeader = new Header("type", "WEB");
        Header languageHeader = new Header("language", "JAVA");

        given()
                .baseUri("https://todo.qacart.com")
                .header(typeHeader)
                .header(languageHeader)
                .log().all()
        .when()
                .get("api/v1/info/courses")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    @Test
    public void shouldBeAbleToGetCoursesInfo3() {
        System.out.println("Test Case 3");

        Header typeHeader = new Header("type", "WEB");
        Header languageHeader = new Header("language", "JAVA");

        Headers infoHeaders = new Headers(typeHeader, languageHeader);

        given()
                .baseUri("https://todo.qacart.com")
                .headers(infoHeaders)
                .log().all()
        .when()
                .get("api/v1/info/courses")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    @Test
    public void shouldBeAbleToGetCoursesInfo4() {
        System.out.println("Test Case 4");

        HashMap<String, String> infoHeaders = new HashMap<>();
        infoHeaders.put("type", "WEB");
        infoHeaders.put("language", "JAVA");

        given()
                .baseUri("https://todo.qacart.com")
                .headers(infoHeaders)
                .log().all()
                .when()
                .get("api/v1/info/courses")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("count", is(equalTo(1)));

        System.out.println("-------------------------------------------------------------------");
    }
}
