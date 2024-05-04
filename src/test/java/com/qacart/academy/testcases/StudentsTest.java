package com.qacart.academy.testcases;

import com.qacart.academy.pojo.LoginPojo;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * The type Students test.
 */
public class StudentsTest {
    /**
     * Should be able to login to the application 1.
     */
    @Test
    public void shouldBeAbleToLoginToTheApplication1() {
        System.out.println("Test Case 1");

        String body = "{\n" +
                "    \"email\" : \"hatem@example.com\",\n" +
                "    \"password\": \"Test1234\"\n" +
                "}";

        given()
                .baseUri("https://todo.qacart.com")
                .header("Content-Type", "application/json")
                .body(body)
                .log().all()
        .when()
                .post("api/v1/students/login")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Should be able to login to the application 2.
     */
    @Test
    public void shouldBeAbleToLoginToTheApplication2() {
        System.out.println("Test Case 2");

        String body = "{\n" +
                "    \"email\" : \"hatem@example.com\",\n" +
                "    \"password\": \"Test1234\"\n" +
                "}";

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .post("api/v1/students/login")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Should be able to login to the application 3.
     */
    @Test
    public void shouldBeAbleToLoginToTheApplication3() {
        System.out.println("Test Case 3");

        File body = new File("src/test/resources/login.json");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .post("api/v1/students/login")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Should be able to login to the application 4.
     */
    @Test
    public void shouldBeAbleToLoginToTheApplication4() {
        System.out.println("Test Case 4");

        HashMap <String, String> body = new HashMap<>();

        body.put("email", "hatem@example.com");
        body.put("password", "Test1234");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .post("api/v1/students/login")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Should be able to login to the application 5.
     */
    @Test
    public void shouldBeAbleToLoginToTheApplication5() {
        System.out.println("Test Case 5");

        //LoginPojo body = new LoginPojo();

        //body.setEmail("hatem@example.com");
        //body.setPassword("Test1234");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                //.body(body)
                .log().all()
        .when()
                .post("api/v1/students/login")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Should be able to login to the application 6.
     */
    @Test
    public void shouldBeAbleToLoginToTheApplication6() {
        System.out.println("Test Case 6");

        LoginPojo body = new LoginPojo("hatem@example.com", "Test1234");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
        .when()
                .post("api/v1/students/login")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Should be able to login to the application 7.
     */
    @Test
    public void shouldBeAbleToLoginToTheApplication7() {
        System.out.println("Test Case 7");

        HashMap<String, String> formParam = new HashMap<>();

        formParam.put("Foo", "1234");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.URLENC)
                //.formParam(formParam)
                .log().all()
        .when()
                .post("api/v1/students/login")
        .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Should be able to login to the application 8.
     */
    @Test
    public void shouldBeAbleToLoginToTheApplication8() {
        System.out.println("Test Case 8");

        File json = new File("src/test/resources/login.json");

        given()
                .baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .multiPart("file", json)
                .log().all()
                .when()
                .post("api/v1/students/login")
                .then()
                .log().all()
                .assertThat().statusCode(200);

        System.out.println("-------------------------------------------------------------------");
    }
}
