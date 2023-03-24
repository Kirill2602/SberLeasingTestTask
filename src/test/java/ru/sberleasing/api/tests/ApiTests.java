package ru.sberleasing.api.tests;

import org.junit.jupiter.api.Test;
import ru.sberleasing.api.models.createuser.SuccessfulResponse;
import ru.sberleasing.api.models.createuser.User;
import ru.sberleasing.api.specifications.Specs;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sberleasing.api.endpoints.EndPoints.*;
import static ru.sberleasing.api.helper.TestBuilders.buildUser;

public class ApiTests {
    Specs specs = new Specs();
    SuccessfulResponse successfulResponse;
    User user;

    @Test
    void createUserTest() {
        step("Создание нового пользователя", () -> {
            successfulResponse = given(specs.requestSpec)
                    .body(buildUser("User", "testUser@mail.com"))
                    .when()
                    .post(CREATE_USER_ENDPOINT)
                    .then()
                    .spec(specs.responseSpec(200))
                    .extract().as(SuccessfulResponse.class);
        });

        step("Проверка статуса в ответе", () -> {
            assertEquals(200, successfulResponse.getCode());
        });
        step("Проверка типа в ответе", () -> {
            assertEquals("unknown", successfulResponse.getType());
        });
        step("Проверка сообщения в ответе", () -> {
            assertEquals("1", successfulResponse.getMessage());
        });
    }

    @Test
    void updateUserTest() {
        step("Создание нового пользователя", () -> {
            successfulResponse = given(specs.requestSpec)
                    .pathParam("username", "TestUserName")
                    .body(buildUser("TestUser", "testUser123@mail.com"))
                    .when()
                    .put(UPDATE_USER_ENDPOINT)
                    .then()
                    .spec(specs.responseSpec(200))
                    .extract().as(SuccessfulResponse.class);
        });

        step("Проверка статуса в ответе", () -> {
            assertEquals(200, successfulResponse.getCode());
        });
        step("Проверка типа в ответе", () -> {
            assertEquals("unknown", successfulResponse.getType());
        });
        step("Проверка сообщения в ответе", () -> {
            assertEquals("1", successfulResponse.getMessage());
        });
    }

    @Test
    void getUserTest() {
        step("Получить данные пользователя", () -> {
            user = given(specs.requestSpec)
                    .pathParam("username", "TestUserName")
                    .when()
                    .get(GET_USER_ENDPOINT)
                    .then()
                    .spec(specs.responseSpec(200))
                    .extract().as(User.class);
        });
        step("Проверка имени пользователя в ответе", () -> {
            assertEquals("TestUserName", user.getUsername());
        });
        step("Проверка адреса электронной почты в ответе", () -> {
            assertEquals("testUser@mail.com", user.getEmail());
        });
        step("Проверка имени в ответе", () -> {
            assertEquals("User", user.getFirstName());
        });
        step("Проверка номера телефона в ответе", () -> {
            assertEquals("89677776677", user.getPhone());
        });
    }

    @Test
    void deleteUserTest() {
        step("Удалить пользователя", () -> {
            successfulResponse = given(specs.requestSpec)
                    .pathParam("username", "TestUserName")
                    .when()
                    .delete(DELETE_USER_ENDPOINT)
                    .then()
                    .log().all()
                    .spec(specs.responseSpec(200))
                    .extract().as(SuccessfulResponse.class);
        });

        step("Проверка статуса в ответе", () -> {
            assertEquals(200, successfulResponse.getCode());
        });
        step("Проверка типа в ответе", () -> {
            assertEquals("unknown", successfulResponse.getType());
        });
        step("Проверка сообщения в ответе", () -> {
            assertEquals("TestUserName", successfulResponse.getMessage());
        });
    }
}
