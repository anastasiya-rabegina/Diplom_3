package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage extends Header{

    final public static String URL = "https://stellarburgers.nomoreparties.site/";

    //локатор для заголовка Соберите бургер
    @FindBy(how = How.XPATH, using = "//h1")
    private SelenideElement textSoberiteBurger;

    //локатор для кнопки Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement btnLoginMainPage;

    //локатор для кнопки Оформить заказ
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement btnCreateOrder;

    //локатор для кнопки Булки
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement btnBuns;

    //локатор для заголовка Булки
    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    private SelenideElement headerBuns;

    //локатор для кнопки Соусы
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement btnSauces;

    //локатор для заголовка Соусы
    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    private SelenideElement headerSauces;

    //локатор для кнопки Начинки
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement btnFillings;

    //локатор для заголовка Начинки
    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    private SelenideElement headerFillings;


    @Step("Make sure text 'Соберите бургер' is visible")
    public MainPage checkPageIsLoaded() {
        textSoberiteBurger.shouldBe(Condition.visible);
        return this;
    }

    @Step("Click on 'Login to account' on Main Page to go to Login Page")
    public LoginPage clickGoToLogin() {
        btnLoginMainPage.click();
        return page(LoginPage.class);
    }

    @Step("Check if button 'Create Order' is displayed")
    public boolean isCreateOrderDisplayed() {
        return btnCreateOrder.isDisplayed();
    }

    @Step("Check if Constructor with Ingredients is displayed")
    public boolean isConstructorDisplayed() {
//        textSoberiteBurger.shouldBe(Condition.visible);
        return textSoberiteBurger.isDisplayed();
    }

    @Step("Click on Buns button to scroll to Buns")
    public MainPage clickBtnBuns() {
        btnBuns.click();
        return this;
    }

    @Step("Check list is scrolled to Buns")
    public boolean checkBunsAreShown() {
        return headerBuns.isDisplayed();
    }

    @Step("Click on Sauces button to scroll to Sauces")
    public MainPage clickBtnSauces() {
        btnSauces.click();
        return this;
    }
    @Step("Check list is scrolled to Sauces")
    public boolean checkSaucesAreShown() {
        return headerSauces.isDisplayed();
    }

    @Step("Click on Fillings button to scroll to Fillings")
    public MainPage clickBtnFillings() {
        btnFillings.click();
        return this;
    }

    @Step("Check list is scrolled to Fillings")
    public boolean checkFillingsAreShown() {
        return headerFillings.isDisplayed();
    }
}