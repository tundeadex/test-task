package com.purgomalum;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.purgomalum.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class XmlServiceTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = XML;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    void responseShouldReturnTextAsResultInXml() {
        String text = "this is some xml test input";
        given()
                .param(TEXT, text)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("PurgoMalum.result", equalTo("this is some xml test input"));
    }

    @Test
    void shouldAddWordToProfanityListAndReplaceWordWithFillChar() {
        String text = "this is a test task";
        String add = "this";
        String fillChar = "*";

        given()
                .param(TEXT, text)
                .param(ADD, add)
                .param(FILL_CHAR, fillChar)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("PurgoMalum.result", equalTo("**** is a test task"));
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
                .body("PurgoMalum.error", equalTo("User Replacement Text Exceeds Limit of 20 Characters."));
    }
}

