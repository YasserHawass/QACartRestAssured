package com.qacart;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;


public class TestCase {
    @Test
    public void test1() {
        System.out.println("Test Case 1");

        given().baseUri("https://66322dc2c51e14d695639a13.mockapi.io/api/v1")
            .when().get("users")
            .then().log().all()
            .assertThat().statusCode(200)
            .assertThat().body("[0].name", is(equalTo("Nora Weber")),
                        "name", hasItems("menna", "Nora Weber"),
                        "name", not(hasItem("ahmed")),
                        "country", is(not(empty())),
                        "id", hasSize(10),
                        "createdAt.size()", is(equalTo(10)),
                        "createdAt", everyItem(startsWith("2024")),
                        "[9]", hasEntry("name", "menna"));

        System.out.println("-------------------------------------------------------------------");
    }

    @Test
    public void test2() {
        System.out.println("Test Case 2");

        Response res = given().baseUri("https://66322dc2c51e14d695639a13.mockapi.io")
                        .when().get("/api/v1/users")
                        .then().extract().response();

        String name = res.path("[0].name");
        String name1 = JsonPath.from(res.asString()).getString("[0].name");
        
        System.out.println(name);
        System.out.println(name1);

        System.out.println("-------------------------------------------------------------------");
    }

    @Test
    public void test3() {
        System.out.println("Test Case 3");

        String name = given().baseUri("https://66322dc2c51e14d695639a13.mockapi.io")
                .when().get("/api/v1/users")
                .then().extract().response().path("[0].name");

        System.out.println(name);

        System.out.println("-------------------------------------------------------------------");
    }

    @Test
    public void test4() {
        System.out.println("Test Case 4");

        given().baseUri("https://66322dc2c51e14d695639a13.mockapi.io").log().all()
                .when().get("/api/v1/users")
                .then();

        System.out.println("-------------------------------------------------------------------");
    }

    @Test
    public void test5() {
        System.out.println("Test Case 5");

        given().baseUri("https://66322dc2c51e14d695639a13.mockapi.io/api/v1")
                .when().get("users")
                .then().log().ifValidationFails()
                .assertThat().body("[0].name", is(equalTo("Nora Weber")));

        System.out.println("-------------------------------------------------------------------");
    }
}
