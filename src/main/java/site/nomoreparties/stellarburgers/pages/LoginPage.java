package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import site.nomoreparties.stellarburgers.User;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends Header {

    final public static String URL = "https://stellarburgers.nomoreparties.site/login";

    //локатор для поля ввода Email
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement inputName;

    //локатор для поля ввода Пароль
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement inputPassword;

    //локатор для кнопки Войти
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement btnLogin;

    public MainPage clickLogin() {
        btnLogin.click();
        return page(MainPage.class);
    }

    public LoginPage fillInFields(User user) {
        inputName.click();
        inputPassword.click();
        inputName.click();
        inputName.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        return this;
    }

    @Step("Fill in credentials and login")
    public MainPage loginUser(User user) {
        fillInFields(user);
        clickLogin();
        page(MainPage.class).checkPageIsLoaded();
        return page(MainPage.class);
    }

    @Step("Check if Login button is displayed")
    public boolean isLoginButtonDisplayed() {
        btnLogin.shouldBe(Condition.visible);
        return btnLogin.isDisplayed();
    }
}