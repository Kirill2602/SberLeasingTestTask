package ru.sberleasing.api.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static ru.sberleasing.api.endpoints.EndPoints.BASE_URL;
import static ru.sberleasing.api.helper.CustomApiListener.withCustomTemplates;

public class Specs {
    public RequestSpecification requestSpec = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .baseUri(BASE_URL);

    public ResponseSpecification responseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(statusCode)
                .build();
    }
}
