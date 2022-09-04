package ru.yandex.practicum.helpers;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.yandex.practicum.entity.User;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/auth/";

    @Step("Авторизация пользователя")
    public Response loginUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_URL + "login");
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String accessToken){
        return   given()
                .contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .delete(BASE_URL + "user");

    }
}
