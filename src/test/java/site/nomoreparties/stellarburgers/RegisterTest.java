package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.Header;
import site.nomoreparties.stellarburgers.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;

public class RegisterTest extends BaseTest {

    private User user;

    @After
    public void logOut() {
        page(Header.class)
                .finish();
    }

    @DisplayName("Too short password shows an error")
    @Test
    public void incorrectPass() {
        user = User.getRandomUser(1, 5);
        Selenide.open(RegistrationPage.URL, RegistrationPage.class)
                .fillInPassword(user.getPassword())
                .clickRegister();
        assertEquals(page(RegistrationPage.class).getExpectedErrorPass(), page(RegistrationPage.class).getErrorPassword());
    }

    @DisplayName("User can register from registration page")
    @Test
    public void registerUser1() {
        user = User.getRandomUser();
        System.out.println(user);
        String actual = Selenide.open(RegistrationPage.URL, RegistrationPage.class)
                .registerUser(user)
                .loginUser(user)
                .clickPersonalCabinet()
                .checkUserName();
        assertEquals(user.getName(), actual);
    }
}