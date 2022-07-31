package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.page;

public class Header {

    //локатор для кнопки Конструктор
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement btnConstructorHeader;

    //локатор для кнопки Лента Заказов
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__linkText__3q_va ml-2")
    private SelenideElement btnOrdersListHeader;

    //локатор для логотипа stellar burgers
    @FindBy(how = How.XPATH, using = "//a[@href='/']")
    private SelenideElement logoHeader;

    //локатор для кнопки Личный кабинет
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private SelenideElement btnPersonalCabinetHeader;

    @Step("Click on 'Personal Cabinet' button on Header to go to Personal Cabinet")
    public PersonalCabinet clickPersonalCabinet() {
        btnPersonalCabinetHeader.click();
        return page(PersonalCabinet.class);
    }

    @Step("Click on 'Personal Cabinet' button on Header to go to Login Page")
    public LoginPage clickPersonalCabinetGoToLogin() {
        btnPersonalCabinetHeader.click();
        return page(LoginPage.class);
    }

    @Step("Click on Constructor button on Header to go to Main Page")
    public MainPage clickBtnConstructorHeader() {
        btnConstructorHeader.click();
        return page(MainPage.class);
    }

    @Step("Click on logo on Header to go to Main Page")
    public MainPage clickLogoHeader() {
        logoHeader.click();
        return page(MainPage.class);
    }

    public void finish() {
        clearBrowserLocalStorage();
    }
}