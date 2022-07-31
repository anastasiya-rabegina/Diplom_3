package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.Header;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.MainPage;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class PersonalCabinetTest extends BaseTest {

    private final User user = new User("luis.gibson@example.com", "ikslz1tc", "Latoria");

    @After
    public void logOut() {
        page(Header.class)
                .finish();
    }

    @DisplayName("Non-authorized user is redirected to Login page after clicking on Personal Cabinet")
    @Test
    public void personalCabinetRedirectsToLoginPage() {
        boolean actual = Selenide.open(MainPage.URL, MainPage.class)
                .clickPersonalCabinetGoToLogin()
                .isLoginButtonDisplayed();
        assertTrue(actual);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(LoginPage.URL, currentUrl);
    }

    @DisplayName("Authorized user is redirected Personal Cabinet page after clicking on Personal Cabinet")
    @Test
    public void personalCabinetRedirectTo() {
        boolean actual = Selenide.open(LoginPage.URL, LoginPage.class)
                .loginUser(user)
                .clickPersonalCabinet()
                .isPersonalCabinetDisplayed();
        assertTrue(actual);
    }

    @DisplayName("Authorized user can logout")
    @Test
    public void logOutUser() {
        boolean actual = Selenide.open(LoginPage.URL, LoginPage.class)
                .loginUser(user)
                .clickPersonalCabinet()
                .clickLogOut()
                .isLoginButtonDisplayed();
        assertTrue(actual);
    }
}