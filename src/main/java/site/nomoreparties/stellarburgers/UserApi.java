package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String REGISTER = "/auth/register";
    private static final String LOGIN = "/auth/login";
    private static final String ROOT = "/auth/user";

    private static String token;

    @Step("Register user")
    public static Response registerUser(User user) {
        return given()
                .header("Content-Type", "application/json")
                .and()
                .body(user)
                .when()
                .post(REGISTER);
    }

    @Step("Delete user")
    public static void deleteUser(String token) {
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .when()
                .delete(ROOT);
    }

    @Step("Register user and get token")
    public static String getToken(User user) {
        token = UserApi.registerUser(user)
                .then()
                .extract().body().path("accessToken");
        return token;
    }
}