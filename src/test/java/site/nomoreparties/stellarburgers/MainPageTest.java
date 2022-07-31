package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.Header;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.MainPage;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class MainPageTest extends BaseTest {

    private final User user = new User("luis.gibson@example.com", "ikslz1tc", "Latoria");

    @After
    public void logOut() {
        page(Header.class)
                .finish();
    }

    @DisplayName("Constructor button redirects from Personal cabinet to Main Page")
    @Test
    public void btnConstructorRedirectsToConstructor() {
        boolean actual = Selenide.open(LoginPage.URL, LoginPage.class)
                .loginUser(user)
                .clickPersonalCabinet()
                .clickBtnConstructorHeader()
                .isConstructorDisplayed();
        assertTrue(actual);
    }

    @DisplayName("Logo redirects from Personal cabinet to Main Page")
    @Test
    public void logoRedirectsToConstructor() {
        boolean actual = Selenide.open(LoginPage.URL, LoginPage.class)
                .loginUser(user)
                .clickLogoHeader()
                .isConstructorDisplayed();
        assertTrue(actual);
    }

    @DisplayName("Click on Ingredients name scrolls to ingredients list")
    @Test
    public void bunsButtonScrollsToBuns() {
        boolean actual = Selenide.open(MainPage.URL, MainPage.class)
                .checkPageIsLoaded()
                .clickBtnFillings()
                .clickBtnBuns()
                .checkBunsAreShown();
        assertTrue(actual);
    }

    @Test
    public void saucesButtonScrollsToSauces() {
        boolean actual = Selenide.open(MainPage.URL, MainPage.class)
                .checkPageIsLoaded()
                .clickBtnSauces()
                .checkSaucesAreShown();
        assertTrue(actual);
    }

    @Test
    public void fillingsButtonScrollsToFillings() {
        boolean actual = Selenide.open(MainPage.URL, MainPage.class)
                .checkPageIsLoaded()
                .clickBtnFillings()
                .checkFillingsAreShown();
        assertTrue(actual);
    }

}