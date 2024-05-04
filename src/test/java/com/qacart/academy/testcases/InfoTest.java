package com.qacart.academy.testcases;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasEntry;

/**
 * The type Info test.
 */
public class InfoTest {
    /**
     * Should be able to get courses info 1.
     */
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

    /**
     * Should be able to get courses info 2.
     */
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

    /**
     * Should be able to get courses info 3.
     */
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

    /**
     * Should be able to get courses info 4.
     */
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

    /**
     * Should be able to get lectures info 1.
     */
    @Test
    public void shouldBeAbleToGetLecturesInfo1() {
        System.out.println("Test Case 5");

        given()
                .baseUri("https://todo.qacart.com")
                .queryParam("mode", "VIDEO")
                .queryParam("type", "FREE")
                .log().all()
        .when()
                .get("api/v1/info/lectures")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Should be able to get lectures info 2.
     */
    @Test
    public void shouldBeAbleToGetLecturesInfo2() {
        System.out.println("Test Case 6");

        given()
                .baseUri("https://todo.qacart.com")
                .queryParams("mode", "VIDEO","type", "FREE")
                .log().all()
                .when()
                .get("api/v1/info/lectures")
                .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Should be able to get lectures info 3.
     */
    @Test
    public void shouldBeAbleToGetLecturesInfo3() {
        System.out.println("Test Case 7");

        HashMap<String, String> infoParams = new HashMap<>();

        infoParams.put("type", "FREE");
        infoParams.put("mode", "VIDEO");

        given()
                .baseUri("https://todo.qacart.com")
                .queryParams(infoParams)
                .log().all()
        .when()
                .get("api/v1/info/lectures")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }
}
