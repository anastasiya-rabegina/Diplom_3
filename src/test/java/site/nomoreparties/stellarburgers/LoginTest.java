package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.*;


import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private User user;
    private String token;

    @Before
    public void createUser() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/api";

        user = user.getRandomUser();
        token = UserApi.getToken(user);
    }

    @After
    public void logOut() {
        page(Header.class)
                .finish();
        UserApi.deleteUser(token);
    }

    @DisplayName("User can login by clicking 'Login to account' on Main Page")
    @Test
    public void loginFromMainPage() {
        boolean isLoggedIn = Selenide.open(MainPage.URL, MainPage.class)
                .clickGoToLogin()
                .loginUser(user)
                .isCreateOrderDisplayed();
        assertTrue("User is not logged in", isLoggedIn);
    }

    @DisplayName("User can login by clicking 'Personal Cabinet'")
    @Test
    public void loginFromPersonalCabinet() {
        boolean isLoggedIn = Selenide.open(MainPage.URL, MainPage.class)
                .clickPersonalCabinetGoToLogin()
                .loginUser(user)
                .isCreateOrderDisplayed();
        assertTrue("User is not logged in", isLoggedIn);
    }

    @DisplayName("User can login by clicking 'Login' on Registration Page")
    @Test
    public void loginFromRegistrationForm() {
        boolean isLoggedIn = Selenide.open(RegistrationPage.URL, RegistrationPage.class)
                .clickBtnLoginRegPage()
                .loginUser(user)
                .isCreateOrderDisplayed();
        assertTrue("User is not logged in", isLoggedIn);
    }

    @DisplayName("User can login by clicking 'Login' on Forgot Password Page")
    @Test
    public void loginFromForgotPasswordPage() {
        boolean isLoggedIn = Selenide.open(ForgotPasswordPage.URL, ForgotPasswordPage.class)
                .clickBtnLoginForgotPassPage()
                .loginUser(user)
                .isCreateOrderDisplayed();
        assertTrue("User is not logged in", isLoggedIn);
    }
}