package com.purgomalum;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.purgomalum.Constants.BASE_URI;
import static com.purgomalum.Constants.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class JsonServiceTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = JSON;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    void responseShouldReturnTextAsResultInJson() {
        String text = "this is some test input";
        given()
                .param(TEXT, text)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schema.json"))
                .body("result", equalTo(text));
    }


    @Test
    void shouldAddWordToProfanityListAndReplaceWordWithFillChar() {
        String text = "this is a test task";
        String add = "test";
        String fillChar = "*";

        given()
                .param(TEXT, text)
                .param(ADD, add)
                .param(FILL_CHAR, fillChar)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("result", equalTo("this is a **** task"));
    }

    @Test
    void shouldReturnCharacterLimitError() {
        String text = "this is a test task";
        String fillText = "this is curiously long replacement text";

        given()
                .param(TEXT, text)
                .param(FILL_TEXT, fillText)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("error", equalTo("User Replacement Text Exceeds Limit of 20 Characters."));
    }
}
