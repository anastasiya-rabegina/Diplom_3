package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage extends Header {

    final public static String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //локатор для кнопки Восстановить пароль
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement btnLoginForgotPassPage;

    @Step("Click 'Login' on Forgot Password Page to go to Login Page")
    public LoginPage clickBtnLoginForgotPassPage() {
        btnLoginForgotPassPage.click();
        return page(LoginPage.class);
    }
}