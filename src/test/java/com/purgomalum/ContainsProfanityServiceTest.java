package com.purgomalum;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.purgomalum.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ContainsProfanityServiceTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = CONTAINS_PROFANITY;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    void shouldReturnFalseIfTextDoesNotContainsProfanity() {
        given()
                .param(TEXT, "this is some test without profanity")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(equalTo("false"));
    }


    @Test
    void shouldReturnTrueIfTextContainsProfanity() {
        given()
                .param(TEXT, "this is shit")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(equalTo("true"));
    }

    @Test
    void shouldReturnTrueForNewlyAddedProfanityWord() {
        given()
                .param(TEXT, "this is a mercedes benz")
                .param(ADD, "mercedes")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(equalTo("true"));
    }
}
