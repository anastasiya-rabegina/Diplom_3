package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import site.nomoreparties.stellarburgers.User;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends Header {

    final public static String URL = "https://stellarburgers.nomoreparties.site/register";

    final String expectedErrorPass = "Некорректный пароль";

    //локаторы для полей ввода: 0 - Имя, 1 - Email
    @FindBy(how = How.NAME, using = "name")
    private ElementsCollection inputFields;

    //локатор для поля ввода Пароль
    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private SelenideElement inputPassword;

    //локатор для кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement btnRegisterRegPage;

    //локатор для текст ошибки при вводе короткого пароля
    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement textIncorrectPassword;

    //локатор для кнопки Войти
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement btnLoginRegPage;

    public RegistrationPage fillInName(String name) {
        inputFields.get(0).sendKeys(name);
        return this;
    }

    public RegistrationPage fillInEmail(String email) {
        inputFields.get(1).sendKeys(email);
        return this;
    }

    @Step("Fill in password")
    public RegistrationPage fillInPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public RegistrationPage fillInFields(String name, String email, String password) {
        inputFields.get(0).sendKeys(name);
        inputFields.get(1).sendKeys(email);
        inputPassword.sendKeys(password);
        return this;
    }

    public RegistrationPage fillInFields(User user) {
        inputFields.get(0).sendKeys(user.getName());
        inputFields.get(1).sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        return this;
    }

    @Step("Click on Register button")
    public RegistrationPage clickRegister() {
        btnRegisterRegPage.click();
        return this;
    }

    public LoginPage clickRegisterSuccessfully() {
        btnRegisterRegPage.click();
        return page(LoginPage.class);
    }

    @Step("Register user")
    public LoginPage registerUser(User user) {
        fillInFields(user);
        clickRegisterSuccessfully();
        return page(LoginPage.class);
    }

    public String getErrorPassword() {
        return textIncorrectPassword.getText();
    }

    public String getExpectedErrorPass() {
        return expectedErrorPass;
    }

    @Step("Click 'Login' on Registration Page to go to Login Page")
    public LoginPage clickBtnLoginRegPage() {
        btnLoginRegPage.click();
        return page(LoginPage.class);
    }
}