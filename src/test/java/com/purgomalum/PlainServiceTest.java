package com.purgomalum;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.purgomalum.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PlainServiceTest {


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PLAIN;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    void responseShouldReturnTextAsPlain() {
        String text = "this is some plain test input";
        given()
                .param(TEXT, text)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(equalTo(text));
    }

    @Test
    void shouldAddWordToProfanityListAndReplaceWordWithFillChar() {
        String text = "this is a test task";
        String add = "task";
        String fillChar = "_";

        given()
                .param(TEXT, text)
                .param(ADD, add)
                .param(FILL_CHAR, fillChar)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(equalTo("this is a test ____"));
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
                .body(equalTo("User Replacement Text Exceeds Limit of 20 Characters."));
    }
}
